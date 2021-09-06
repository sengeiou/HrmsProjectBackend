package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisValidationAdapter {
	
	public boolean validate(Long nationalityId, String firstName, String lastName, int yearOfBirth) {
		
		return true;
	}
	
	public boolean checkPerson(Long nationalityId, String firstName, String lastName, int yearOfBirth) {
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean result = false;
		try {
			result = client.TCKimlikNoDogrula(nationalityId,
					firstName.toUpperCase(new Locale("tr")),
					lastName.toUpperCase(new Locale("tr")), yearOfBirth);
		} catch (NumberFormatException | RemoteException e) {
			e.printStackTrace();
		}

		return result;
	}
	
}
