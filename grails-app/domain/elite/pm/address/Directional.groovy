package elite.pm.address

class Directional {
	
	String code
	
	String label
	
	Float azimuth
	
	Date dateCreated
	
	Date lastUpdated

    static constraints = {
		code blank: false
		label blank: false
    }
	
	static mapping = {
		table name: 'pp_directionals', schema: 'address'
		code sqlType: 'varchar', length: 4
		id generator: 'assigned', name: 'code'
	}
	
	String toString() {
		return label
	}
	
}
