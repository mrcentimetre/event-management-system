package com.customer;

public class customize {
	 	private int eventid;
	    private String name;
	    private String type;
	    private String description;
	    private String date;
	    private String time;
	    private String location;
	    private String planner;
	    private String username;
	    private String password;
	    
		public customize(int eventid, String name, String type, String description, String date, String time,
				String location, String planner, String username, String password) {
			this.eventid = eventid;
			this.name = name;
			this.type = type;
			this.description = description;
			this.date = date;
			this.time = time;
			this.location = location;
			this.planner = planner;
			this.username = username;
			this.password = password;
		}

		public int getEventid() {
			return eventid;
		}

		public String getName() {
			return name;
		}

		public String getType() {
			return type;
		}

		public String getDescription() {
			return description;
		}

		public String getDate() {
			return date;
		}

		public String getTime() {
			return time;
		}

		public String getLocation() {
			return location;
		}

		public String getPlanner() {
			return planner;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}


}