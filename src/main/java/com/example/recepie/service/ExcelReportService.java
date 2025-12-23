//package com.example.recepie.service;
//
//import com.example.recepie.model.Recipe;
//import com.example.recepie.repository.RecipeRepository;
//
//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class ExcelReportService {
//
//    @Autowired
//    private RecipeRepository recipeRepository;
//
//    public ByteArrayInputStream generateRecipesReport() {
//        List<Recipe> recipes = recipeRepository.findAll();
//
//        try (Workbook workbook = new XSSFWorkbook()) {
//            Sheet sheet = (Sheet) workbook.createSheet("Рецепты");
//
//            // Заголовки
//            Row headerRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);
//            String[] columns = {"Название", "Категория", "Время приготовления", "Сложность", "Рейтинг"};
//
//            for (int i = 0; i < columns.length; i++) {
//                Cell cell = headerRow.createCell(i);
//                cell.setCellValue(columns[i]);
//            }
//
//            // Данные
//            int rowIdx = 1;
//            for (Recipe recipe : recipes) {
//                Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(rowIdx++);
//                row.createCell(0).setCellValue(recipe.getTitle());
//                row.createCell(1).setCellValue(recipe.getCategory());
//                row.createCell(2).setCellValue(recipe.getCookingTime());
//                row.createCell(3).setCellValue(recipe.getDifficulty());
//                row.createCell(4).setCellValue(recipe.getRating());
//            }
//
//            // Автоподбор ширины колонок
//            for (int i = 0; i < columns.length; i++) {
//                ((org.apache.poi.ss.usermodel.Sheet) sheet).autoSizeColumn(i);
//            }
//
//            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//            workbook.write(outputStream);
//            return new ByteArrayInputStream(outputStream.toByteArray());
//
//        } catch (IOException e) {
//            throw new RuntimeException("Ошибка генерации Excel отчета");
//        }
//    }
//}
