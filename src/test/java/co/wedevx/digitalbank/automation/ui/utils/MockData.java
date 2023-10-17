package co.wedevx.digitalbank.automation.ui.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class MockData {
    private FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-US"), new RandomService());
    public Map<String, String> generateRandomNameAndEmail(){
        String name = fakeValuesService.bothify(new Faker().name().firstName());
        String email = fakeValuesService.bothify(name + "####@testemail.com");
        Map<String, String> nameAndEmail = new HashMap<>();
        nameAndEmail.put("name", name);
        nameAndEmail.put("email", email);
        return nameAndEmail;
    }

    public String generateRandomSSN(){
        String ssn = String.format("%09d", new Random().nextInt(1000000000));
        return ssn;
    }
}
