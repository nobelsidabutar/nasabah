package com.example.nasabah.rest;

import com.example.nasabah.dto.ResponseErrorDto;
import com.example.nasabah.entity.NasabahEntity;
import com.example.nasabah.repository.NasabahRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nasabah")
@CrossOrigin()
public class NasabahRestController {


    private final NasabahRepository nasabahRepository;

    public NasabahRestController(NasabahRepository nasabahRepository) {
        this.nasabahRepository = nasabahRepository;
    }

    @RequestMapping(value = "/findByNama" , method = RequestMethod.GET)
    public List<NasabahEntity> findByNama(@RequestParam("nama") String nama) {
        List<NasabahEntity> nasabahEntity = new ArrayList<NasabahEntity>();
        nasabahEntity = this.nasabahRepository.findByNama(nama);
        return nasabahEntity;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<NasabahEntity> findAll() {
        return this.nasabahRepository.findAll();
    }


    @RequestMapping(value = "/findById",  method = RequestMethod.GET)
    public NasabahEntity findById(@RequestParam("nik") Long nik) {
        NasabahEntity nasabahEntity = nasabahRepository.findById(nik)
                .orElseThrow(() -> new IllegalArgumentException("nik not exist!"));
        return nasabahEntity;
    }

    /**
     * API used to handle error.
     *
     * @param ex {@link IllegalArgumentException}
     * @return Response body of error response.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseErrorDto handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseErrorDto(ex.getMessage(), ex.getCause());
    }


    @RequestMapping("/hello")
    public String hello() {
        return "Hello, world";
    }

    @RequestMapping(value = "/createNasabah" , method = RequestMethod.POST)
    public ResponseEntity createNasabah(@Valid @RequestBody NasabahEntity nasabahEntity) {
        return ResponseEntity.ok(nasabahRepository.save(nasabahEntity));
    }

    @RequestMapping(value = "/deleteNasabahById" , method = RequestMethod.POST)
    public ResponseEntity deleteNasabahById(@RequestParam("nik") Long nik) {

        this.nasabahRepository.deleteById(nik);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/updateNasabah" , method = RequestMethod.POST)
    public ResponseEntity<NasabahEntity> updateNasabah(@RequestParam("nik") Long nik, @Valid @RequestBody NasabahEntity nasabahEntity) {
        return ResponseEntity.ok(this.nasabahRepository.save(nasabahEntity));
    }
}