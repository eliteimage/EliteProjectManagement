package elite.pm.address

class StreetSuffix {
	
	String code
	
	String label
	
	Date dateCreated
	
	Date lastUpdated

    static constraints = {
		code blank: false
		label blank: false
    }
	
	static mapping = {
		table name: 'pp_street_suffixes', schema: 'address'
		code sqlType: 'varchar', length: 4
		id generator: 'assigned', name: 'code'
	}
	
	String toString() {
		return label
	}
	
}
