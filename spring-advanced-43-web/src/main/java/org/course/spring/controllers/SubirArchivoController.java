package org.course.spring.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.course.spring.beans.FileUpload;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class SubirArchivoController extends SimpleFormController {
    private String caminoRelativo;

    public String getCaminoRelativo() {
        return caminoRelativo;
    }

    public void setCaminoRelativo(String caminoRelativo) {
        this.caminoRelativo = caminoRelativo;
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object comando, BindException errors) throws Exception {
        ModelAndView mav = new ModelAndView(getSuccessView());
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        if (multipartFile != null) {
            String path = String.format("%s/%s", getServletContext().getRealPath(getCaminoRelativo()),multipartFile.getOriginalFilename());
            File archivo = new File(path);
            multipartFile.transferTo(archivo);
            FileUpload info = (FileUpload) comando;
            info.setNombre(multipartFile.getOriginalFilename());
            info.setLongitud(multipartFile.getSize());
            info.setArchivos(new ArrayList<>());
            info.setArchivos(Arrays.asList(new File(getServletContext().getRealPath(getCaminoRelativo())).list()));
            mav.addObject("info", info);
        }
        return mav;
    }
}