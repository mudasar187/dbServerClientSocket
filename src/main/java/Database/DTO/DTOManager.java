package Database.DTO;

public class DTOManager {

    private DTO dto;

    public DTOManager(DTO dto) {
        setDto(dto);
    }

    private void setDto(DTO dto) {
        this.dto = dto;
    }

    public DTO getDto() {
        return this.dto;
    }

}
