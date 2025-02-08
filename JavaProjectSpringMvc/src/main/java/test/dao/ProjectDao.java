package test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import test.beans.ApplyJob;
import test.beans.ApplyProject;
import test.beans.Company;
import test.beans.Freelancer;
import test.beans.PostJob;
import test.beans.PostProject;
import test.beans.ShowJobs;

public class ProjectDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void registercompany(Company c1) {

		String sql = "INSERT INTO company (name, email, number, website , profile, password, cpassword) VALUES (?, ?,?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, c1.getName(), c1.getEmail(), c1.getNumber(), c1.getWebsite(), c1.getProfile(),
				c1.getPassword(), c1.getCpassword());

	}

	public List<Company> checkLoginDetails(String email, String pass) {

		return jdbcTemplate.query("select * from company where email='" + email + "' and password='" + pass + "'",
				new RowMapper<Company>() {

					@Override
					public Company mapRow(ResultSet rs, int rowNum) throws SQLException {

						Company c1 = new Company();
						c1.setId(rs.getInt(1));
						c1.setName(rs.getString(2));
						c1.setEmail(rs.getString(3));
						c1.setNumber(rs.getString(4));
						c1.setWebsite(rs.getString(5));
						c1.setProfile(rs.getString(6));
						c1.setPassword(rs.getString(7));
						c1.setCpassword(rs.getString(8));
						c1.setAbout(rs.getString(9));
						return c1;
					}

				});

	}

	public void updateofprofile(Company c1) {

		String sql = "UPDATE company SET name = ?, email = ?, number = ?, website = ?, profile = ?, about = ? WHERE id = ?";
		jdbcTemplate.update(sql, c1.getName(), c1.getEmail(), c1.getNumber(), c1.getWebsite(), c1.getProfile(),
				c1.getAbout(), c1.getId());
	}

	public void registerfreelanser(Freelancer f1) {
		String sql = "insert into freelancer (name,email,number,date,linkedin,eduction,profilef,charge,gender,skils,password,cpassword)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, f1.getName(), f1.getEmail(), f1.getNumber(), f1.getDate(), f1.getLinkedin(),
				f1.getEduction(), f1.getProfilef(), f1.getCharge(), f1.getGender(), f1.getSkills(), f1.getPassword(),
				f1.getCpassword());
	}

	public List<Freelancer> checkFreelanserDetails(String email, String pass) {

		return jdbcTemplate.query("select * from freelancer where email='" + email + "' and password='" + pass + "'",
				new RowMapper<Freelancer>() {

					@Override
					public Freelancer mapRow(ResultSet rs, int rowNum) throws SQLException {

						Freelancer f1 = new Freelancer();
						f1.setId(rs.getInt(1));
						f1.setName(rs.getString(2));
						f1.setEmail(rs.getString(3));
						f1.setNumber(rs.getString(4));
						f1.setDate(rs.getDate(5));
						f1.setLinkedin(rs.getString(6));
						f1.setEduction(rs.getString(7));
						f1.setProfilef(rs.getString(8));
						f1.setCharge(rs.getString(9));
						f1.setGender(rs.getString(10));
						f1.setSkills(rs.getString(11));
						f1.setPassword(rs.getString(12));
						f1.setCpassword(rs.getString(13));
						return f1;
					}

				});

	}

	public List<Freelancer> checkemailfreelaser(String email) {
		return jdbcTemplate.query("select * from freelancer where email='" + email + "'", new RowMapper<Freelancer>() {

			@Override
			public Freelancer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Freelancer f1 = new Freelancer();
				f1.setId(rs.getInt(1));
				f1.setName(rs.getString(2));
				f1.setEmail(rs.getString(3));
				f1.setNumber(rs.getString(4));
				f1.setDate(rs.getDate(5));
				f1.setLinkedin(rs.getString(6));
				f1.setEduction(rs.getString(7));
				f1.setProfilef(rs.getString(8));
				f1.setCharge(rs.getString(9));
				f1.setGender(rs.getString(10));
				f1.setSkills(rs.getString(11));
				f1.setPassword(rs.getString(12));
				f1.setCpassword(rs.getString(13));
				return f1;
			}

		});

	}

	public void updateFreeLancer(Freelancer f1) {
		String sql = "UPDATE freelancer SET " + "name = ?, " + "email = ?, " + "number = ?, " + "linkedin = ?, "
				+ "eduction = ?, " + "profilef = ?, " + "charge = ?, " + "skils = ? " // Ensure there's no extra comma
																						// here
				+ "WHERE id = ?";

		// Using JdbcTemplate to execute the update
		jdbcTemplate.update(sql, f1.getName(), f1.getEmail(), f1.getNumber(), f1.getLinkedin(), f1.getEduction(),
				f1.getProfilef(), f1.getCharge(), f1.getSkills(), // Ensure the method is 'getSkills()' (correct
																	// spelling)
				f1.getId());

	}

	public void postJobDetails(PostJob j1) {

		String sql = "INSERT INTO postjob (name, email, description, title, skills, salary, role) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, j1.getName(), j1.getEmail(), j1.getDescription(), j1.getTitle(), j1.getSkills(),
				j1.getSalary(), j1.getRole());

	}

	public List<ShowJobs> getJobData() {

		return jdbcTemplate
				.query("select * from postjob right join company on postjob.name=company.name where postjob.name\r\n"
						+ "  is not null order by rand()", new RowMapper<ShowJobs>() {

							@Override
							public ShowJobs mapRow(ResultSet rs, int rowNum) throws SQLException {
								ShowJobs s1 = new ShowJobs();
								s1.setId(rs.getInt(1));
								s1.setProfilec(rs.getString(14));
								s1.setCompanyname(rs.getString(2));
								s1.setPosition(rs.getString(5));
								s1.setSkills(rs.getString(6));
								return s1;
							}

						});
		// TODO Auto-generated method stub

	}

	public void postprojectData(PostProject postProject) {
		String sql = "INSERT INTO PostProject (projectd, projectt, projectpdf, projects, projectb, cname, cemail) VALUES (?, ?, ?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, postProject.getProjectd(), postProject.getProjectt(), postProject.getProjectpdf(),
				postProject.getProjects(), postProject.getProjectb(), postProject.getCname(), postProject.getCemail());

	}

	public List<PostProject> showAllProjects() {
		return jdbcTemplate.query("select * from postproject ", new RowMapper<PostProject>() {

			@Override
			public PostProject mapRow(ResultSet rs, int rowNum) throws SQLException {
				PostProject p = new PostProject();
				p.setId(rs.getInt(1));
				p.setProjectd(rs.getString(2));
				p.setProjectt(rs.getString(3));
				p.setProjectpdf(rs.getString(4));
				p.setProjects(rs.getString(5));
				p.setProjectb(rs.getString(6));
				p.setCname(rs.getString(7));
				p.setCemail(rs.getString(8));
				return p;
			}
		});

	}

	public List<PostJob> getjobdata(int id) {
		return jdbcTemplate.query("select * from postjob where id='" + id + "'", new RowMapper<PostJob>() {

			@Override
			public PostJob mapRow(ResultSet rs, int rowNum) throws SQLException {
				PostJob ps = new PostJob();
				ps.setId(rs.getInt(1));
				ps.setName(rs.getString(2));
				ps.setEmail(rs.getString(3));
				ps.setDescription(rs.getString(4));
				ps.setTitle(rs.getString(5));
				ps.setSkills(rs.getString(6));
				ps.setSalary(rs.getString(7));
				ps.setRole(rs.getString(8));
				return ps;
			}

		});
		// TODO Auto-generated method stub

	}

	public List<PostProject> getallprojectdataById(int id) {
		return jdbcTemplate.query("select * from postproject where id='" + id + "' ", new RowMapper<PostProject>() {

			@Override
			public PostProject mapRow(ResultSet rs, int rowNum) throws SQLException {
				PostProject p = new PostProject();
				p.setId(rs.getInt(1));
				p.setProjectd(rs.getString(2));
				p.setProjectt(rs.getString(3));
				p.setProjectpdf(rs.getString(4));
				p.setProjects(rs.getString(5));
				p.setProjectb(rs.getString(6));
				p.setCname(rs.getString(7));
				p.setCemail(rs.getString(8));
				return p;
			}
		});

	}

	public void applyJob(ApplyJob a1) {

		String sql = "INSERT INTO ApplyJob (cname, position, fname, femail, resume,status) VALUES (?, ?, ?, ?, ?,?)";
		jdbcTemplate.update(sql, a1.getCname(), a1.getPosition(), a1.getFname(), a1.getFemail(), a1.getResume(),
				a1.getStatus());

	}

	public void applyforproject(ApplyProject pro1) {

		String sql = "INSERT INTO ApplyProject (projectt, cname, cemail, fname, femail, resumef,status) VALUES (?, ?, ?, ?, ?, ?,?)";

		jdbcTemplate.update(sql, pro1.getProjectt(), pro1.getCname(), pro1.getCemail(), pro1.getFname(),
				pro1.getFemail(), pro1.getResumef(), pro1.getStatus());

	}

	public List<ApplyJob> getapplicationdata(String email) {
		return jdbcTemplate.query("select * from applyjob where femail like '%" + email + "%'",
				new RowMapper<ApplyJob>() {

					@Override
					public ApplyJob mapRow(ResultSet rs, int rowNum) throws SQLException {
						ApplyJob al = new ApplyJob();
						al.setId(rs.getInt(1));
						al.setCname(rs.getString(2));
						al.setPosition(rs.getString(3));
						al.setFname(rs.getString(4));
						al.setFemail(rs.getString(5));
						al.setResume(rs.getString(6));
						al.setStatus(rs.getString(7));
						return al;
					}

				});

	}

	public List<ApplyProject> getprojectapplictionById(String email) {
		return jdbcTemplate.query("select * from ApplyProject where femail like '%" + email + "%'",
				new RowMapper<ApplyProject>() {

					@Override
					public ApplyProject mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						ApplyProject ap = new ApplyProject();
						ap.setId(rs.getInt(1));
						ap.setProjectt(rs.getString(2));
						ap.setCname(rs.getString(3));
						ap.setCemail(rs.getString(4));
						ap.setFname(rs.getString(5));
						ap.setFemail(rs.getString(6));
						ap.setResumef(rs.getString(7));
						ap.setStatus(rs.getString(8));
						return ap;
					}

				});
		// TODO Auto-generated method stub

	}

	public List<ApplyJob> getAppliction(String name) {
		return jdbcTemplate.query("select * from applyjob where cname like '%" + name + "%'",
				new RowMapper<ApplyJob>() {

					@Override
					public ApplyJob mapRow(ResultSet rs, int rowNum) throws SQLException {
						ApplyJob al = new ApplyJob();
						al.setId(rs.getInt(1));
						al.setCname(rs.getString(2));
						al.setPosition(rs.getString(3));
						al.setFname(rs.getString(4));
						al.setFemail(rs.getString(5));
						al.setResume(rs.getString(6));
						al.setStatus(rs.getString(7));
						return al;
					}

				});

	}

	public List<ApplyProject> getProjectApplicationByComapany(String name) {
		return jdbcTemplate.query("select * from ApplyProject where cname like '%" + name + "%'",
				new RowMapper<ApplyProject>() {

					@Override
					public ApplyProject mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						ApplyProject ap = new ApplyProject();
						ap.setId(rs.getInt(1));
						ap.setProjectt(rs.getString(2));
						ap.setCname(rs.getString(3));
						ap.setCemail(rs.getString(4));
						ap.setFname(rs.getString(5));
						ap.setFemail(rs.getString(6));
						ap.setResumef(rs.getString(7));
						ap.setStatus(rs.getString(8));
						return ap;
					}

				});

	}

	public void updateJobStatus(ApplyJob a1) {
		String sql = "UPDATE applyjob SET status = ? WHERE id = ?";
		jdbcTemplate.update(sql, a1.getStatus(), a1.getId());
	}

	public void updateJobProject(ApplyProject a1) {
		String sql = "UPDATE ApplyProject SET status = ? WHERE id = ?";
		jdbcTemplate.update(sql, a1.getStatus(), a1.getId());

	}

	public List<ApplyJob> getacceptProjectapplication(String name) {
		return jdbcTemplate.query("select * from applyjob where cname like '%" + name + "%' and status='Accepted'",
				new RowMapper<ApplyJob>() {

					@Override
					public ApplyJob mapRow(ResultSet rs, int rowNum) throws SQLException {
						ApplyJob al = new ApplyJob();
						al.setId(rs.getInt(1));
						al.setCname(rs.getString(2));
						al.setPosition(rs.getString(3));
						al.setFname(rs.getString(4));
						al.setFemail(rs.getString(5));
						al.setResume(rs.getString(6));
						al.setStatus(rs.getString(7));
						return al;
					}

				});

	}

	public List<ApplyProject> getProjectcandidate(String name) {
		return jdbcTemplate.query("select * from ApplyProject where cname like '%" + name + "%' and status='Accepted'",
				new RowMapper<ApplyProject>() {

					@Override
					public ApplyProject mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						ApplyProject ap = new ApplyProject();
						ap.setId(rs.getInt(1));
						ap.setProjectt(rs.getString(2));
						ap.setCname(rs.getString(3));
						ap.setCemail(rs.getString(4));
						ap.setFname(rs.getString(5));
						ap.setFemail(rs.getString(6));
						ap.setResumef(rs.getString(7));
						ap.setStatus(rs.getString(8));
						return ap;
					}

				});

	}

	public List<ApplyJob> getrejectProjectapplication(String name) {
		return jdbcTemplate.query("select * from applyjob where cname like '%" + name + "%' and status='Rejected'",
				new RowMapper<ApplyJob>() {

					@Override
					public ApplyJob mapRow(ResultSet rs, int rowNum) throws SQLException {
						ApplyJob al = new ApplyJob();
						al.setId(rs.getInt(1));
						al.setCname(rs.getString(2));
						al.setPosition(rs.getString(3));
						al.setFname(rs.getString(4));
						al.setFemail(rs.getString(5));
						al.setResume(rs.getString(6));
						al.setStatus(rs.getString(7));
						return al;
					}

				});
	}

	public List<ApplyProject> getrejectedcandidate(String name) {
		return jdbcTemplate.query("select * from ApplyProject where cname like '%" + name + "%' and status='Rejected'",
				new RowMapper<ApplyProject>() {

					@Override
					public ApplyProject mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						ApplyProject ap = new ApplyProject();
						ap.setId(rs.getInt(1));
						ap.setProjectt(rs.getString(2));
						ap.setCname(rs.getString(3));
						ap.setCemail(rs.getString(4));
						ap.setFname(rs.getString(5));
						ap.setFemail(rs.getString(6));
						ap.setResumef(rs.getString(7));
						ap.setStatus(rs.getString(8));
						return ap;
					}

				});

	}

	public List<PostJob> getJobHistory(String name) {

		return jdbcTemplate.query("select * from postjob where name like '%" + name + "%'", new RowMapper<PostJob>() {

			@Override
			public PostJob mapRow(ResultSet rs, int rowNum) throws SQLException {
				PostJob ps = new PostJob();
				ps.setId(rs.getInt(1));
				ps.setName(rs.getString(2));
				ps.setEmail(rs.getString(3));
				ps.setDescription(rs.getString(4));
				ps.setTitle(rs.getString(5));
				ps.setSkills(rs.getString(6));
				ps.setSalary(rs.getString(7));
				ps.setRole(rs.getString(8));
				return ps;
			}

		});
		// TODO Auto-generated method stub

	}

	public List<PostProject> getProjectHistory(String name) {
		return jdbcTemplate.query("select * from postproject where cname like '%" + name + "%'",
				new RowMapper<PostProject>() {

					@Override
					public PostProject mapRow(ResultSet rs, int rowNum) throws SQLException {
						PostProject p = new PostProject();
						p.setId(rs.getInt(1));
						p.setProjectd(rs.getString(2));
						p.setProjectt(rs.getString(3));
						p.setProjectpdf(rs.getString(4));
						p.setProjects(rs.getString(5));
						p.setProjectb(rs.getString(6));
						p.setCname(rs.getString(7));
						p.setCemail(rs.getString(8));
						return p;
					}
				});
	}

	public void editnewjobdata(PostJob postJob) {
		String sql = "UPDATE postjob SET name = ?, email = ?, description = ?, title = ?, skills = ?, salary = ?, role = ? WHERE id = ?";
		jdbcTemplate.update(sql, postJob.getName(), postJob.getEmail(), postJob.getDescription(), postJob.getTitle(),
				postJob.getSkills(), postJob.getSalary(), postJob.getRole(), postJob.getId());

	}

	public void removePostJob(int id) {

		jdbcTemplate.update("delete from postjob where id='" + id + "'");

	}

	public void removeProject(int id) {

		jdbcTemplate.update("delete from postproject where id='" + id + "'");

	}

	public List<Freelancer> getallFreelancers() {
		return jdbcTemplate.query("select * from freelancer ", new RowMapper<Freelancer>() {

			@Override
			public Freelancer mapRow(ResultSet rs, int rowNum) throws SQLException {

				Freelancer f1 = new Freelancer();
				f1.setId(rs.getInt(1));
				f1.setName(rs.getString(2));
				f1.setEmail(rs.getString(3));
				f1.setNumber(rs.getString(4));
				f1.setDate(rs.getDate(5));
				f1.setLinkedin(rs.getString(6));
				f1.setEduction(rs.getString(7));
				f1.setProfilef(rs.getString(8));
				f1.setCharge(rs.getString(9));
				f1.setGender(rs.getString(10));
				f1.setSkills(rs.getString(11));
				f1.setPassword(rs.getString(12));
				f1.setCpassword(rs.getString(13));
				return f1;
			}

		});

	}

	public int getCountFreelancer() {
		return jdbcTemplate.queryForObject("select COUNT(*) from freelancer ", Integer.class);

	}

	public int getCountJobs() {

		return jdbcTemplate.queryForObject("select COUNT(*) from postjob ", Integer.class);
	}

	public List<ShowJobs> getJobInfo() {
		return jdbcTemplate
				.query("select * from postjob right join company on postjob.name=company.name where postjob.name\r\n"
						+ "  is not null order by rand()", new RowMapper<ShowJobs>() {

							@Override
							public ShowJobs mapRow(ResultSet rs, int rowNum) throws SQLException {
								ShowJobs s1 = new ShowJobs();
								s1.setId(rs.getInt(1));
								s1.setProfilec(rs.getString(14));
								s1.setCompanyname(rs.getString(2));
								s1.setPosition(rs.getString(5));
								s1.setSkills(rs.getString(6));
								return s1;
							}

						});

	}

	public List<PostProject> getProjectInfo() {
		return jdbcTemplate.query("select * from postproject ", new RowMapper<PostProject>() {

			@Override
			public PostProject mapRow(ResultSet rs, int rowNum) throws SQLException {
				PostProject p = new PostProject();
				p.setId(rs.getInt(1));
				p.setProjectd(rs.getString(2));
				p.setProjectt(rs.getString(3));
				p.setProjectpdf(rs.getString(4));
				p.setProjects(rs.getString(5));
				p.setProjectb(rs.getString(6));
				p.setCname(rs.getString(7));
				p.setCemail(rs.getString(8));
				return p;
			}
		});

	}

}
