package org.delcom.starter.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {

    private final HomeController controller = new HomeController();

    @Test
    @DisplayName("Should return the default welcome message")
    void testWelcomeMessage() {
        String result = controller.welcomeMessage();
        assertEquals("Hay Abdullah, selamat datang di pengembangan aplikasi dengan Spring Boot!", result);
    }

    @Test
    @DisplayName("Should return a personalized greeting for a given name")
    void testPersonalizedGreeting() {
        String result = controller.personalizedGreeting("Gladys");
        assertEquals("Hello, Gladys!", result);
    }

    // ======================
    // 1️⃣ NIM Details - TES LENGKAP UNTUK SEMUA PRODI
    // ======================
    @Test
    @DisplayName("Should parse Informatics NIM correctly")
    void getNimDetails_ForInformatics_ReturnsCorrectInfo() {
        String result = controller.getNimDetails("11S24055");
        assertTrue(result.contains("Sarjana Informatika"));
    }

    @Test
    @DisplayName("Should parse Information Systems NIM correctly")
    void getNimDetails_ForInformationSystems_ReturnsCorrectInfo() {
        String result = controller.getNimDetails("12S24055");
        assertTrue(result.contains("Sarjana Sistem Informasi"));
    }

    @Test
    @DisplayName("Should parse Electrical Engineering NIM correctly")
    void getNimDetails_ForElectricalEngineering_ReturnsCorrectInfo() {
        String result = controller.getNimDetails("14S24055");
        assertTrue(result.contains("Sarjana Teknik Elektro"));
    }

    @Test
    @DisplayName("Should parse Management Engineering NIM correctly")
    void getNimDetails_ForManagementEngineering_ReturnsCorrectInfo() {
        String result = controller.getNimDetails("21S24055");
        assertTrue(result.contains("Sarjana Manajemen Rekayasa"));
    }
    
    @Test
    @DisplayName("Should parse Metallurgical Engineering NIM correctly")
    void getNimDetails_ForMetallurgicalEngineering_ReturnsCorrectInfo() {
        String result = controller.getNimDetails("22S24055");
        assertTrue(result.contains("Sarjana Teknik Metalurgi"));
    }

    @Test
    @DisplayName("Should parse Bioprocess Engineering NIM correctly")
    void getNimDetails_ForBioprocessEngineering_ReturnsCorrectInfo() {
        String result = controller.getNimDetails("31S24055");
        assertTrue(result.contains("Sarjana Teknik Bioproses"));
    }

    @Test
    @DisplayName("Should parse D4 Software Engineering NIM correctly")
    void getNimDetails_ForD4SoftwareEngineering_ReturnsCorrectInfo() {
        String result = controller.getNimDetails("11424055");
        assertTrue(result.contains("Diploma 4 Teknologi Rekasaya Perangkat Lunak"));
    }

    @Test
    @DisplayName("Should parse D3 Information Technology NIM correctly")
    void getNimDetails_ForD3InformationTechnology_ReturnsCorrectInfo() {
        String result = controller.getNimDetails("11324055");
        assertTrue(result.contains("Diploma 3 Teknologi Informasi"));
    }

    @Test
    @DisplayName("Should parse D3 Computer Technology NIM correctly")
    void getNimDetails_ForD3ComputerTechnology_ReturnsCorrectInfo() {
        String result = controller.getNimDetails("13324055");
        assertTrue(result.contains("Diploma 3 Teknologi Komputer"));
    }

    @Test
    @DisplayName("Should return 'Unknown Program' for an unrecognized NIM prefix")
    void getNimDetails_ForUnknownPrefix_ReturnsUnknownProgram() {
        String result = controller.getNimDetails("99X24055");
        assertTrue(result.contains("Program Studi Tidak Dikenal"));
    }


    // ======================
    // 2️⃣ Decode Grades
    // ======================
    @Test
    @DisplayName("Should decode Base64 string and return the grades")
    void decodeGradesFromBase64_ValidInput_ReturnsDecodedString() {
        String originalGrades = "A=90 B=80 C=70";
        String encodedGrades = Base64.getEncoder().encodeToString(originalGrades.getBytes(StandardCharsets.UTF_8));
        String result = controller.decodeGradesFromBase64(encodedGrades);
        assertTrue(result.contains("Perolehan Nilai: A=90 B=80 C=70"));
    }


    // ================================
    // 3️⃣ Reversal Differences
    // ================================
    @Test
    @DisplayName("Should return correct difference for a non-palindrome")
    void findReversalDifferences_ForNonPalindrome_ReturnsCorrectOutput() {
        String originalText = "mobil";
        String encodedText = Base64.getEncoder().encodeToString(originalText.getBytes(StandardCharsets.UTF_8));
        String result = controller.findReversalDifferences(encodedText);
        assertTrue(result.contains("Perbedaannya: moil"));
    }

    @Test
    @DisplayName("Should return an empty difference for a palindrome")
    void findReversalDifferences_ForPalindrome_ReturnsEmptyDifference() {
        String originalText = "kasurrusak";
        String encodedText = Base64.getEncoder().encodeToString(originalText.getBytes(StandardCharsets.UTF_8));
        String result = controller.findReversalDifferences(encodedText);
        assertTrue(result.contains("Perbedaannya: "));
    }

    // ==============================
    // 4️⃣ Shortest and Longest Word
    // ==============================
    @Test
    @DisplayName("Should find the correct shortest and longest words in a sentence")
    void findShortestAndLongestWords_ValidSentence_ReturnsCorrectWords() {
        String sentence = "Saya sedang belajar spring boot oop";
        String encodedSentence = Base64.getEncoder().encodeToString(sentence.getBytes(StandardCharsets.UTF_8));
        String result = controller.findShortestAndLongestWords(encodedSentence);
        assertTrue(result.contains("Paling Pendek: oop"));
        assertTrue(result.contains("Paling Panjang: belajar"));
    }
}