package com.example.d288.bootstrap;

import com.example.d288.dao.CustomerRepository;
import com.example.d288.dao.DivisionRepository;
import com.example.d288.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;
    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() <= 1) {
            Customer tom = new Customer();
            tom.setFirstName("Thomas");
            tom.setLastName("Kroll");
            tom.setPhone("518-555-1111");
            tom.setAddress("149 Madeup Street");
            tom.setDivision(divisionRepository.findAll().get(5));
            tom.setPostal_code("12198");
            customerRepository.save(tom);

            Customer kristine = new Customer();
            kristine.setFirstName("Kristine");
            kristine.setLastName("Kroll");
            kristine.setPhone("518-555-2222");
            kristine.setAddress("149 Madeup Street");
            kristine.setDivision(divisionRepository.findAll().get(5));
            kristine.setPostal_code("12198");
            customerRepository.save(kristine);

            Customer everett = new Customer();
            everett.setFirstName("Everett");
            everett.setLastName("Kroll");
            everett.setPhone("518-555-3333");
            everett.setAddress("149 Madeup Street");
            everett.setDivision(divisionRepository.findAll().get(5));
            everett.setPostal_code("12198");
            customerRepository.save(everett);

            Customer tzu = new Customer();
            tzu.setFirstName("Tzu");
            tzu.setLastName("Kroll");
            tzu.setPhone("Dog, no phone");
            tzu.setAddress("149 Madeup Street");
            tzu.setDivision(divisionRepository.findAll().get(5));
            tzu.setPostal_code("12198");
            customerRepository.save(tzu);

            Customer heidi = new Customer();
            heidi.setFirstName("Heidi");
            heidi.setLastName("Kroll");
            heidi.setPhone("Dog, no phone");
            heidi.setAddress("149 Madeup Street");
            heidi.setDivision(divisionRepository.findAll().get(5));
            heidi.setPostal_code("12198");
            customerRepository.save(heidi);
        }
    }
}
