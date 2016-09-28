package elite.pm

import elite.pm.attachments.TaskAttachment
import elite.pm.notes.TaskNote

class Task {
	
	Project project
	
	Milestone milestone
	
	String title
	
	String description
	
	User creator
	
	Date dateCreated
	
	Date lastUpdated
	
	Date dueDate
	
	static hasMany = [
		attachments: TaskAttachment,
		notes: TaskNote
	]

    static constraints = {
		milestone nullable: true
    }
	
	static mapping = {
		description sqlType: "text"
	}
	
}
