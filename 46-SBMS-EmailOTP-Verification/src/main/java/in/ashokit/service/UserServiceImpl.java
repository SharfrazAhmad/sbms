package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.repository.UserRepository;
import in.ashokit.request.RegisterRequest;
import in.ashokit.responses.RegisterResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	@Autowired
	private final UserRepository userRepository;

	@Override
	public RegisterResponse register(RegisterRequest registerRequest) {
		UserRepository.findByEmail(registerRequest.getEmail());
		return null;
	}

}
