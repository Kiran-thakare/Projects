package test.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import test.beans.ApplyJob;
import test.beans.ApplyProject;
import test.beans.Company;
import test.beans.Freelancer;
import test.beans.PostJob;
import test.beans.PostProject;
import test.beans.ShowJobs;
import test.dao.ProjectDao;

@Controller
public class CompanyController {

	@Autowired
	ProjectDao pDao;

	@RequestMapping("/registerCompany")
	public String registerPage() {
		return "registerCompany";

	}

	@RequestMapping("/loginCompany")
	public String loginCompany() {
		return "loginCompany";

	}

	@RequestMapping(value = "/registercompany", method = RequestMethod.POST)
	public String registerCompanyHandle(@ModelAttribute("company") Company company,
			@RequestParam("filename") MultipartFile file, ModelMap mm) {
		try {
			if (company.getPassword().equals(company.getCpassword())) {
				// File handling
				String filename = file.getOriginalFilename();
				String path = "C:\\Users\\kiran\\eclipse-workspace-ServletAssignment\\JavaProjectSpringMvc\\src\\main\\webapp\\files\\webimages";

				// Create the file path
				FileOutputStream fos = new FileOutputStream(path + "\\" + filename);
				BufferedOutputStream bos = new BufferedOutputStream(fos);

				// Write file bytes
				bos.write(file.getBytes());
				bos.close();

				// Set profile image in the company object
				company.setProfile(filename);

				// Save the company object
				pDao.registercompany(company);
				mm.addAttribute("register", "Registration Successfully Completed. Please log in now.");
				return "loginCompany";
			} else {
				mm.addAttribute("registererr", "Passwords do not match. Please try again.");
			}
		} catch (IOException e) {
			mm.addAttribute("registererr", "File upload failed. Please try again.");
			e.printStackTrace(); // Consider proper logging
		} catch (Exception e) {
			mm.addAttribute("registererr", "An unexpected error occurred. Please try again.");
			e.printStackTrace(); // Consider proper logging
		}

		return "registerCompany";
	}

	@RequestMapping(value = "/logincompany", method = RequestMethod.POST)
	public String loginCompany1(@RequestParam("email") String email, @RequestParam("password") String pass, ModelMap mm,
			HttpSession session) {
		List<Company> companydata = pDao.checkLoginDetails(email, pass);

		if (companydata.isEmpty()) {
			mm.put("loginkey", "Something went Wrong Check Your Details..");
			return "loginCompany";
		}
		session.setAttribute("email", email);
		session.setAttribute("companydata", companydata);
		return "redirect:/homecompany";

	}

	@RequestMapping("/homecompany")
	public String homeCompany(HttpSession session, ModelMap mm) {

		String email = (String) session.getAttribute("email");
		if (email == null) {
			return "loginCompany";
		}

		/* count value */
		int countFreelancer = pDao.getCountFreelancer();
		mm.addAttribute("count", countFreelancer);
		
		int countJob = pDao.getCountJobs();
		mm.addAttribute("countjob", countJob);

		List<Company> companydatalist = (List<Company>) session.getAttribute("companydata");
		/* send data on Homecompanypage */
		mm.addAttribute("companykey", companydatalist);
		return "homecompany";

	}

	@RequestMapping("/logoutcompany")
	public String logoutCompany(HttpSession session) {

		session.invalidate();

		return "loginCompany";

	}

	@RequestMapping("/profilec")
	public String companyProfile(HttpSession session, ModelMap mm) {

		List<Company> companydatalist = (List<Company>) session.getAttribute("companydata");
		/* send data on Homecompanypage */
		mm.addAttribute("companykey", companydatalist);
		return "profilec";

	}

