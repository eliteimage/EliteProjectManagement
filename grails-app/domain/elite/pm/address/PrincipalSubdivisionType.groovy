package elite.pm.address

class PrincipalSubdivisionType {
	
	String name
	
	static belongsTo = Country
	
	static hasMany = [countries: Country]
	
	Date dateCreated
	
	Date lastUpdated

    static constraints = {
		name blank: false
		countries joinTable: [name: 'pp_country_subdivisions_types']
    }
	
	static mapping = {
		table name: 'pp_principal_subdivision_types', schema: 'address'
	}
	
	String toString() {
		return name
	}
	
}
