package com.banking.model;
import java.sql.Timestamp;


public class Audit {
	 private int auditId;
	    private int customerId;
	    private String action;
	    private Timestamp timestamp;
	    private String details;
		public Audit() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Audit(int auditId, int customerId, String action, Timestamp timestamp, String details) {
			super();
			this.auditId = auditId;
			this.customerId = customerId;
			this.action = action;
			this.timestamp = timestamp;
			this.details = details;
		}
		public int getAuditId() {
			return auditId;
		}
		public void setAuditId(int auditId) {
			this.auditId = auditId;
		}
		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		public Timestamp getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Timestamp timestamp) {
			this.timestamp = timestamp;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		@Override
		public String toString() {
			return "Audit [auditId=" + auditId + ", customerId=" + customerId + ", action=" + action + ", timestamp="
					+ timestamp + ", details=" + details + "]";
		}


}