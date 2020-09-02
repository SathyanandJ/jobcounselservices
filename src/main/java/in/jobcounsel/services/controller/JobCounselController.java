package in.jobcounsel.services.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.JobCounselServices;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

@RestController
@RequestMapping(value = "/services/v1/")
@PropertySource("classpath:application.properties")
public class JobCounselController {

	@Autowired
	JobCounselServices jobCounselServices;

	Logger logger = LoggerFactory.getLogger(JobCounselController.class);
	
	@Value( "${application.lightweight.restservices.timout}" )
	private Long lightWeightServiceTimeout;
	
	@Value( "${application.heavyweight.restservices.timout}" )
	private Long heavyWeightServiceTimeout;
	
	
	@GetMapping(value = "jobs/sectors")
	public DeferredResult<ResponseEntity<?>> getAllSectorTypes() {
		DeferredResult<ResponseEntity<?>> output = new DeferredResult<>(lightWeightServiceTimeout);
		output.onTimeout(()->output.setErrorResult(ControllerResponseGenerationHelper.getDefaultTimeoutRunnableResponseHeader()));
		
		ForkJoinPool.commonPool().submit(() -> {
			List<Sector> sectorList = null;
			try {
				sectorList = jobCounselServices.getAllSectors();
				output.setResult(ResponseEntity.ok().headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(sectorList));
			} catch (JobServicesException e) {
				logger.error("Error While Getting All Sectors");
				sectorList = new ArrayList<Sector>();
				output.setResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(sectorList));
			}
		});
		return output;
	}
	
	@GetMapping(value = "jobs/branches")
	public DeferredResult<ResponseEntity<?>> getAllBranchTypes() {
		DeferredResult<ResponseEntity<?>> output = new DeferredResult<>(lightWeightServiceTimeout);
		output.onTimeout(()->output.setErrorResult(ControllerResponseGenerationHelper.getDefaultTimeoutRunnableResponseHeader()));
		
		ForkJoinPool.commonPool().submit(() -> {
			List<Branch> branchList = null;
			try {
				branchList = jobCounselServices.getAllBranches();
				output.setResult(ResponseEntity.ok().headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(branchList));
			} catch (JobServicesException e) {
				logger.error("Error While Getting All Sectors");
				branchList = new ArrayList<Branch>();
				output.setResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(branchList));
			}
		});
		return output;
	}
	
	@GetMapping(value = "jobs/organizations")
	public DeferredResult<ResponseEntity<?>> getAllOrgTypes() {
		DeferredResult<ResponseEntity<?>> output = new DeferredResult<>(lightWeightServiceTimeout);
		output.onTimeout(()->output.setErrorResult(ControllerResponseGenerationHelper.getDefaultTimeoutRunnableResponseHeader()));
		
		ForkJoinPool.commonPool().submit(() -> {
			List<Organization> organizationList = null;
			try {
				organizationList = jobCounselServices.getAllOrganizations();
				output.setResult(ResponseEntity.ok().headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(organizationList));
			} catch (JobServicesException e) {
				logger.error("Error While Getting All Sectors");
				organizationList = new ArrayList<Organization>();
				output.setResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(organizationList));
			}
		});
		return output;
	}
	
	

	@GetMapping(value = "jobs/count")
	public DeferredResult<ResponseEntity<?>> getAllJobsCount() {
		DeferredResult<ResponseEntity<?>> output = new DeferredResult<>(lightWeightServiceTimeout);
		output.onTimeout(()->output.setErrorResult(ControllerResponseGenerationHelper.getDefaultTimeoutRunnableResponseHeader()));
		
		ForkJoinPool.commonPool().submit(() -> {
			JobCount jobCount = null;
			try {
				Thread.sleep(3000);
				jobCount = jobCounselServices.getAllJobsCount();
				output.setResult(ResponseEntity.ok().headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(jobCount));
			} catch (JobServicesException | InterruptedException e) {
				logger.error("Error While Processing Total Job Count");
				jobCount = new JobCount();
				output.setResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(jobCount));
			}
		});
		
		return output;
	}

	@GetMapping(value = "jobs/{categoryid}")
	public DeferredResult<ResponseEntity<?>> getAllJobsByCategory(
			@PathVariable(name = "categoryid") Integer categoryId) {
		DeferredResult<ResponseEntity<?>> output = new DeferredResult<>(heavyWeightServiceTimeout);
		output.onTimeout(()->output.setErrorResult(ControllerResponseGenerationHelper.getDefaultTimeoutRunnableResponseHeader()));

		ForkJoinPool.commonPool().submit(() -> {
			List<Job> jobsList = null;
			try {
				jobsList = jobCounselServices.getAllJobsByCategory(categoryId);
				output.setResult(ResponseEntity.ok().headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(jobsList));
			} catch (JobServicesException e) {
				logger.error("Error While Processing Total Job Count");
				jobsList = new ArrayList<Job>();
				output.setResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(jobsList));
			}
			
		});
		return output;
	}

	@GetMapping(value = "jobs/{categoryid}/{typeid}")
	public DeferredResult<ResponseEntity<?>> getAllJobsByCategoryAndType(
			@PathVariable(name = "categoryid") Integer categoryId, @PathVariable(name = "typeid") Integer typeId) {
		DeferredResult<ResponseEntity<?>> output = new DeferredResult<>(heavyWeightServiceTimeout);
		output.onTimeout(()->output.setErrorResult(ControllerResponseGenerationHelper.getDefaultTimeoutRunnableResponseHeader()));

		ForkJoinPool.commonPool().submit(() -> {
			List<Job> jobsList = null;
			try {
				jobsList = jobCounselServices.getAllJobs(categoryId, typeId);
				output.setResult(ResponseEntity.ok().headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(jobsList));
			} catch (JobServicesException e) {
				logger.error("Error While Processing Total Job Count");
				jobsList = new ArrayList<Job>();
				output.setResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(jobsList));
			}
		});
		return output;
	}

	@GetMapping(value = "jobs/{jobid}/detail")
	public DeferredResult<ResponseEntity<?>> getJobDetails(@PathVariable(name = "jobid") Long jobId) {
		DeferredResult<ResponseEntity<?>> output = new DeferredResult<>(lightWeightServiceTimeout);
		output.onTimeout(()->output.setErrorResult(ControllerResponseGenerationHelper.getDefaultTimeoutRunnableResponseHeader()));

		ForkJoinPool.commonPool().submit(() -> {
			Job jobDetail = null;
			try {
				jobDetail = jobCounselServices.getJobDetails(jobId);
				output.setResult(ResponseEntity.ok().headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(jobDetail));
			} catch (JobServicesException e) {
				logger.error("Error While Processing Total Job Count");
				jobDetail = new Job();
				output.setResult(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(ControllerResponseGenerationHelper.getDefaultJsonHeader())
						.body(jobDetail));
			}
		});
		return output;
	}

}
