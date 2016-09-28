package elite.pm.attachments

class Attachment {
	
	String filename
	
	String description
	
	String mime
	
	byte[] contents

    static constraints = {
		contents maxSize: 1024 * 1024 * 1024
    }
	
	static mapping = {
		description sqlType: "text"
	}
	
}
