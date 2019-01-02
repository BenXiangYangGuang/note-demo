package com.wewe.designpattern.compositionPattern.client;

import com.wewe.designpattern.compositionPattern.organization.Company;
import com.wewe.designpattern.compositionPattern.organization.Department;
import com.wewe.designpattern.compositionPattern.organization.Organization;
import com.wewe.designpattern.compositionPattern.organization.Company;
import com.wewe.designpattern.compositionPattern.organization.Department;
import com.wewe.designpattern.compositionPattern.organization.Organization;

public class Client1 {

  public static void main(String[] args) {
    Organization shCompany = new Company("shCompany");
    
    Organization shHR = new Department("shHR");
    shCompany.addOrg(shHR);
    
    Organization shAdmin = new Department("shAdmin");
    shCompany.addOrg(shAdmin);
    
    Organization shFinance = new Department("shFinance");
    shCompany.addOrg(shFinance);
    

    Organization bjCompany = new Company("bjCompany");
    
    Organization bjHR = new Department("bjHR");
    bjCompany.addOrg(bjHR);
    
    Organization bjAdmin = new Department("bjAdmin");
    bjCompany.addOrg(bjAdmin);
    
    Organization bjFinance = new Department("bjFinance");
    bjCompany.addOrg(bjFinance);

    //公司总部
    Organization company = new Company("company");
    //公司总部添加几个部门
    Organization hr = new Department("hr");
    company.addOrg(hr);
    Organization admin = new Department("admin");
    company.addOrg(admin);
    Organization finance = new Department("finance");
    company.addOrg(finance);

    //公司总部添加两个分公司
    company.addOrg(shCompany);
    company.addOrg(bjCompany);
    
    company.inform("Cheers");
  }

}
