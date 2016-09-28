package elite.pm.customer

import elite.pm.Project
import elite.pm.User
import elite.pm.address.CompanyBillingAddress
import elite.pm.address.CompanyShippingAddress
import elite.pm.attachments.CompanyAttachment
import elite.pm.notes.CompanyNote

class Company {
	
	String name
	
	String website
	
	String primaryPhone
	
	String secondaryPhone
	
	String emailAddress
	
	CompanyBillingAddress billingAddress
	
	CompanyShippingAddress shippingAddress
	
	User creator
	
	User salesperson
	
	User accountManager
	
	static hasMany = [
		notes: CompanyNote, 
		attachments: CompanyAttachment,
		projects: Project
	]

    static constraints = {
		website nullable: true
		secondaryPhone nullable: true
		shippingAddress nullable: true
		salesperson nullable: true
		accountManager nullable: true
    }
	
}
