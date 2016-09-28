package elite.pm

class Timer {
	
	enum Status {
		STOPPED, RUNNING
	}
	
	Task task
	
	User owner
	
	BigDecimal cummulativeTime
	
	Date startTime
	
	Status status = Status.STOPPED

    static constraints = {
    }
	
}
