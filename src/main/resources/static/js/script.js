var roomsList = /*[[${rooms}]]*/[];

document.getElementById('patientDOB').addEventListener('input', function() {
	var today = new Date().toISOString().split('T')[0];
	if (this.value > today) {
		this.value = today;
	}
});

document.getElementById('patientDOB').addEventListener('change', function() {
	var dob = new Date(this.value);
	var today = new Date();
	var age = today.getFullYear() - dob.getFullYear();

	if (today.getMonth() < dob.getMonth() || (today.getMonth() === dob.getMonth() && today.getDate() < dob.getDate())) {
		age--;
	}

	if (age < 18) {
		document.getElementById('underageOrPhysicallyDisabled').checked = true;
		document.getElementById('detailsField').style.display = 'block';
	} else {
		document.getElementById('underageOrPhysicallyDisabled').checked = false;
		document.getElementById('detailsField').style.display = 'none';
	}
});

function populateRoomNumberSelect() {
	var selectRoomType = document.getElementById('availableRoomType');
	var selectRoomNumber = document.getElementById('availableRooms');
	selectRoomNumber.innerHTML = '';
	console.log(roomsList.indexOf(0));
}

function toggleDetailsField() {
	var checkbox = document.getElementById('underageOrPhysicallyDisabled');
	var detailsField = document.getElementById('detailsField');

	if (checkbox.checked) {
		detailsField.style.display = 'block'; // Show details field when checkbox is checked
	} else {
		detailsField.style.display = 'none'; // Hide details field when checkbox is unchecked
	}
}


