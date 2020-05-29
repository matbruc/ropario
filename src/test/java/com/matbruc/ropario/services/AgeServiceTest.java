package com.matbruc.ropario.services;

import com.matbruc.ropario.models.Age;
import com.matbruc.ropario.repositories.AgeRespository;
import com.matbruc.ropario.services.AgeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

public class AgeServiceTest {

    @InjectMocks
    private AgeService ageService;

    @Mock
    private AgeRespository ageRespository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAgeGet() {
        Age age = new Age();
        age.setId(1L);
        when(ageRespository.getOne(age.getId())).thenReturn(age);

        Age age1 = ageService.getAgeById(age.getId());
        assertThat(age1.getId(), is(1L));
    }

    @Test
    public void testAgeGetAll() {
        List<Age> list = new ArrayList<>();

        Age age = new Age();
        age.setId(1L);
        list.add(age);
        Age age2 = new Age();
        age2.setId(2L);
        list.add(age2);

        when(ageRespository.findAll()).thenReturn(list);

        List<Age> testList = ageService.getAllAges();
        assertThat(testList, is(list));
    }

    @Test
    public void testAgeAdd() {
        Age age = new Age();
        age.setId(1L);
        age.setName("2 años");
        when(ageRespository.save(age)).thenReturn(age);

        Age result = ageService.addAge(age);

        assertThat(1L, is(result.getId()));
        assertThat("2 años", is(age.getName()));

    }

    @Test
    public void testAgeUpdate() {
        Age age = new Age();
        age.setId(1L);
        age.setName("2 años");
        when(ageRespository.save(age)).thenReturn(age);

        Age result = ageService.updateAge(age);

        assertThat(1L, is(result.getId()));
        assertThat("2 años", is(age.getName()));

    }
}
