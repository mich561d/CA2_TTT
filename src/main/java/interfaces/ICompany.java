package interfaces;

import dto.AddressDTO;
import dto.CityInfoDTO;
import dto.CompanyDTO;
import entity.Company;
import entity.Phone;
import java.util.List;

/**
 *
 * @author Michael
 */
public interface ICompany {

    public abstract Company getCompanyByIDRaw(int id);

    public abstract CompanyDTO getCompanyByEmail(String email);

    public abstract CompanyDTO getCompanyByPhone(Phone phone);

    public abstract CompanyDTO getCompanyByCVR(int cvr);

    public abstract List<CompanyDTO> getAllCompanies();

    public abstract List<CompanyDTO> getAllCompaniessByCity(CityInfoDTO city);

    public abstract List<CompanyDTO> getAllCompaniesByAddress(AddressDTO address);

    public abstract List<CompanyDTO> getAllCompaniesWithNumEmployeesOver(int amount);

    public abstract List<CompanyDTO> getAllCompaniesWithMarketValueOver(int value);

    public abstract CompanyDTO createCompany(Company company);

    public abstract CompanyDTO updateCompany(CompanyDTO updatedCompany);

    public abstract void deleteCompany(int id);
}
