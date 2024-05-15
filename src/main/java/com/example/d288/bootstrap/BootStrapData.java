package com.example.d288.bootstrap;

import com.example.d288.dao.CustomerRepository;
import com.example.d288.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public BootStrapData(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (customerRepository.count() <= 1) {
            Customer tom = new Customer();
            tom.setFirstName("Thomas");
            tom.setLastName("Kroll");
            tom.setPhone("518-416-9535");
            tom.setAddress("149 Madeup Street");
            tom.setDivision_id(31);
            tom.setPostal_code("12198");
            customerRepository.save(tom);

            Customer kristine = new Customer();
            kristine.setFirstName("Kristine");
            kristine.setLastName("Kroll");
            kristine.setPhone("518-416-9536");
            kristine.setAddress("149 Madeup Street");
            kristine.setDivision_id(31);
            kristine.setPostal_code("12198");
            customerRepository.save(kristine);

            Customer everett = new Customer();
            everett.setFirstName("Everett");
            everett.setLastName("Kroll");
            everett.setPhone("518-416-3536");
            everett.setAddress("149 Madeup Street");
            everett.setDivision_id(31);
            everett.setPostal_code("12198");
            customerRepository.save(everett);

            Customer tzu = new Customer();
            tzu.setFirstName("Tzu");
            tzu.setLastName("Kroll");
            tzu.setPhone("Dog, no phone");
            tzu.setAddress("149 Madeup Street");
            tzu.setDivision_id(31);
            tzu.setPostal_code("12198");
            customerRepository.save(tzu);

            Customer heidi = new Customer();
            heidi.setFirstName("Heidi");
            heidi.setLastName("Kroll");
            heidi.setPhone("Dog, no phone");
            heidi.setAddress("149 Madeup Street");
            heidi.setDivision_id(31);
            heidi.setPostal_code("12198");
            customerRepository.save(heidi);
        }
    }
}
