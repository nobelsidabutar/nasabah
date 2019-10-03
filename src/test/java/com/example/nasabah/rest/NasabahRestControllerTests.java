package com.example.nasabah.rest;

import com.example.nasabah.entity.NasabahEntity;
import com.example.nasabah.repository.NasabahRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class NasabahRestControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NasabahRepository nasabahRepository;
    @Test
    public void testFindById_thenReturnOK() throws Exception {
        NasabahEntity nasabahEntity = new NasabahEntity();
        nasabahEntity.setNik(1111);
        nasabahEntity.setNama("Test123");
        nasabahEntity.setCareer("Guru");
        nasabahEntity.setTanggalLahir(new Date(1995-10-03));
        nasabahEntity.setPendapatan(450000.00);


        mockMvc.perform(get("/nasabah/findById/1111")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.nasabahEntity", hasSize(1)))
                .andExpect(jsonPath("$.nasabahEntity[0].nama", is("1111")));
    }

    @Test
    public void testFindById_whenIdNotExist_thenReturnOK() throws Exception {
        when(nasabahRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/nasabah/findById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error", is("Nik ID not exist!")))
                .andExpect(jsonPath("$.exception", is(nullValue())));
    }

}
