# nasabah

crud
setelah update saya sudah test di postman

generate token method post http://localhost:8080/login/authenticate body: { "username":"user", "password":"password" }

generate token nya digunkan untuk method dibawah ini di header:

Content-Type :"application/json
Authorization : token
http://localhost:8080/nasabah/findAll

http://localhost:8080/nasabah/findByNama di param: nik=111222333666

http://localhost:8080/nasabah/findByNama di param: nama=Nobel

create
Content-Type :"application/json
Authorization : token http://localhost:8080/nasabah/createNasabah di body: { "nik": 111222333000, "nama": "Romita", "pendapatan": 1.605E7, "tanggalLahir": "1970-01-01T00:00:01.969+0000", "career": "Gubernur" }
update
Content-Type :"application/json
Authorization : token http://localhost:8080/nasabah/updateNasabah di param: nik=111222333000 di pre-request-test: var current_timestamp = new Date(1998-09-20); postman.setEnvironmentVariable("current_timestamp", current_timestamp.toISOString());
di body { "nik":111222333000, "nama":"RomitaS", "pendapatan":16050000.00, "tanggalLahir":"{{current_timestamp}}", "career":"Gubernur" }

delete
Content-Type :"application/json
Authorization : token http://localhost:8080/nasabah/deleteNasabahById di param: nik=111222333000
