package Banks;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

@Path("/")
public class BankService {

	@GET
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public String login() {

		String jwtId = "SOMEID1234";
		String jwtIssuer = "JWT Demo";
		String jwtSubject = "Ashish";
		int jwtTimeToLive = 432000000;

		String jwt = JWTTokenNeededFilter.createJWT(jwtId, // claim = jti
				jwtIssuer, // claim = iss
				jwtSubject, // claim = sub
				jwtTimeToLive // used to calculate expiration (claim = exp)
		);
		return jwt;
	}

	@GET
	@JWTTokenNeeded
	@Path("/Branches")
	@Produces(MediaType.APPLICATION_XML)
	public List<Branches> getBranchesDetails(@QueryParam("bank_name") String bank_name, @QueryParam("city_name") String city_name,
			@QueryParam("limit") String limit, @QueryParam("offset") String offset) {
		String Limit;
		String Offset;
		BranchesDao branchesDao = new BranchesDao();
		if (bank_name == null || city_name == null) {
			return null;
		}
		if (limit != null && offset != null) {
			Limit = "limit " + limit;
			Offset = "offset " + offset;
			return branchesDao.getAllBranches(bank_name, city_name, Limit, Offset);

		}

		if (limit != null) {
			Limit = "limit " + limit;
			return branchesDao.getAllBranches(bank_name, city_name, Limit);
		}
		if (offset != null) {
			Offset = "offset " + offset;
			return branchesDao.getAllBranches(bank_name, city_name, Offset);
		}

		return branchesDao.getAllBranches(bank_name, city_name);
	}
	@GET
	@JWTTokenNeeded
	@Path("/Banks")
	@Produces(MediaType.APPLICATION_XML)
	public List<Bank> getBanksDetails(@QueryParam("ifsc") String ifsc,@QueryParam("limit") String limit, @QueryParam("offset") String offset){
		BanksDao banksDao = new BanksDao();
		String Limit;
		String Offset;
		BranchesDao branchesDao = new BranchesDao();
		if (ifsc == null ) {
			return null;
		}
		if (limit != null && offset != null) {
			Limit = "limit " + limit;
			Offset = "offset " + offset;
			return banksDao.getAllBanks(ifsc,Limit,Offset);

		}

		if (limit != null) {
			Limit = "limit " + limit;
			return  banksDao.getAllBanks(ifsc,Limit);
		}
		if (offset != null) {
			Offset = "offset " + offset;
			return banksDao.getAllBanks(ifsc,Offset);
		}
		return  banksDao.getAllBanks(ifsc);

	}

}
