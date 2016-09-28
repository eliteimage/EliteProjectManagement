package elite.pm.address

import java.util.regex.Pattern

class PrincipalSubdivision {
	
	Country country
	
	PrincipalSubdivisionType type
	
	String iso3166_2
	
	/**
	 * A shorter version of the code, used locally. For example, while in Canada,
	 * you don't typically use 'CA-BC', you use use 'BC'
	 */
	String localCode
	
	String name
	
	/**
	 * A more specific postcode pattern for the subdivision
	 */
	String postcodePattern
	
	Date dateCreated
	
	Date lastUpdated

    static constraints = {
		// validate that the type selected is valid for the country
		type validator: { val, obj -> obj.country.subdivisionTypes.contains(val) }
		localCode blank: false
		name blank: false
    }
	
	static mapping = {
		table name: 'pp_principal_subdivisions', schema: 'address'
		id generator: 'assigned', name: 'iso3166_2'
	}
	
	String toString() {
		return name
	}
	
}
