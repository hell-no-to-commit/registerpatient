package com.registerpatient.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.registerpatient.entities.HealthPolicyDetails;
import com.registerpatient.entities.Patient;
import com.registerpatient.entities.RoomCapacity;
import com.registerpatient.helper.Message;
import com.registerpatient.repository.CapacityRepository;
import com.registerpatient.repository.HealthPolicyRepository;
import com.registerpatient.repository.PatientRepository;
import com.registerpatient.repository.PolicyRepository;
import com.registerpatient.service.CapacityManager;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	CapacityRepository capacityRepository;

	@Autowired
	HealthPolicyRepository healthPolicyRepository;
	
	@Autowired
	PolicyRepository policyRepository;

	
	// HANDLER FOR HOME PAGE
	@RequestMapping("/")
	public String home(Model model) {
		RoomCapacity rooms = new RoomCapacity();
		model.addAttribute("title", "HOME-Patient Management");
		rooms = capacityRepository.findById(1).get();
		model.addAttribute("rooms", rooms);
		int roomCapacity = 0;
		
		if (rooms.getCount() > 0) {
			roomCapacity = rooms.getCount();
		}
		model.addAttribute("roomCapacity", roomCapacity);
		
		return "home";
	}

	
	// HANDLER FOR ABOUT PAGE
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "ABOUT-Patient Management");
		return "about";
	}

	
	// HANDLER FOR OPENING FORM FOR PATIENT REGISTRATION FORM
	@RequestMapping("/registerPatient")
	public ModelAndView registration(Model model, HttpSession session) {
		CapacityManager capacityManager = null;
		HealthPolicyDetails healthPolicyDetails = null;

		RoomCapacity rooms = new RoomCapacity();

		capacityManager = new CapacityManager();
		rooms = capacityRepository.findById(1).get();
		model.addAttribute("rooms", rooms);
		int roomCapacity = 0;

		if (rooms.getCount() > 0) {
			roomCapacity = rooms.getCount();
		}

		model.addAttribute("roomCapacity", roomCapacity);

		model.addAttribute("title", "REGISTRATION-Patient Management");
		model.addAttribute("patient", new Patient());

		List<HealthPolicyDetails> policyOrgs = this.healthPolicyRepository.findAll();
		model.addAttribute("policyOrgs", policyOrgs);
		System.out.println("roomCapacity: " + roomCapacity);
	
		if (roomCapacity == 0) {
			session.setAttribute("message", new Message("Rooms are not available!!", "alert-danger"));
		}

		return new ModelAndView("registerPatient");
	}

	
	// HANDLER FOR TAKING DETAILS DETAILS FROM PATIENT REGISTRATION FORM
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String successRegistration(@Valid @ModelAttribute("patient") Patient patient, BindingResult result,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {
		try {
			if (!agreement) {
				System.out.println("You haven't agreed the terms and conditions!!");
				throw new Exception("You haven't agreed the terms and conditions!!");
			}
			if (result.hasErrors()) {
				System.out.println("ERROR :" + result.toString());
				model.addAttribute("patient", patient);
				return "registerPatient";
			}
			System.out.println("Agreement " + agreement);
			System.out.println("PATIENT " + patient);
			List<HealthPolicyDetails> policyOrgs = this.healthPolicyRepository.findAll();

			boolean isValidPolicy = false;
			// VALIDATING POLICY
			for (HealthPolicyDetails policy : policyOrgs) {
				if (policy.getPolicyHolderAdhaarNo().equals(patient.getPatientAdhaar())
						&& policy.getPolicyHolderName().equals(patient.getPatientName())
						&& policy.getHealthPolicyNo().equals(patient.getPolicyDetails().getPolicyNumber())
						&& policy.getHealthPolicyOrg().equals(patient.getPolicyDetails().getOrganization())) {

					System.out.println("POLICY FOUND");
					
					isValidPolicy = true;
				}
			}
			RoomCapacity rooms = new RoomCapacity();
			if (isValidPolicy) {
				this.patientRepository.save(patient);
				model.addAttribute("patient", new Patient());
				session.setAttribute("message", new Message("Registered the patient successfully!!", "alert-success"));
				rooms = capacityRepository.findById(1).get();
				int count = rooms.getCount();
				count--;
				rooms.setCount(count);
				capacityRepository.save(rooms);

				return "registerPatient";
			}
			model.addAttribute("patient", patient);
			session.setAttribute("message", new Message("Adhaar or Policy Details are incorrect!!", "alert-warning"));
			return "registerPatient";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("patient", patient);
			session.setAttribute("message", new Message("Something went wrong!!" + e.getMessage(), "alert-danger"));
			return "registerPatient";
		}
	}
	

	// HANDLER FOR SHOWING PATIENT
	// Per page 5 contacts
	@GetMapping("/showPatients/{page}")
	public String showPatients(@PathVariable("page") Integer page, Model model) {

		model.addAttribute("title", "PATIENTS-Patient Management");

		Pageable pageable = PageRequest.of(page, 5);

		Page<Patient> patients = this.patientRepository.findAll(pageable);

		// List<HealthPolicyDetails> policyDetails =
		// this.healthPolicyRepository.findAll();

		model.addAttribute("patients", patients);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", patients.getTotalPages());
		// model.addAttribute("healthPolicyDetails", policyDetails);

		// System.out.println(policyDetails);

		return "showPatients";
	}

	
	// HANDLER FOR SHOWING PARTICULAR PATIENT DETAILS
	@RequestMapping("/patient/{patientId}")
	public String showPatientDetails(@PathVariable("patientId") Integer patientId, Model model) {
		model.addAttribute("title", "PATIENT DETAILS-Patient Management");
		System.out.println("CURRENT PATIENT ID IS: " + patientId);

		Optional<Patient> foundPatient = this.patientRepository.findById(patientId);
		Patient patient = foundPatient.get();

		model.addAttribute("patient", patient);
		model.addAttribute("title", patient.getPatientName());

		return "patientDetails";
	}
	

	// HANDLER FOR OPENING FORM OF UPDATING PATIENT DETAILS
	@PostMapping("/updatePatient/{patientId}")
	public String updatePatientDetails(@PathVariable("patientId") Integer patientId, Model model) {
		model.addAttribute("title", "PATIENT DETAILS-Patient Management");

		Optional<Patient> foundPatient = this.patientRepository.findById(patientId);
		Patient patient = foundPatient.get();
		model.addAttribute("patient", patient);
		return "updatePatient";
	}

	
	// HANDLER FOR PROCESSING FORM OF UPDATING PATIENT DETAILS
	@RequestMapping(value = "/do_update", method = RequestMethod.POST)
	public String successupdation(@ModelAttribute Patient patient, Model model, HttpSession session,
			Principal principal) {

		this.patientRepository.save(patient);

		return "patientDetails";

	}

}
