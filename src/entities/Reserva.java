package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excecao.Exceptions;

public class Reserva {

	private Integer number;
	private Date checkin;
	private Date checkout;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	
	public Reserva() {
		
	}

	public Reserva(Integer number, Date checkin, Date checkout) {
		super();
		
		if (!checkout.after(checkin)) {
			throw new Exceptions("Check-out date must be after check-in date");
			
		}
		
		this.number = number;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		}
		
		public void updateDates(Date checkin, Date checkout) {
			Date now = new Date();
			
			if(!checkout.after(checkin)) {
				throw new Exceptions("Check-in must be before check-out");
				
			}
			
			if (checkin.before(now) || checkout.before(now)) {
				throw new Exceptions("Invalid date");
				
				
			}
			
			
		this.checkin = checkin;
		this.checkout = checkout;
		}
	
		@Override
		public String toString() {
			return "Room" + number + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout)
					+ ", " + duration() + " nights";

		}
	
	
	
}
