package in.jobcounsel.services.core.cache;

import java.util.List;

import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

public interface AppServicesCache {
	
	public List<Sector> getAllSectorFromCache();
	
	public List<Branch> getAllBranchFromCache();
	
	public List<Organization> getAllOrganizationsFromCache();
	
	public boolean addAllSectorsToCache(List<Sector> allSectors);
	
	public boolean addAllBranchToCache(List<Branch> allBranchs);
	
	public boolean addAllOrganizationsToCache(List<Organization> allOrganizations);
	
	public boolean addOrganizationToCache(Organization org);
	
	public boolean addSectorToCache(Sector sector);
	
	public boolean addBranchToCache(Branch branch);
	
	public boolean isBranchesCached();
	
	public boolean isSectorCached();
	
	public boolean isOrganizationCached();

}
