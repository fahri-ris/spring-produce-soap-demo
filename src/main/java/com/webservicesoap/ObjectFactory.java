//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.25 at 10:41:18 AM ICT 
//


package com.webservicesoap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.webservicesoap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.webservicesoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BirthDateResponse }
     * 
     */
    public BirthDateResponse createBirthDateResponse() {
        return new BirthDateResponse();
    }

    /**
     * Create an instance of {@link BirthdayNameRequest }
     * 
     */
    public BirthdayNameRequest createBirthdayNameRequest() {
        return new BirthdayNameRequest();
    }

    /**
     * Create an instance of {@link AgeResponse }
     * 
     */
    public AgeResponse createAgeResponse() {
        return new AgeResponse();
    }

    /**
     * Create an instance of {@link BirthdayRequest }
     * 
     */
    public BirthdayRequest createBirthdayRequest() {
        return new BirthdayRequest();
    }

}
