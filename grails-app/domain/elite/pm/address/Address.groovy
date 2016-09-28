package elite.pm.address

class Address {
	
	String primaryAddressNumber
	
	Directional predirectional
	
	String streetName
	
	StreetSuffix suffix
	
	Directional postdirectional
	
	SecondaryUnitDesignator secondaryUnit
	
	String secondaryAddressNumber
	
	String municipality
	
	PrincipalSubdivision principalSubdivision
	
	Country country
	
	String postcode;
	
	Date dateCreated
	
	Date lastUpdated

    static constraints = {
		// administrativeSubdivision and country interchangably validate against each other
		principalSubdivision validator: { val, obj -> val.country.iso3166_1alpha2 == obj.country.iso3166_1alpha2 }
		country validator: { val, obj -> val.iso3166_1alpha2 ==  obj.principalSubdivision.country.iso3166_1alpha2 }
		primaryAddressNumber blank: false
		predirectional nullable: true
		streetName blank: false
		postdirectional nullable: true
		secondaryUnit nullable: true
		secondaryAddressNumber nullable: true, blank: true
		municipality blank: false
		postcode blank: false, validator: { val, obj, errors -> 
			if (!(val ==~ /${obj.country.postcodePattern}/)) {
				errors.rejectValue('postcode', 'default.country.postcode.malformed')
			}
			
			if (!(val =~ /${obj.principalSubdivision.postcodePattern}/)) {
				errors.rejectValue('postcode', 'default.principalSubdivision.postcode.malformed')
			}
		}
    }
	
	static mapping = {
		// force table-per-class
//		tablePerHierarchy false
		table name: 'pp_addresses', schema: 'subject'
	}
	
	String toString() {
		StringBuffer builder = new StringBuffer()
		
		builder << "${primaryAddressNumber}"
		
		if (predirectional) {
			builder << " ${predirectional}"
		}
		
		builder << " ${streetName} ${suffix}"
		
		if (postdirectional) {
			builder << " ${postdirectional}"
		}
		
		if (secondaryUnit) {
			builder << ", ${secondaryUnit}"
			
			if (secondaryUnit.requiresNumber && secondaryAddressNumber) {
				builder << " ${secondaryAddressNumber}"
			}
		}
		
		builder << ", ${municipality}, ${principalSubdivision} ${postcode}, ${country}"
		
		return builder.toString()
	}
	
}
