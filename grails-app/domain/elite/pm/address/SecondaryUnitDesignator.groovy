package elite.pm.address

class SecondaryUnitDesignator {
	
	String code
	
	String label
	
	boolean requiresNumber = true
	
	Date dateCreated
	
	Date lastUpdated

    static constraints = {
		code blank: false
		label blank: false
    }
	
	static mapping = {
		table name: 'pp_secondary_unit_designators', schema: 'address'
		code sqlType: 'varchar', length: 4
		id generator: 'assigned', name: 'code'
	}
	
	String toString() {
		return label
	}
	
}
