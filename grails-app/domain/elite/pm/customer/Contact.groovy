package elite.pm.customer

import elite.pm.address.ContactBillingAddress
import elite.pm.address.ContactShippingAddress
import elite.pm.attachments.ContactAttachment

class Contact {
	
	Company company
	
	String givenName
	
	String familyName
	
	String title
	
	String officePhone
	
	String personalPhone
	
	String mobilePhone
	
	String emailAddress
	
	ContactBillingAddress billingAddress
	
	ContactShippingAddress shippingAddress
	
	static hasMany = [attachments: ContactAttachment]

    static constraints = {
		personalPhone nullable: true
		mobilePhone nullable: true
		shippingAddress nullable: true
    }
}
