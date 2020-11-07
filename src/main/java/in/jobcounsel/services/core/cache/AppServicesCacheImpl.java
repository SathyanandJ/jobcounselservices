package in.jobcounsel.services.core.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

@Service
public class AppServicesCacheImpl implements AppServicesCache {

	private static List<Sector> allSectorsStatic = new ArrayList<>();
	private static List<Branch> allBranchesStatic = new ArrayList<>();
	private static List<Organization> allOrganizationsStatic = new ArrayList();

	@Override
	public List<Sector> getAllSectorFromCache() {
		return allSectorsStatic;
	}

	@Override
	public List<Branch> getAllBranchFromCache() {
		return allBranchesStatic;
	}

	@Override
	public List<Organization> getAllOrganizationsFromCache() {
		return allOrganizationsStatic;
	}
	
	@Override
	public boolean addAllBranchToCache(List<Branch> allBranchs) {
		allBranchesStatic.addAll(allBranchs);
		return true;
	}
	
	@Override
	public boolean addAllOrganizationsToCache(List<Organization> allOrganizations) {
		allOrganizationsStatic.addAll(allOrganizations);
		return true;
	}
	
	@Override
	public boolean addAllSectorsToCache(List<Sector> allSectors) {
		allSectorsStatic.addAll(allSectors);
		return true;
	}

	@Override
	public boolean addOrganizationToCache(Organization org) {
		allOrganizationsStatic.add(org);
		return true;
	}

	@Override
	public boolean addSectorToCache(Sector sector) {
		allSectorsStatic.add(sector);
		return true;
	}

	@Override
	public boolean addBranchToCache(Branch branch) {
		allBranchesStatic.add(branch);
		return true;
	}

	@Override
	public boolean isBranchesCached() {
		if (!allBranchesStatic.isEmpty())
			return true;
		else
			return false;

	}

	@Override
	public boolean isOrganizationCached() {
		if (!allOrganizationsStatic.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public boolean isSectorCached() {
		if (!allSectorsStatic.isEmpty())
			return true;
		else
			return false;
	}

}
