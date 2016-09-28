package elite.pm

import elite.pm.attachments.ProjectAttachment
import elite.pm.customer.Company
import elite.pm.customer.Contact
import elite.pm.notes.ProjectNote

class Project {
	
	Company company
	
	Contact contact
	
	User salesperson
	
	User projectManager
	
	User creator
	
	Date dateCreated
	
	Date lastUpdated
	
	Date dueDate
	
	static hasMany = [
		attachments: ProjectAttachment,
		notes: ProjectNote,
		tasks: Task
	]

    static constraints = {
		contact nullable: true
		salesperson nullable: true
		projectManager nullable: true
    }
}
