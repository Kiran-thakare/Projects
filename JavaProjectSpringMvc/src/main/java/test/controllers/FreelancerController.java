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
import test.beans.Freelancer;
import test.beans.PostJob;
import test.beans.PostProject;
import test.beans.ShowJobs;
import test.dao.ProjectDao;

@Controller
public class FreelancerController {

	@Autowired
	ProjectDao dao;

	@RequestMapping("/registerfreelancer")
	public String registerPage() {

		return "registerfreelancer";
	}

	@RequestMapping("/loginfreelanser")
	public String Loginpage() {
		return "loginfreelanser";

	}

	@RequestMapping(value = "/registerfreelancer", method = RequestMethod.POST)
	public String registerDataFreelanser(@ModelAttribute("f1") Freelancer f1,
			@RequestParam("filename") MultipartFile file, @RequestParam("email") String email, ModelMap mm)
			throws IOException {

		List<Freelancer> freelanceremaildata = dao.checkemailfreelaser(email);

		if (f1.getPassword().equals(f1.getCpassword()) && freelanceremaildata.isEmpty()) {

			String filename = file.getOriginalFilename();
			String path = "C:\\Users\\kiran\\eclipse-workspace-ServletAssignment\\JavaProjectSpringMvc\\src\\main\\webapp\\files\\webimages";

			// Create the file path
			FileOutputStream fos = new FileOutputStream(path + "\\" + filename);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			// Write file bytes
			bos.write(file.getBytes());
			bos.close();

			// Set profile image in the company object
			f1.setProfilef(filename);
			dao.registerfreelanser(f1);
			mm.addAttribute("messageLogin", "Registration Successfully Done Login Now..!");
			return "loginfreelanser";
		}

		mm.addAttribute("messageerr", "Email Already Exists..... && Check all Deatils... ");
		return "registerfreelancer";
	}

	@RequestMapping(value = "/logincheckfreelanser", method = RequestMethod.POST)
	public String checkLoginFreelanser(@RequestParam("email") String email, @RequestParam("password") String pass,
			ModelMap mm, HttpSession session) {

		List<Freelancer> freelanser = dao.checkFreelanserDetails(email, pass);

		if (freelanser.isEmpty()) {
			mm.addAttribute("messageerr", "You Don't Have an Account Register First");

			return "loginfreelanser";
		}
		session.setAttribute("email", email);
		session.setAttribute("freedata", freelanser);
		return "redirect:/homefreelancer";

	}

	@RequestMapping("/homefreelancer")
	public String homefreelacer(HttpSession session, ModelMap mm) {

		String email = (String) session.getAttribute("email");
		if (email == null) {

			return "loginfreelanser";
		}

		/* count value */
		int countFreelancer = dao.getCountFreelancer();
		mm.addAttribute("count", countFreelancer);

		int countJob = dao.getCountJobs();
		mm.addAttribute("countjob", countJob);
		
		List<ShowJobs> jobInfo = dao.getJobInfo();
		mm.addAttribute("info", jobInfo);
		
		List<PostProject> projectInfo = dao.getProjectInfo();
		mm.addAttribute("pinfo", projectInfo);
		
		List<Freelancer> freelanserlist = (List<Freelancer>) session.getAttribute("freedata");
		mm.addAttribute("freelanserlistdata", freelanserlist);

		return "homefreelancer";

	}

	@RequestMapping("/logoutf")
	public String logoutFreelanser(HttpSession session) {
		session.invalidate();
		return "loginfreelanser";

	}

	@RequestMapping("/headerfilefreelancer")
	public String headerfilefreelancer() {
		return "headerfilefreelancer";

	}

	@RequestMapping("profilefreelancer")
	public String profilefreelancer(HttpSession session, ModelMap mm) {
		List<Freelancer> freelanserlist = (List<Freelancer>) session.getAttribute("freedata");
		mm.addAttribute("freelanserlistdata", freelanserlist);
		return "profilefreelancer";

	}

