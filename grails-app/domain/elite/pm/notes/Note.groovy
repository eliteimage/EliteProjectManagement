package elite.pm.notes

import elite.pm.User
import elite.pm.attachments.NoteAttachment

class Note {
	
	User creator
	
	Date dateCreated
	
	User lastUpdater
	
	Date lastUpdated
	
	String message
	
	static hasMany = [attachments: NoteAttachment]

    static constraints = {
		
    }
	
	static mapping = {
		message sqlType: "text"
	}
	
}
