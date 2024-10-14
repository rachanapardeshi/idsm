package errorHandlers;



import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Class to hold the error entities in the response
 */
@Schema(name="ErrorMessage", description="")
public class ErrorMessage {
	private String userMessage;
	private String errorCode;
	private String errorDescription;
	private String moreInfo;

	public ErrorMessage(){};

	public ErrorMessage(String errorCode, String userMessage, String errorDescription, String moreInfo){
		this.errorCode = errorCode;
		this.userMessage = userMessage;
		this.errorDescription = errorDescription;
		this.moreInfo = moreInfo;
	}

	public ErrorMessage(ErrorCode errorCode) {
		this.errorCode = errorCode.toString();
		this.userMessage = errorCode.getUserMessage();
		this.errorDescription = errorCode.getErrorDescription();
	}

	public ErrorMessage(ErrorCode errorCode, String moreInfo) {
		this.errorCode = errorCode.toString();
		this.userMessage = errorCode.getUserMessage();
		this.errorDescription = errorCode.getErrorDescription();
		this.moreInfo = moreInfo;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
}