	@RequestMapping(value = "/updatefreelancerprofile", method = RequestMethod.POST)
	public String updatefreelancerprofile(@ModelAttribute("f1") Freelancer f1,
			@RequestParam("filename") MultipartFile file) throws IOException {

		String filename = file.getOriginalFilename();
		String path = "C:\\Users\\kiran\\eclipse-workspace-ServletAssignment\\JavaProjectSpringMvc\\src\\main\\webapp\\files\\webimages";

		// Create the file path
		FileOutputStream fos = new FileOutputStream(path + "\\" + filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		// Write file bytes
		bos.write(file.getBytes());
		bos.close();

		// Set profile image in the company object
		f1.setProfilef(filename);

		dao.updateFreeLancer(f1);

		return "loginfreelanser";

	}

	@RequestMapping("/Exploreproject")
	public String exploreprojectpage(ModelMap mm) {
		List<PostProject> projectdata = dao.showAllProjects();
		mm.addAttribute("projectinfo", projectdata);
		return "Exploreproject";

	}

	@RequestMapping(value = "/viewandapplyjobs/{id}", method = RequestMethod.GET)
	public String viewandapplyjobs(@PathVariable int id, ModelMap mm, HttpSession session) {
		List<Freelancer> freelanserlist = (List<Freelancer>) session.getAttribute("freedata");
		mm.addAttribute("freelanserlistdata", freelanserlist);

		List<PostJob> getpostjobdata = dao.getjobdata(id);
		mm.addAttribute("postjobdata", getpostjobdata);
		return "viewandapplyjobs";

	}

	@RequestMapping(value = "/viewapplyproject/{id}", method = RequestMethod.GET)
	public String viewallProjectDetails(@PathVariable int id, ModelMap mm, HttpSession session) {

		List<Freelancer> freelanserlist = (List<Freelancer>) session.getAttribute("freedata");
		mm.addAttribute("freelanserlistdata", freelanserlist);

		List<PostProject> postgetprojectdataById = dao.getallprojectdataById(id);
		mm.addAttribute("projectdatakey", postgetprojectdataById);
		return "viewapplyproject";

	}

	@RequestMapping(value = "/applyforjob", method = RequestMethod.POST)
	public String applyjobfreelancer(@ModelAttribute("a1") ApplyJob a1, @RequestParam("resumefile") MultipartFile file,
			ModelMap mm) throws IOException {

		String filename = file.getOriginalFilename();
		String path = "C:\\Users\\kiran\\eclipse-workspace-ServletAssignment\\JavaProjectSpringMvc\\src\\main\\webapp\\files\\webimages";

		// Create the file path
		FileOutputStream fos = new FileOutputStream(path + "\\" + filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		// Write file bytes
		bos.write(file.getBytes());
		bos.close();

		// Set profile image in the company object
		a1.setResume(filename);
		dao.applyJob(a1);
		mm.addAttribute("messagejobsuccess", "Congratulation Your Application Submitted Successdully...");
		return "Exploreproject";

	}

	@RequestMapping(value = "/applyforproject", method = RequestMethod.POST)
	public String applyforproject(@ModelAttribute("pro1") ApplyProject pro1,
			@RequestParam("resumefile") MultipartFile file, ModelMap mm) throws IOException {

		String filename = file.getOriginalFilename();
		String path = "C:\\Users\\kiran\\eclipse-workspace-ServletAssignment\\JavaProjectSpringMvc\\src\\main\\webapp\\files\\webimages";

		// Create the file path
		FileOutputStream fos = new FileOutputStream(path + "\\" + filename);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		// Write file bytes
		bos.write(file.getBytes());
		bos.close();

		// Set profile image in the company object
		pro1.setResumef(filename);
		dao.applyforproject(pro1);
		mm.addAttribute("messageproject", "Congratulation Your Project Submitted Successdully...");
		return "Exploreproject";

	}

	@RequestMapping(value = "/freelancerapplication/{email}")
	public String freelancerapplication(@PathVariable String email, ModelMap mm) {
		List<ApplyJob> myapplicationdata = dao.getapplicationdata(email);
		mm.addAttribute("myapplicationdetails", myapplicationdata);
		List<ApplyProject> application = dao.getprojectapplictionById(email);
		mm.addAttribute("projectapplication", application);
		return "freelancerapplication";

	}

}
