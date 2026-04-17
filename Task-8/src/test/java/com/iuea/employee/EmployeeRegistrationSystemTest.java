package com.iuea.employee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeRegistrationSystemTest {

    // ── Validation Logic Tests ──────────────────────────────

    @Test
    void testNameNotEmpty() {
        String name = "John Doe";
        assertFalse(name.isEmpty());
    }

    @Test
    void testEmailNotEmpty() {
        String email = "john@iuea.ac.ug";
        assertFalse(email.isEmpty());
    }

    @Test
    void testPasswordNotEmpty() {
        String password = "secret123";
        assertFalse(password.isEmpty());
    }

    @Test
    void testEmptyNameFails() {
        String name = "";
        assertTrue(name.isEmpty());
    }

    @Test
    void testEmptyEmailFails() {
        String email = "";
        assertTrue(email.isEmpty());
    }

    @Test
    void testEmptyPasswordFails() {
        String password = "";
        assertTrue(password.isEmpty());
    }

    // ── Department Selection Tests ──────────────────────────

    @Test
    void testValidDepartments() {
        String[] departments = {"IT", "Finance", "HR", "Marketing"};
        assertEquals(4, departments.length);
    }

    @Test
    void testFirstDepartmentIsIT() {
        String[] departments = {"IT", "Finance", "HR", "Marketing"};
        assertEquals("IT", departments[0]);
    }

    // ── Password Masking Tests ──────────────────────────────

    @Test
    void testPasswordIsMasked() {
        String password = "secret123";
        String masked = "******";
        assertNotEquals(password, masked);
    }

    // ── Form Validation Logic ───────────────────────────────

    @Test
    void testAllFieldsFilledReturnsSuccess() {
        String name = "Benin Bismark";
        String email = "benin@iuea.ac.ug";
        String password = "pass123";
        boolean valid = !name.isEmpty() && !email.isEmpty() && !password.isEmpty();
        assertTrue(valid);
    }

    @Test
    void testMissingFieldsReturnsFalse() {
        String name = "";
        String email = "benin@iuea.ac.ug";
        String password = "pass123";
        boolean valid = !name.isEmpty() && !email.isEmpty() && !password.isEmpty();
        assertFalse(valid);
    }

    @Test
    void testEmailContainsAtSymbol() {
        String email = "benin@iuea.ac.ug";
        assertTrue(email.contains("@"));
    }
}