package in.ashokit.service;

import in.ashokit.request.RegisterRequest;
import in.ashokit.responses.RegisterResponse;

public interface UserService {

	RegisterResponse register(RegisterRequest registerRequest);
}
