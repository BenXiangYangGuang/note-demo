package com.wewe.designpattern.builder;

/**
 * Created by fei2 on 2018/5/16.
 * 描述：
 */
public class Person {
    private final FullName name;
    private final Address address;
    private final Gender gender;
    private final EmploymentStatus employment;
    private final HomeownerStatus homeOwnerStatus;
    
    /**
     * Parameterized constructor can be private because only my internal builder
     * needs to call me to provide an instance to clients.
     *
     * @param newName       Name of this person.
     * @param newAddress    Address of this person.
     * @param newGender     Gender of this person.
     * @param newEmployment Employment status of this person.
     * @param newHomeOwner  Home ownership status of this person.
     */
    private Person(
        final FullName newName, final Address newAddress,
        final Gender newGender, final EmploymentStatus newEmployment,
        final HomeownerStatus newHomeOwner) {
        this.name = newName;
        this.address = newAddress;
        this.gender = newGender;
        this.employment = newEmployment;
        this.homeOwnerStatus = newHomeOwner;
    }
    
    public FullName getName() {
        return this.name;
    }
    
    public Address getAddress() {
        return this.address;
    }
    
    public Gender getGender() {
        return this.gender;
    }
    
    public EmploymentStatus getEmployment() {
        return this.employment;
    }
    
    public HomeownerStatus getHomeOwnerStatus() {
        return this.homeOwnerStatus;
    }
    
    /**
     * Builder class as outlined in the Second Edition of Joshua Bloch's
     * <em><span class="wp_keywordlink"><a href="http://www.amazon.com/gp/product/B000WJOUPA/ref=as_li_qf_sp_asin_il_tl?ie=UTF8&camp=1789&creative=9325&creativeASIN=B000WJOUPA&linkCode=as2&tag=job0ae-20" title="Effective Java" rel="nofollow" target="_blank" class="external">Effective Java</a></span></em> that is used to build a {@link Person} instance.
     */
    public static class PersonBuilder {
        private FullName nestedName;
        private Address nestedAddress;
        private Gender nestedGender;
        private EmploymentStatus nestedEmploymentStatus;
        private HomeownerStatus nestedHomeOwnerStatus;
        
        public PersonBuilder(
            final FullName newFullName,
            final Address newAddress) {
            this.nestedName = newFullName;
            this.nestedAddress = newAddress;
        }
        
        public PersonBuilder name(final FullName newName) {
            this.nestedName = newName;
            return this;
        }
        
        public PersonBuilder address(final Address newAddress) {
            this.nestedAddress = newAddress;
            return this;
        }
        
        public PersonBuilder gender(final Gender newGender) {
            this.nestedGender = newGender;
            return this;
        }
        
        public PersonBuilder employment(final EmploymentStatus newEmploymentStatus) {
            this.nestedEmploymentStatus = newEmploymentStatus;
            return this;
        }
        
        public PersonBuilder homeOwner(final HomeownerStatus newHomeOwnerStatus) {
            this.nestedHomeOwnerStatus = newHomeOwnerStatus;
            return this;
        }
        
        public Person createPerson() {
            return new Person(
                nestedName, nestedAddress, nestedGender,
                nestedEmploymentStatus, nestedHomeOwnerStatus);
        }
    }
}