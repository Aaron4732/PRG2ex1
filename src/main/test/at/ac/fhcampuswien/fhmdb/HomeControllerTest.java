package at.ac.fhcampuswien.fhmdb;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    @Test
    void asc_sorter_with_4_Elements() {
        // given
        ArrayList<String> unsortetList = new ArrayList<>();

        unsortetList.add("ACTION");
        unsortetList.add("FAMILY");
        unsortetList.add("CRIME");
        unsortetList.add("WAR");

        // when
        ArrayList<String> sortetList = HomeController.ascSorter(unsortetList);

        // then
        ArrayList<String> rightList = new ArrayList<>();
        rightList.add("ACTION");
        rightList.add("CRIME");
        rightList.add("FAMILY");
        rightList.add("WAR");

        assertEquals(rightList, sortetList);
    }
    @Test
    void desc_sorter_with_4_Elements(){
        // given
        ArrayList<String> unsortetList = new ArrayList<>();

        unsortetList.add("ACTION");
        unsortetList.add("FAMILY");
        unsortetList.add("CRIME");
        unsortetList.add("WAR");

        // when
        ArrayList<String> sortetList = HomeController.ascSorter(unsortetList);

        // then
        ArrayList<String> rightList = new ArrayList<>();
        rightList.add("WAR");
        rightList.add("FAMILY");
        rightList.add("CRIME");
        rightList.add("ACTION");

        assertEquals(rightList, sortetList);
    }
}
