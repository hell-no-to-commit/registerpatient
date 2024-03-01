package com.registerpatient.controller;

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

import com.registerpatient.entities.Patient;
import com.registerpatient.helper.Message;
import com.registerpatient.repository.PatientRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	PatientRepository patientRepository;

	//HANDLER FOR HOME PAGE
	@RequestMapping("/")
	public String home(Model model) {

		model.addAttribute("title", "HOME-Patient Management");
		return "home";
	}

	//HANDLER FOR ABOUT PAGE
	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "ABOUT-Patient Management");
		return "about";
	}

	//HANDLER FOR PATIENT REGISTRATION FORM
	@RequestMapping("/registerPatient")
	public String registration(Model model) {
		model.addAttribute("title", "REGISTRATION-Patient Management");
		model.addAttribute("patient", new Patient());
		return "registerPatient";
	}

	//HANDLER FOR TAKING DETAILS DETAILS FROM PATIENT REGISTRATION FORM 
	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String successRegistration(@Valid @ModelAttribute("patient") Patient patient, 
			BindingResult result,@RequestParam(value = "agreement", defaultValue = "false") 
			boolean agreement, Model model, HttpSession session) {
		try {
			if(!agreement) {
				System.out.println("You haven't agreed the terms and conditions!!");
				throw new Exception("You haven't agreed the terms and conditions!!");
			}
			if(result.hasErrors()) {
				System.out.println("ERROR :" +result.toString());
				model.addAttribute("patient",patient);
				return "registerPatient";
			}
			System.out.println("Agreement " + agreement);
			System.out.println("PATIENT " + patient);
			Patient savedPatient = this.patientRepository.save(patient);
			model.addAttribute("patient", new Patient());
			session.setAttribute("message", new Message("Registered the patient successfully!!","alert-success"));

			return "registerPatient";
		
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("patient", patient);
			session.setAttribute("message", new Message("Something went wrong!!"+e.getMessage(),"alert-danger"));

			return "registerPatient";
		}
	}
	
	//HANDLER FOR SHOWING PATIENT
	//Per page 5 contacts
	@GetMapping("/showPatients/{page}")
	public String showPatients(@PathVariable("page") Integer page, Model model) {
			
		model.addAttribute("title", "PATIENTS-Patient Management");
		
		Pageable pageable  = PageRequest.of(page, 5);
		
		Page<Patient> patients = this.patientRepository.findAll(pageable);
		
		model.addAttribute("patients",patients);
		model.addAttribute("currentPage", page);
		model.addAttribute("totalPages", patients.getTotalPages());
		
		return "showPatients";
	}
	
	//HANDLER FOR SHOWING PARTICULAR PATIENT DETAILS
	@RequestMapping("/patient/{patientId}")
	public String showPatientDetails(@PathVariable("patientId") Integer patientId, Model model) {
		model.addAttribute("title", "PATIENT DETAILS-Patient Management");
		System.out.println("CURRENT PATIENT ID IS: "+patientId);
		
		Optional<Patient> foundPatient = this.patientRepository.findById(patientId);
		Patient patient = foundPatient.get();
		
		model.addAttribute("patient", patient);
		model.addAttribute("title", patient.getPatientName());
		
		return "patientDetails";
	}
	
	//HANDLER FOR UPDATING PATIENT DETAILS
	@PostMapping("/updatePatient/{patientId}")
	public String updatePatientDetails(@PathVariable("patientId")Integer patientId,Model model) {
		model.addAttribute("title", "PATIENT DETAILS-Patient Management");
		
		Optional<Patient> foundPatient = this.patientRepository.findById(patientId);
		Patient patient = foundPatient.get();
		model.addAttribute("patient",patient);
		return "updatePatient";
	}
}
