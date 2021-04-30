package com.example.testone;

public class UserModel {
    int id;
    String name;
    String username;
    String email;
    Address address = new Address();
    String phone;
    String website;
    Company company = new Company();

    class Company {
        String name;
        String catchPhrase;
        String bs;
    }


    class Address {
        String street;
        String suite;
        String city;
        String zipcode;
        Geo geo = new Geo();

        class Geo {
            String lat;
            String lng;

        }

    }



    /*

    class UserModel {
    var id: Int? = null
    var name: String? = null
    var username: String? = null
    var email: String? = null
    var address = Address()
    var phone: String? = null
    var website: String? = null
    var company = Company()

    inner class Company {
        var name: String? = null
        var catchPhrase: String? = null
        var bs: String? = null
    }

    inner class Address {
        var street: String? = null
        var suite: String? = null
        var city: String? = null
        var zipcode: String? = null
        var geo = Geo()

        inner class Geo {
            var  : String? = null
            var lng: String? = null
        }
    }
}

     */


}
