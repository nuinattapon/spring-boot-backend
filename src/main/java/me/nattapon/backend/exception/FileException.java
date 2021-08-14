package me.nattapon.backend.exception;

public class FileException extends BaseException {
    public FileException(String code) {
        super("file." + code);
    }

    // id.not.found
    public static FileException fileNull() {
        return new FileException("null");
    }

    // id.not.found
    public static FileException fileMaxSize() {
        return new FileException("max.size");
    }
    // id.not.found
    public static FileException unsupportedFileType() {
        return new FileException("unsupported.type");
    }
}
