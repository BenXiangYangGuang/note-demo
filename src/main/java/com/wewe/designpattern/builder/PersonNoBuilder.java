package com.wewe.designpattern.builder;

/**
 * Created by fei2 on 2018/5/16.
 * 描述：非Builder模式
 * 参考：http://www.importnew.com/6605.html
 */
public class PersonNoBuilder {
    
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final String salutation;
    private final String suffix;
    private final String streetAddress;
    private final String city;
    private final String state;
    private final boolean isFemale;
    private final boolean isEmployed;
    private final boolean isHomewOwner;
    
    public PersonNoBuilder(
        final String newLastName,
        final String newFirstName,
        final String newMiddleName,
        final String newSalutation,
        final String newSuffix,
        final String newStreetAddress,
        final String newCity,
        final String newState,
        final boolean newIsFemale,
        final boolean newIsEmployed,
        final boolean newIsHomeOwner)
    {
        this.lastName = newLastName;
        this.firstName = newFirstName;
        this.middleName = newMiddleName;
        this.salutation = newSalutation;
        this.suffix = newSuffix;
        this.streetAddress = newStreetAddress;
        this.city = newCity;
        this.state = newState;
        this.isFemale = newIsFemale;
        this.isEmployed = newIsEmployed;
        this.isHomewOwner = newIsHomeOwner;
    }
}
