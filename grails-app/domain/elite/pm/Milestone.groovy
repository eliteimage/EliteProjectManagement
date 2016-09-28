package elite.pm

import elite.pm.attachments.MilestoneAttachment
import elite.pm.notes.MilestoneNote

class Milestone {
	
	Project project
	
	String name
	
	String description
	
	User creator
	
	Date dateCreated
	
	Date lastUpdated
	
	Date dueDate
	
	static hasMany = [
		attachments: MilestoneAttachment,
		notes: MilestoneNote,
		tasks: Task
	]

    static constraints = {
		
    }
	
	static mapping = {
		description sqlType: "text"
	}
	
}