	@RequestMapping(value = "/updateprofiec", method = RequestMethod.POST)
	public String updateProfile(@ModelAttribute("company") Company company,
			@RequestParam("filename") MultipartFile file, ModelMap mm) throws IOException {

		String filename = file.getOriginalFilename();
		String path = "C:\\Users\\kiran\\eclipse-workspace-ServletAssignment\\JavaProjectSpringMvc\\src\\main\\webapp\\files\\webimages";

		// Create the file path
		FileOutputStream fos = new FileOutputStream(path + "\\" + filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		// Write file bytes
		bos.write(file.getBytes());
		bos.close();

		// Set profile image in the company object
		company.setProfile(filename);

		pDao.updateofprofile(company);

		mm.addAttribute("profilem", "Profile Successfully Updated Login now... ");

		return "loginCompany";

	}

	@RequestMapping("/postJobPage")
	public String postJobPage(HttpSession session, ModelMap mm) {

		List<Company> companydatalist = (List<Company>) session.getAttribute("companydata");
		/* send data on Homecompanypage */
		mm.addAttribute("companykey", companydatalist);
		return "postJobPage";

	}

	@RequestMapping(value = "/postjobdata", method = RequestMethod.POST)
	public String postJobData(@ModelAttribute("j1") PostJob j1, ModelMap mm) {

		pDao.postJobDetails(j1);
		mm.addAttribute("Job", "Job Add Succesfully...");
		return "postJobPage";

	}

	@RequestMapping("/exploreJobs")
	public String exploreJobs(ModelMap mm) {
		List<ShowJobs> showJobData = pDao.getJobData();
		mm.addAttribute("jobdata", showJobData);
		return "messagepagecompany";

	}

	@RequestMapping("/postproject")
	public String postprojectpage(HttpSession session, ModelMap mm) {

		List<Company> companydatalist = (List<Company>) session.getAttribute("companydata");
		/* send data on Homecompanypage */
		mm.addAttribute("companykey", companydatalist);

		return "postproject";

	}

	@RequestMapping(value = "/postprojectdata", method = RequestMethod.POST)
	public String postprojectDetails(@ModelAttribute("p1") PostProject p1,
			@RequestParam("projectfile") MultipartFile file, ModelMap mm) throws IOException {

		String filename = file.getOriginalFilename();
		String path = "C:\\Users\\kiran\\eclipse-workspace-ServletAssignment\\JavaProjectSpringMvc\\src\\main\\webapp\\files\\webimages";

		// Create the file path
		FileOutputStream fos = new FileOutputStream(path + "\\" + filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		// Write file bytes
		bos.write(file.getBytes());
		bos.close();

		// Set profile image in the company object
		p1.setProjectpdf(filename);

		pDao.postprojectData(p1);
		mm.addAttribute("projectPost", "Project Post Successfully...");
		return "messagepagecompany";

	}

	@RequestMapping(value = "/viewallcandidateapplication/{name}")
	public String viewallcandidateapplication(@PathVariable String name, ModelMap mm, HttpSession session) {
		List<ApplyJob> candidatedata = pDao.getAppliction(name);
		mm.addAttribute("applicationdata", candidatedata);

		List<ApplyProject> projectApplicationData = pDao.getProjectApplicationByComapany(name);
		mm.addAttribute("projectApplicationData", projectApplicationData);

		List<Company> companydatalist = (List<Company>) session.getAttribute("companydata");
		/* send data on Homecompanypage */
		mm.addAttribute("companykey", companydatalist);
		return "viewallcandidateapplication";

	}

	@RequestMapping(value = "/updatestatusjob", method = RequestMethod.POST)
	public String updatestatusjob(@ModelAttribute("a1") ApplyJob a1, ModelMap mm) {
		pDao.updateJobStatus(a1);
		mm.addAttribute("messageupdatejob", "Job Status Updated....");
		return "messagepagecompany";

	}

	@RequestMapping(value = "/updatestatusproject", method = RequestMethod.POST)
	public String updatestatusproject(@ModelAttribute("a1") ApplyProject a1, ModelMap mm) {
		pDao.updateJobProject(a1);

		mm.addAttribute("messageupdateproject", "Project Status Updated...");
		return "messagepagecompany";

	}

	@RequestMapping("/messagepagecompany")
	public String messagepagecompany() {
		return "messagepagecompany";

	}

	@RequestMapping("/acceptjobprojectapplication/{name}")
	public String acceptjobprojectapplication(@PathVariable String name, ModelMap mm) {
		List<ApplyJob> acceptjobApplication = pDao.getacceptProjectapplication(name);
		mm.addAttribute("jobapplicationdata", acceptjobApplication);

		List<ApplyProject> ProjectData = pDao.getProjectcandidate(name);
		mm.addAttribute("ProjectData", ProjectData);

		return "acceptjobprojectapplication";

	}

	@RequestMapping("/rejectedcandidate/{name}")
	public String RejectCandidate(@PathVariable String name, ModelMap mm) {
		List<ApplyJob> reject = pDao.getrejectProjectapplication(name);
		mm.addAttribute("jobapplicationdata", reject);

		List<ApplyProject> ProjectData = pDao.getrejectedcandidate(name);
		mm.addAttribute("ProjectData", ProjectData);

		return "rejectedcandidate";

	}

	@RequestMapping("/historyjobandproject/{name}")
	public String historyofJobandProject(@PathVariable String name, ModelMap mm) {
		System.out.println(name);
		List<PostJob> jobHistory = pDao.getJobHistory(name);
		mm.addAttribute("history", jobHistory);

		List<PostProject> projectHistory = pDao.getProjectHistory(name);
		mm.addAttribute("projectHistory", projectHistory);

		return "historyjobandproject";

	}

	@RequestMapping("/editjobdetails/{id}")
	public String editjobdetails(@PathVariable int id, ModelMap mm) {

		List<PostJob> jobdataedit = pDao.getjobdata(id);
		mm.addAttribute("editdata", jobdataedit);

		return "editjobdetails";

	}

	@RequestMapping(value = "/updatenewjobdata", method = RequestMethod.POST)
	public String updatenewjobdata(@ModelAttribute("p1") PostJob p1, ModelMap mm) {
		pDao.editnewjobdata(p1);
		mm.addAttribute("messageupdate", "Updated Job Details Successfully ......");
		return "messagepagecompany";

	}

	@RequestMapping(value = "/deleteproject/{id}", method = RequestMethod.GET)
	public String deleteproject(@PathVariable int id, ModelMap mm) {
		pDao.removeProject(id);

		mm.addAttribute("messageprodelete", "Project Delete Successfully....");
		return "redirect:/messagepagecompany";

	}

	@RequestMapping(value = "/deletejob/{id}", method = RequestMethod.GET)
	public String deleteJob(@PathVariable int id, ModelMap mm) {
		pDao.removePostJob(id);

		mm.addAttribute("messagejobdelete", "Job Delete Successfully....");
		return "redirect:/messagepagecompany";

	}

	@RequestMapping("/viewallfreelancers")
	public String viewallfreelancers(ModelMap mm) {
		List<Freelancer> freelancers = pDao.getallFreelancers();
		mm.addAttribute("freelans", freelancers);

		return "viewallfreelancers";

	}

}
