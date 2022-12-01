-- CREATE SCHEMA TELEMEDICINE;

CREATE TABLE PATIENT (
	patient_id      VARCHAR(5) NOT NULL PRIMARY KEY,
    patient_name    VARCHAR(45) NOT NULL,
    gender          VARCHAR(1) NOT NULL,
    date_of_birth   DATE NOT NULL,
    blood_group     VARCHAR(5) NOT NULL,
    address         VARCHAR(60) NOT NULL,
    email_id        VARCHAR(60) NOT NULL,
    password        VARCHAR(45) NOT NULL
);

CREATE TABLE PATIENT_CONTACT (
	patient_id      VARCHAR(5) NOT NULL,
    phone_number    VARCHAR(10) NOT NULL,
    PRIMARY KEY(patient_id,phone_number),
    FOREIGN KEY (patient_id) REFERENCES PATIENT(patient_id)
);

CREATE TABLE PATIENT_REPORT (
	patient_id              VARCHAR(5) NOT NULL,
    patient_report_id       VARCHAR(5) NOT NULL,
    symptoms                VARCHAR(100) NOT NULL,
    additional_description  VARCHAR(200),
    diagnosis               VARCHAR(200),
    PRIMARY KEY(patient_id,patient_report_id),
    FOREIGN KEY (patient_id) REFERENCES PATIENT(patient_id)
);

CREATE TABLE DOCTOR (
	doctor_id       VARCHAR(5) NOT NULL PRIMARY KEY,
    doctor_name     VARCHAR(45) NOT NULL,
    gender          VARCHAR(1) NOT NULL,
    specialization  VARCHAR(45) NOT NULL,
    working_hours   VARCHAR(45) NOT NULL,
    email_id        VARCHAR(60) NOT NULL,
    password        VARCHAR(45) NOT NULL
);

CREATE TABLE DOCTOR_CONTACT (
	doctor_id       VARCHAR(5) NOT NULL,
    phone_number    VARCHAR(10) NOT NULL,
    PRIMARY KEY(doctor_id,phone_number),
    FOREIGN KEY (doctor_id) REFERENCES DOCTOR(doctor_id)
);

CREATE TABLE SERVICES (
	service_id      VARCHAR(5) NOT NULL PRIMARY KEY,
    service_name    VARCHAR(45) NOT NULL,
    description     VARCHAR(100) NOT NULL
);

CREATE TABLE SERVICE_DOCTOR_DETAILS (
	service_id      VARCHAR(5) NOT NULL,
    doctor_id       VARCHAR(5) NOT NULL,
    charges         INTEGER(6) NOT NULL,
    availability    VARCHAR(45) NOT NULL,
    PRIMARY KEY(service_id, doctor_id),
    FOREIGN KEY (service_id) REFERENCES SERVICES(service_id),
    FOREIGN KEY (doctor_id) REFERENCES DOCTOR(doctor_id)
);

CREATE TABLE APPOINTMENT_DETAILS (
	appointment_id       VARCHAR(5) NOT NULL,
    service_id          VARCHAR(5) NOT NULL,
    patient_id          VARCHAR(5) NOT NULL,
    doctor_id           VARCHAR(5) NOT NULL,
    appointment_date    DATE NOT NULL,
    appointment_time    TIME NOT NULL,
    appointment_status	VARCHAR(45) NOT NULL,
    PRIMARY KEY(appointment_id, service_id, patient_id, doctor_id),
    FOREIGN KEY (service_id) REFERENCES SERVICES(service_id),
    FOREIGN KEY (patient_id) REFERENCES PATIENT(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES DOCTOR(doctor_id)
);

CREATE TABLE PAYMENT (
	payment_id 		VARCHAR(5) NOT NULL,
	appointment_id 	VARCHAR(5) NOT NULL,
    amount 			INTEGER(6) NOT NULL,
    payment_date 	DATE NOT NULL,
    payment_time 	TIME NOT NULL,
    payment_status 	VARCHAR(45) NOT NULL,
    payment_mode 	VARCHAR(45) NOT NULL,
    PRIMARY KEY(payment_id, appointment_id),
    FOREIGN KEY (appointment_id) REFERENCES APPOINTMENT_DETAILS(appointment_id)
);

CREATE TABLE RESCHEDULE (
	appointment_id 	VARCHAR(5) NOT NULL,
    doctor_id 		VARCHAR(5) NOT NULL,
    new_date 		DATE NOT NULL,
    new_time 		TIME NOT NULL,
    PRIMARY KEY(appointment_id, doctor_id),
    FOREIGN KEY (appointment_id) REFERENCES APPOINTMENT_DETAILS(appointment_id),
    FOREIGN KEY (doctor_id) REFERENCES DOCTOR(doctor_id)
);

CREATE TABLE REPRESENTATIVE (
	representative_id VARCHAR(5) NOT NULL,
    patient_id VARCHAR(5) NOT NULL,
    representative_name VARCHAR(45) NOT NULL,
    relationship VARCHAR(45) NOT NULL,
    address VARCHAR(100),
    contact VARCHAR(10) NOT NULL,
    email_id VARCHAR(60) NOT NULL,
    password VARCHAR(45) NOT NULL,
    PRIMARY KEY (representative_id, patient_id),
    FOREIGN KEY (patient_id) REFERENCES PATIENT(patient_id)
);

CREATE TABLE BILLING (
	billing_id			VARCHAR(5) NOT NULL,
    payment_id			VARCHAR(5) NOT NULL,
    patient_id			VARCHAR(5) NOT NULL,
    representative_id	VARCHAR(5) NOT NULL,
    PRIMARY KEY(billing_id, payment_id, patient_id, representative_id),
    FOREIGN KEY (payment_id) REFERENCES PAYMENT(payment_id),
    FOREIGN KEY (patient_id) REFERENCES PATIENT(patient_id),
    FOREIGN KEY (representative_id) REFERENCES REPRESENTATIVE(representative_id)
);

CREATE TABLE SYSTEM_ADMIN (
	admin_id VARCHAR(5) NOT NULL PRIMARY KEY,
    admin_name VARCHAR(45) NOT NULL,
    email_id VARCHAR(60) NOT NULL,
    password VARCHAR(45) NOT NULL
);