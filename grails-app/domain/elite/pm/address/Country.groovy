package elite.pm.address

import java.util.regex.Pattern

class Country {
	
	/**
	 * The 2-character ISO code
	 */
	String iso3166_1alpha2
	
	String iso3166_1alpha3
	
	Integer iso3166_1numeric
	
	/**
	 * The English Language name of this country
	 */
	String name
	
	boolean selectable = false
	
	String postcodePattern
	
	Date dateCreated
	
	Date lastUpdated
	
	static hasMany = [subdivisionTypes: PrincipalSubdivisionType, \
			principalSubdivisions: PrincipalSubdivision]

    static constraints = {
		// we don't mark iso3166_1alpha2 as 'unique: true', because it's defined
		// as the primary key in the mapping section below
		iso3166_1alpha2 maxize: 2..2, blank: false
		iso3166_1alpha3 size: 3..3, blank: false, unique: true
		iso3166_1numeric max: 999, unique: true
		name blank: false
		subdivisionTypes joinTable: [name: 'pp_country_subdivisions_types']
    }
	
	static mapping = {
		table name: 'pp_countries', schema: 'address'
		iso3166_1alpha2 sqlType: 'varchar', length: 2
		iso3166_1alpha3 sqlType: 'varchar', length: 3
		id generator: 'assigned', name: 'iso3166_1alpha2'
	}
	
	String toString() {
		return name
	}
	
}
