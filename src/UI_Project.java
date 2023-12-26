import java.util.*;
import javax.security.auth.callback.TextOutputCallback;
import javax.swing.*;
import javax.swing.tree.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.Dialog.ModalityType;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.MenuItemUI;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicMenuItemUI;
import javax.swing.plaf.basic.BasicMenuUI;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.w3c.dom.css.RGBColor;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.nio.file.*;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.AttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.*;
import java.util.List;
class Frame extends JFrame implements KeyListener,MouseListener,MouseMotionListener,MenuListener{
    Image icon;
    ImageIcon fileter = new ImageIcon("./image/fileter.png");
    Image filetero=fileter.getImage().getScaledInstance(12,12,Image.SCALE_SMOOTH);
    ImageIcon fileteron=new ImageIcon(filetero);
    ImageIcon orb_ext = new ImageIcon("./image/orb_extension.png");
    Image orb_exto=orb_ext.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
    ImageIcon orb_exton=new ImageIcon(orb_exto);
    ImageIcon icon_java_ext_= new ImageIcon("./image/java.png");
    Image i_java_ext=icon_java_ext_.getImage();
    Image j_java_ext=i_java_ext.getScaledInstance(25,22,Image.SCALE_SMOOTH);
    ImageIcon icon_java_ext=new ImageIcon(j_java_ext);
    ImageIcon fileteron_1=orb_exton,fileteron_2=orb_exton,fileteron_3=orb_exton,fileteron_4=orb_exton,fileteron_5=orb_exton;
    ImageIcon fileion_1=orb_exton,fileion_2=orb_exton,fileion_3=orb_exton,fileion_4=orb_exton,fileion_5=orb_exton;
    JMenuBar mb;
    JMenu arrow;
    JLabel file1,file2,file3,file4,file5;
    JLabel file1butt,file2butt,file3butt,file4butt,file5butt;
    JPanel terminal,explorer,display,exp,codepanel,codepanel_child;
    JTextArea codetarea,terminaltarea,tx,index;
    JScrollPane codesp,terminalsp,sp;
    int file_2_count=0,file_3_count=0,file_4_count=0,file_1_count=0;
    int caretpos,prevcaretpos,count=0;
    //int dirgh_enter,dirgh_enter_1=0,dirgh_enter_2=0;
    int fileselect=1,fc=1;
    int temp_new=0;
    int framefocus=0;
    String filenametemp1,filepathtemp1,filenametemp2,filepathtemp2,filenametemp3,filepathtemp3;
    String filenametemp4,filepathtemp4,filenametemp5,filepathtemp5;
    String fileopenpath,fileopenname;
    String filepathmeta="D:\\Project\\File_Meta.txt";
    String filefcpathmeta="D:\\Project\\File_Meta_1.txt";
    String filesavepathmeta="D:\\Project\\File_Meta_2.txt";
    String prepath="";
    File filetemp1,filetemp2,filetemp3,filetemp4,filetemp5,fcheck,fileopen;
    Boolean me=false,file1save,file2save,file3save,file4save,file5save;
    //Boolean dirgh_bool=false,dirgh_bool_1=false,dirgh_bool_2=false,dirgh_bool_3=false,dirgh_bool_4=false;
    //Boolean dirgh_bool_5=false,dirgh_bool_6=false;
    Boolean file2isnew=false,file3isnew=false,file4isnew=false,file5isnew=false;
    Boolean file3isopen=false;
    int f,g_resize,h_resize,k_resize,l_resize,m_resize,ft,gt_resize,ht_resize,kt_resize,lt_resize,mt_resize,xt;
    public Frame(String arg){
        super(arg);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.BLACK);
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension size=t.getScreenSize();
        this.setSize(size.width,size.height);//not run when setdecoration so you uncommnent below
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("./image/earth_1.png");
        this.setIconImage(icon.getImage());
        this.setUndecorated(true);
        this.addKeyListener(this);
        this.addMouseMotionListener(this);
        mb=new JMenuBar();
        Cursor c=new Cursor(Cursor.HAND_CURSOR);
        mb.setCursor(c);
        this.setJMenuBar(mb);
        class CustomUIItem extends BasicMenuItemUI{
            final protected void installDefaults(){
                super.installDefaults();
                selectionForeground=Color.WHITE;
                selectionBackground=Color.DARK_GRAY;
            }
        }
        JMenu arrow=new JMenu(" ");
        JMenu file=new JMenu("File ");
        JMenuItem fnew=new JMenuItem("New");
        JMenuItem open=new JMenuItem("Open");
        JMenuItem save=new JMenuItem("Save");
        JMenuItem saveas=new JMenuItem("SaveAs");
        JMenuItem rename=new JMenuItem("Rename");
        JMenu fimport=new JMenu("Import");
        JMenu fexport=new JMenu("Export");
        JMenuItem fclose=new JMenuItem("Close");
        JMenu theme=new JMenu("Theme");
        JMenu edit=new JMenu("Edit ");
        JMenuItem undo=new JMenuItem("Undo");
        JMenuItem redo=new JMenuItem("Redo");
        JMenuItem cut=new JMenuItem("Cut");
        JMenuItem copy=new JMenuItem("Copy");
        JMenuItem paste=new JMenuItem("Paste");
        JMenuItem find=new JMenuItem("Find");
        JMenuItem selectall=new JMenuItem("Select All");
        JMenu customize=new JMenu("Customize ");
        JMenuItem path=new JMenuItem("Path");
        JMenuItem project=new JMenuItem("Project");
        JMenuItem run=new JMenuItem("Run");
        JMenuItem debug=new JMenuItem("Debug");
        JMenu tools=new JMenu("Tools ");
        JMenuItem stardet=new JMenuItem("Star_Detection");
        JMenu errdet=new JMenu("Erorr_Detection");
        JMenu errcor=new JMenu("Erorr_Correction");
        JMenu security=new JMenu("Security ");
        JMenu encryption=new JMenu("Encryption");
        JMenu decryption=new JMenu("Decryption");
        JMenu digitalsign=new JMenu("Digital_Signature");
        JMenu hashing=new JMenu("Hashing");
        JMenuItem authentication=new JMenuItem("Authentication");
        JMenuItem acesscontrol=new JMenuItem("Acess_Control");
        JMenuItem setpasswd=new JMenuItem("Set_PassWord");
        JMenu analyze=new JMenu("Analyze ");
        JMenu spatial=new JMenu("Spatial");
        JMenu spectral=new JMenu("Spectral");
        JMenu temporal=new JMenu("Temporal");
        JMenu radiometric=new JMenu("Radiometric");
        JMenu grouping=new JMenu("Grouping");
        JMenu algorithms=new JMenu("Alorithms");
        JMenu query=new JMenu("Query");
        JMenu view=new JMenu("View ");
        JMenu flayout=new JMenu("Layout_File");
        JMenu splitwindow=new JMenu("Split_Window");
        JMenu layoutconsole=new JMenu("Layout_Window");
        JMenu graphplot=new JMenu("Graph_Plot");
        JMenu cn=new JMenu("Control & Navigation ");
        JMenuItem command=new JMenuItem("Command");
        JMenuItem compile=new JMenuItem("Compile");
        JMenuItem stusatelite=new JMenuItem("Status_Satelite");
        JMenuItem stusensor=new JMenuItem("Status_Sensor");
        JMenu alert=new JMenu("Alert");
        JMenu constraints=new JMenu("Constraints");
        JMenu timer=new JMenu("Timer");
        JLabel project_name=new JLabel("                    ~ Orb                ");
        project_name.setForeground(new Color(85, 242, 208));
        JLabel l=new JLabel("   ");
        Image i=icon.getImage();
        Image j=i.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon jicon=new ImageIcon(j);
        l.setIcon(jicon);
        ImageIcon iconmin = new ImageIcon("./image/minimize.png");
        JLabel min=new JLabel();
        Image mini=iconmin.getImage();
        Image minj=mini.getScaledInstance(20, 25, Image.SCALE_SMOOTH);
        ImageIcon minjicon=new ImageIcon(minj);
        min.setIcon(minjicon);
        ImageIcon iconrestore = new ImageIcon("./image/maximize.png");
        JLabel restore=new JLabel();
        Image restorei=iconrestore.getImage();
        Image restorej=restorei.getScaledInstance(22, 17, Image.SCALE_SMOOTH);
        ImageIcon restorejicon=new ImageIcon(restorej);
        restore.setIcon(restorejicon);
        ImageIcon iconclose = new ImageIcon("./image/close.png");
        JLabel close=new JLabel();
        Image closei=iconclose.getImage();
        Image closej=closei.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon closejicon=new ImageIcon(closej);
        close.setIcon(closejicon);
        JPanel p=new JPanel();
        // p.setLayout(null);
        p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
        p.setBackground(Color.BLACK);
        // p.add(close);
        close.addMouseListener(this);
        close.setName("CLOSE");
        close.setToolTipText("Close");
        // close.setBounds((int)(this.getWidth()/6.4)+50,(int)(this.getHeight()/88.88),22,22);
        close.setSize(22,22);
        // p.add(restore);
        restore.addMouseListener(this);
        restore.setName("RESTORE");
        restore.setToolTipText("Restore");
       // restore.setBounds((int)(this.getWidth()/6.4),(int)(this.getHeight()/88.88),22,22);
       restore.setSize(22,22);
       // System.out.println(this.getHeight()/88.88);
       // p.add(min);
        min.addMouseListener(this);
        min.setName("MINIMIZE");
        min.setToolTipText("Minimize");
       // min.setBounds((int)(this.getWidth()/6.4)-50,(int)(this.getHeight()/88.88),22,22);
       min.setSize(22,22);
       p.add(Box.createHorizontalGlue());
       p.add(min);
       p.add(Box.createRigidArea(new Dimension(20,0)));
       p.add(restore);
       p.add(Box.createRigidArea(new Dimension(20,0)));
       p.add(close);
        mb.add(l);
        arrow.setBorder(null);
        ImageIcon arrowf=new ImageIcon("./image/arrow.png");
        Image arrowfi=arrowf.getImage();
        Image arrowfj=arrowfi.getScaledInstance(32, 24, Image.SCALE_SMOOTH);
        ImageIcon arrowfjicon=new ImageIcon(arrowfj);
        arrow.setIcon(arrowfjicon);
        mb.add(arrow);
        file.add(fnew);
        ImageIcon fnewic = new ImageIcon("./image/new_1.png");
        Image fnewico=fnewic.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon fnewicon=new ImageIcon(fnewico);
        fnew.setIcon(fnewicon);
        file.add(open);
        ImageIcon openic = new ImageIcon("./image/open_1.png");
        Image openico=openic.getImage().getScaledInstance(19,18,Image.SCALE_SMOOTH);
        ImageIcon openicon=new ImageIcon(openico);
        open.setIcon(openicon);
        file.add(save);
        ImageIcon saveic = new ImageIcon("./image/save.png");
        Image saveico=saveic.getImage().getScaledInstance(16,16,Image.SCALE_SMOOTH);
        ImageIcon saveicon=new ImageIcon(saveico);
        save.setIcon(saveicon);
        file.add(saveas);
        ImageIcon saveasic = new ImageIcon("./image/saveas_1.png");
        Image saveasico=saveasic.getImage().getScaledInstance(16,18,Image.SCALE_SMOOTH);
        ImageIcon saveasicon=new ImageIcon(saveasico);
        saveas.setIcon(saveasicon);
        file.add(rename);
        ImageIcon renameic = new ImageIcon("./image/rename.png");
        Image renameico=renameic.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon renameicon=new ImageIcon(renameico);
        rename.setIcon(renameicon);
        file.add(fimport);
        ImageIcon fimportic = new ImageIcon("./image/import.png");
        Image fimportico=fimportic.getImage().getScaledInstance(18,19,Image.SCALE_SMOOTH);
        ImageIcon fimporticon=new ImageIcon(fimportico);
        fimport.setIcon(fimporticon);
        file.add(fexport);
        ImageIcon fexportic = new ImageIcon("./image/export.png");
        Image fexportico=fexportic.getImage().getScaledInstance(18,19,Image.SCALE_SMOOTH);
        ImageIcon fexporticon=new ImageIcon(fexportico);
        fexport.setIcon(fexporticon);
        file.add(theme);
        ImageIcon themeic = new ImageIcon("./image/theme.png");
        Image themeico=themeic.getImage().getScaledInstance(18,19,Image.SCALE_SMOOTH);
        ImageIcon themeicon=new ImageIcon(themeico);
        theme.setIcon(themeicon);
        file.add(fclose);
        ImageIcon fcloseic = new ImageIcon("./image/closef_1.png");
        Image fcloseico=fcloseic.getImage().getScaledInstance(20,19,Image.SCALE_SMOOTH);
        ImageIcon fcloseicon=new ImageIcon(fcloseico);
        fclose.setIcon(fcloseicon);
        file.setBorder(null);
        ImageIcon filef=new ImageIcon("./image/file.png");
        Image filefi=filef.getImage();
        Image filefj=filefi.getScaledInstance(23, 22, Image.SCALE_SMOOTH);
        ImageIcon filefjicon=new ImageIcon(filefj);
        file.setIcon(filefjicon);
        mb.add(file);
        for(int m=0;m<file.getItemCount();m++){
            file.getItem(m).setBackground(Color.BLACK);
            int x=file.getItem(m).getBorder().getBorderInsets(file.getItem(m)).right;
            file.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            file.getItem(m).setForeground(Color.WHITE);
            file.getItem(m).setCursor(c);
            file.getItem(m).setUI(new CustomUIItem());
        }
        file.getPopupMenu().setBackground(Color.BLACK);
        edit.add(undo);
        ImageIcon undoic = new ImageIcon("./image/undo.png");
        Image undoico=undoic.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon undoicon=new ImageIcon(undoico);
        undo.setIcon(undoicon);
        edit.add(redo);
        ImageIcon redoic = new ImageIcon("./image/redo.png");
        Image redoico=redoic.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon redoicon=new ImageIcon(redoico);
        redo.setIcon(redoicon);
        edit.add(cut);
        ImageIcon cutic = new ImageIcon("./image/cut.png");
        Image cutico=cutic.getImage().getScaledInstance(19,19,Image.SCALE_SMOOTH);
        ImageIcon cuticon=new ImageIcon(cutico);
        cut.setIcon(cuticon);
        edit.add(copy);
        ImageIcon copyic = new ImageIcon("./image/copy.png");
        Image copyico=copyic.getImage().getScaledInstance(20,19,Image.SCALE_SMOOTH);
        ImageIcon copyicon=new ImageIcon(copyico);
        copy.setIcon(copyicon);
        edit.add(paste);
        ImageIcon pasteic = new ImageIcon("./image/paste.png");
        Image pasteico=pasteic.getImage().getScaledInstance(18,17,Image.SCALE_SMOOTH);
        ImageIcon pasteicon=new ImageIcon(pasteico);
        paste.setIcon(pasteicon);
        edit.add(selectall);
        ImageIcon selectallic = new ImageIcon("./image/selectall.png");
        Image selectallico=selectallic.getImage().getScaledInstance(21,21,Image.SCALE_SMOOTH);
        ImageIcon selectallicon=new ImageIcon(selectallico);
        selectall.setIcon(selectallicon);
        edit.add(find);
        ImageIcon findic = new ImageIcon("./image/find.png");
        Image findico=findic.getImage().getScaledInstance(16,16,Image.SCALE_SMOOTH);
        ImageIcon findicon=new ImageIcon(findico);
        find.setIcon(findicon);
        edit.setBorder(null);
        ImageIcon editf=new ImageIcon("./image/edit.png");
        Image editfi=editf.getImage();
        Image editfj=editfi.getScaledInstance(25, 22, Image.SCALE_SMOOTH);
        ImageIcon editfjicon=new ImageIcon(editfj);
        edit.setIcon(editfjicon);
        mb.add(edit);
        for(int m=0;m<edit.getItemCount();m++){
            edit.getItem(m).setBackground(Color.BLACK);
            int x=edit.getItem(m).getBorder().getBorderInsets(edit.getItem(m)).right;
            edit.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            edit.getItem(m).setForeground(Color.WHITE);
            edit.getItem(m).setCursor(c);
            edit.getItem(m).setUI(new CustomUIItem());
        }
        customize.add(path);
        ImageIcon pathic = new ImageIcon("./image/path.png");
        Image pathico=pathic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon pathicon=new ImageIcon(pathico);
        path.setIcon(pathicon);
        customize.add(project);
        ImageIcon projectic = new ImageIcon("./image/project.png");
        Image projectico=projectic.getImage().getScaledInstance(22,22,Image.SCALE_SMOOTH);
        ImageIcon projecticon=new ImageIcon(projectico);
        project.setIcon(projecticon);
        customize.add(run);
        ImageIcon runic = new ImageIcon("./image/run.png");
        Image runico=runic.getImage().getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon runicon=new ImageIcon(runico);
        run.setIcon(runicon);
        customize.add(debug);
        ImageIcon debugic = new ImageIcon("./image/debug_1.png");
        Image debugico=debugic.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon debugicon=new ImageIcon(debugico);
        debug.setIcon(debugicon);
        customize.setBorder(null);
        ImageIcon customizef=new ImageIcon("./image/layers.png");
        Image customizefi=customizef.getImage();
        Image customizefj=customizefi.getScaledInstance(24, 20, Image.SCALE_SMOOTH);
        ImageIcon customizefjicon=new ImageIcon(customizefj);
        customize.setIcon(customizefjicon);
        mb.add(customize);
        for(int m=0;m<customize.getItemCount();m++){
            customize.getItem(m).setBackground(Color.BLACK);
            int x=customize.getItem(m).getBorder().getBorderInsets(customize.getItem(m)).right;
            customize.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            customize.getItem(m).setForeground(Color.WHITE);
            customize.getItem(m).setCursor(c);
            customize.getItem(m).setUI(new CustomUIItem());
        }
        tools.add(stardet);
        ImageIcon stardetic = new ImageIcon("./image/star_detection.png");
        Image stardetico=stardetic.getImage().getScaledInstance(25,23,Image.SCALE_SMOOTH);
        ImageIcon stardeticon=new ImageIcon(stardetico);
        stardet.setIcon(stardeticon);
        tools.add(errdet);
        ImageIcon errdetic = new ImageIcon("./image/error_detection.png");
        Image errdetico=errdetic.getImage().getScaledInstance(22,21,Image.SCALE_SMOOTH);
        ImageIcon errdeticon=new ImageIcon(errdetico);
        errdet.setIcon(errdeticon);
        tools.add(errcor);
        ImageIcon errcoric = new ImageIcon("./image/error_correction.png");
        Image errcorico=errcoric.getImage().getScaledInstance(19,18,Image.SCALE_SMOOTH);
        ImageIcon errcoricon=new ImageIcon(errcorico);
        errcor.setIcon(errcoricon);
        tools.setBorder(null);
        ImageIcon toolsf=new ImageIcon("./image/tools_1.png");
        Image toolsfi=toolsf.getImage();
        Image toolsfj=toolsfi.getScaledInstance(26, 23, Image.SCALE_SMOOTH);
        ImageIcon toolsfjicon=new ImageIcon(toolsfj);
        tools.setIcon(toolsfjicon);
        mb.add(tools);
        for(int m=0;m<tools.getItemCount();m++){
            tools.getItem(m).setBackground(Color.BLACK);
            int x=tools.getItem(m).getBorder().getBorderInsets(tools.getItem(m)).right;
            tools.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            tools.getItem(m).setForeground(Color.WHITE);
            tools.getItem(m).setCursor(c);
            tools.getItem(m).setUI(new CustomUIItem());
        }
        tools.getPopupMenu().setBackground(Color.BLACK);
        security.add(encryption);
        ImageIcon encryptionic = new ImageIcon("./image/encryption.png");
        Image encryptionico=encryptionic.getImage().getScaledInstance(24,20,Image.SCALE_SMOOTH);
        ImageIcon encryptionicon=new ImageIcon(encryptionico);
        encryption.setIcon(encryptionicon);
        security.add(decryption);
        ImageIcon decryptionic = new ImageIcon("./image/decryption.png");
        Image decryptionico=decryptionic.getImage().getScaledInstance(24,20,Image.SCALE_SMOOTH);
        ImageIcon decryptionicon=new ImageIcon(decryptionico);
        decryption.setIcon(decryptionicon);
        security.add(digitalsign);
        ImageIcon digitalsignic = new ImageIcon("./image/digitalsign.png");
        Image digitalsignico=digitalsignic.getImage().getScaledInstance(25,20,Image.SCALE_SMOOTH);
        ImageIcon digitalsignicon=new ImageIcon(digitalsignico);
        digitalsign.setIcon(digitalsignicon);
        security.add(hashing);
        ImageIcon hashingic = new ImageIcon("./image/hashing.png");
        Image hashingico=hashingic.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon hashingicon=new ImageIcon(hashingico);
        hashing.setIcon(hashingicon);
        security.add(authentication);
        ImageIcon authenticationic = new ImageIcon("./image/authentication.png");
        Image authenticationico=authenticationic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon authenticationicon=new ImageIcon(authenticationico);
        authentication.setIcon(authenticationicon);
        security.add(acesscontrol);
        ImageIcon acesscontrolic = new ImageIcon("./image/acess_control_1.png");
        Image acesscontrolico=acesscontrolic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon acesscontrolicon=new ImageIcon(acesscontrolico);
        acesscontrol.setIcon(acesscontrolicon);
        security.add(setpasswd);
        ImageIcon setpasswdic = new ImageIcon("./image/setpasswd.png");
        Image setpasswdico=setpasswdic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon setpasswdicon=new ImageIcon(setpasswdico);
        setpasswd.setIcon(setpasswdicon);
        security.setBorder(null);
        ImageIcon securityf=new ImageIcon("./image/security_2.png");
        Image securityfi=securityf.getImage();
        Image securityfj=securityfi.getScaledInstance(27, 21, Image.SCALE_SMOOTH);
        ImageIcon securityfjicon=new ImageIcon(securityfj);
        security.setIcon(securityfjicon);
        mb.add(security);
        for(int m=0;m<security.getItemCount();m++){
            security.getItem(m).setBackground(Color.BLACK);
            int x=security.getItem(m).getBorder().getBorderInsets(security.getItem(m)).right;
            security.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            security.getItem(m).setForeground(Color.WHITE);
            security.getItem(m).setCursor(c);
            security.getItem(m).setUI(new CustomUIItem());
        }
        security.getPopupMenu().setBackground(Color.BLACK);
        analyze.add(spatial);
        ImageIcon spatialic = new ImageIcon("./image/spatial.png");
        Image spatialico=spatialic.getImage().getScaledInstance(31,28,Image.SCALE_SMOOTH);
        ImageIcon spatialicon=new ImageIcon(spatialico);
        spatial.setIcon(spatialicon);
        analyze.add(spectral);
        ImageIcon spectralic = new ImageIcon("./image/spectral_2.png");
        Image spectralico=spectralic.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        ImageIcon spectralicon=new ImageIcon(spectralico);
        spectral.setIcon(spectralicon);
        analyze.add(temporal);
        ImageIcon temporalic = new ImageIcon("./image/temporal_4.png");
        Image temporalico=temporalic.getImage().getScaledInstance(32,32,Image.SCALE_SMOOTH);
        ImageIcon temporalicon=new ImageIcon(temporalico);
        temporal.setIcon(temporalicon);
        analyze.add(radiometric);
        ImageIcon radiometricic = new ImageIcon("./image/radiometric_3.png");
        Image radiometricico=radiometricic.getImage().getScaledInstance(26,24,Image.SCALE_SMOOTH);
        ImageIcon radiometricicon=new ImageIcon(radiometricico);
        radiometric.setIcon(radiometricicon);
        analyze.add(grouping);
        ImageIcon groupingic = new ImageIcon("./image/grouping.png");
        Image groupingico=groupingic.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
        ImageIcon groupingicon=new ImageIcon(groupingico);
        grouping.setIcon(groupingicon);
        analyze.add(algorithms);
        ImageIcon algorithmsic = new ImageIcon("./image/algorithm_1.png");
        Image algorithmsico=algorithmsic.getImage().getScaledInstance(24,28,Image.SCALE_SMOOTH);
        ImageIcon algorithmsicon=new ImageIcon(algorithmsico);
        algorithms.setIcon(algorithmsicon);
        analyze.add(query);
        ImageIcon queryic = new ImageIcon("./image/query_1.png");
        Image queryico=queryic.getImage().getScaledInstance(20,18,Image.SCALE_SMOOTH);
        ImageIcon queryicon=new ImageIcon(queryico);
        query.setIcon(queryicon);
        analyze.setBorder(null);
        ImageIcon analyzef=new ImageIcon("./image/analyze.png");
        Image analyzefi=analyzef.getImage();
        Image analyzefj=analyzefi.getScaledInstance(30, 23, Image.SCALE_SMOOTH);
        ImageIcon analyzefjicon=new ImageIcon(analyzefj);
        analyze.setIcon(analyzefjicon);
        mb.add(analyze);
        for(int m=0;m<analyze.getItemCount();m++){
            analyze.getItem(m).setBackground(Color.BLACK);
            int x=analyze.getItem(m).getBorder().getBorderInsets(analyze.getItem(m)).right;
            analyze.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            analyze.getItem(m).setForeground(Color.WHITE);
            analyze.getItem(m).setCursor(c);
            analyze.getItem(m).setUI(new CustomUIItem());
        }
        analyze.getPopupMenu().setBackground(Color.BLACK);
        view.add(flayout);
        ImageIcon flayoutic = new ImageIcon("./image/layout_file.png");
        Image flayoutico=flayoutic.getImage().getScaledInstance(23,21,Image.SCALE_SMOOTH);
        ImageIcon flayouticon=new ImageIcon(flayoutico);
        flayout.setIcon(flayouticon);
        view.add(splitwindow);
        ImageIcon splitwindowic = new ImageIcon("./image/split_1.png");
        Image splitwindowico=splitwindowic.getImage().getScaledInstance(20,18,Image.SCALE_SMOOTH);
        ImageIcon splitwindowicon=new ImageIcon(splitwindowico);
        splitwindow.setIcon(splitwindowicon);
        view.add(layoutconsole);
        ImageIcon layoutconsoleic = new ImageIcon("./image/layout_console.png");
        Image layoutconsoleico=layoutconsoleic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon layoutconsoleicon=new ImageIcon(layoutconsoleico);
        layoutconsole.setIcon(layoutconsoleicon);
        view.add(graphplot);
        ImageIcon graphplotic = new ImageIcon("./image/plot_2.png");
        Image graphplotico=graphplotic.getImage().getScaledInstance(21,20,Image.SCALE_SMOOTH);
        ImageIcon graphploticon=new ImageIcon(graphplotico);
        graphplot.setIcon(graphploticon);
        view.setBorder(null);
        ImageIcon viewf=new ImageIcon("./image/view_2.png");
        Image viewfi=viewf.getImage();
        Image viewfj=viewfi.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
        ImageIcon viewfjicon=new ImageIcon(viewfj);
        view.setIcon(viewfjicon);
        mb.add(view);
        for(int m=0;m<view.getItemCount();m++){
            view.getItem(m).setBackground(Color.BLACK);
            int x=view.getItem(m).getBorder().getBorderInsets(view.getItem(m)).right;
            view.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            view.getItem(m).setForeground(Color.WHITE);
            view.getItem(m).setCursor(c);
            view.getItem(m).setUI(new CustomUIItem());
        }
        view.getPopupMenu().setBackground(Color.BLACK);
        cn.add(command);
        ImageIcon commandic = new ImageIcon("./image/command.png");
        Image commandico=commandic.getImage().getScaledInstance(23,21,Image.SCALE_SMOOTH);
        ImageIcon commandicon=new ImageIcon(commandico);
        command.setIcon(commandicon);
        cn.add(compile);
        ImageIcon compileic = new ImageIcon("./image/compile.png");
        Image compileico=compileic.getImage().getScaledInstance(28,22,Image.SCALE_SMOOTH);
        ImageIcon compileicon=new ImageIcon(compileico);
        compile.setIcon(compileicon);
        cn.add(stusatelite);
        ImageIcon stusateliteic = new ImageIcon("./image/status_satellite.png");
        Image stusateliteico=stusateliteic.getImage().getScaledInstance(26,22,Image.SCALE_SMOOTH);
        ImageIcon stusateliteicon=new ImageIcon(stusateliteico);
        stusatelite.setIcon(stusateliteicon);
        cn.add(stusensor);
        ImageIcon stusensoric = new ImageIcon("./image/status_satellite_sensor.png");
        Image stusensorico=stusensoric.getImage().getScaledInstance(26,22,Image.SCALE_SMOOTH);
        ImageIcon stusensoricon=new ImageIcon(stusensorico);
        stusensor.setIcon(stusensoricon);
        cn.setBorder(null);
        ImageIcon cnf=new ImageIcon("./image/earth.png");
        Image cnfi=cnf.getImage();
        Image cnfj=cnfi.getScaledInstance(32, 24, Image.SCALE_SMOOTH);
        ImageIcon cnfjicon=new ImageIcon(cnfj);
        cn.setIcon(cnfjicon);
        mb.add(cn);
        for(int m=0;m<cn.getItemCount();m++){
            cn.getItem(m).setBackground(Color.BLACK);
            int x=cn.getItem(m).getBorder().getBorderInsets(cn.getItem(m)).right;
            cn.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            cn.getItem(m).setForeground(Color.WHITE);
            cn.getItem(m).setCursor(c);
            cn.getItem(m).setUI(new CustomUIItem());
        }
        alert.add(constraints);
        ImageIcon constraintsic = new ImageIcon("./image/constraints.png");
        Image constraintsico=constraintsic.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon constraintsicon=new ImageIcon(constraintsico);
        constraints.setIcon(constraintsicon);
        alert.add(timer);
        ImageIcon timeric = new ImageIcon("./image/timer.png");
        Image timerico=timeric.getImage().getScaledInstance(23,21,Image.SCALE_SMOOTH);
        ImageIcon timericon=new ImageIcon(timerico);
        timer.setIcon(timericon);
        alert.setBorder(null);
        ImageIcon alertf=new ImageIcon("./image/alert.png");
        Image alertfi=alertf.getImage();
        Image alertfj=alertfi.getScaledInstance(26, 22, Image.SCALE_SMOOTH);
        ImageIcon alertfjicon=new ImageIcon(alertfj);
        alert.setIcon(alertfjicon);
        mb.add(alert);
        for(int m=0;m<alert.getItemCount();m++){
            alert.getItem(m).setBackground(Color.BLACK);
            int x=alert.getItem(m).getBorder().getBorderInsets(alert.getItem(m)).right;
            alert.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            alert.getItem(m).setForeground(Color.WHITE);
            alert.getItem(m).setCursor(c);
            alert.getItem(m).setUI(new CustomUIItem());
        }
        alert.getPopupMenu().setBackground(Color.BLACK);
        JMenu farrow=new JMenu("File");
        JMenuItem farrnew=new JMenuItem("New");
        JMenuItem arropen=new JMenuItem("Open");
        JMenuItem arrsave=new JMenuItem("Save");
        JMenuItem arrsaveas=new JMenuItem("SaveAs");
        JMenuItem arrrename=new JMenuItem("Rename");
        JMenu farrimport=new JMenu("Import");
        JMenu farrexport=new JMenu("Export");
        JMenuItem farrclose=new JMenuItem("Close");
        JMenu arrtheme=new JMenu("Theme");
        farrow.add(farrnew);
        ImageIcon farrnewic = new ImageIcon("./image/new_1.png");
        Image farrnewico=farrnewic.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon farrnewicon=new ImageIcon(farrnewico);
        farrnew.setIcon(farrnewicon);
        farrow.add(arropen);
        ImageIcon arropenic = new ImageIcon("./image/open_1.png");
        Image arropenico=arropenic.getImage().getScaledInstance(19,18,Image.SCALE_SMOOTH);
        ImageIcon arropenicon=new ImageIcon(arropenico);
        arropen.setIcon(arropenicon);
        farrow.add(arrsave);
        ImageIcon arrsaveic = new ImageIcon("./image/save.png");
        Image arrsaveico=arrsaveic.getImage().getScaledInstance(16,16,Image.SCALE_SMOOTH);
        ImageIcon arrsaveicon=new ImageIcon(arrsaveico);
        arrsave.setIcon(arrsaveicon);
        farrow.add(arrsaveas);
        ImageIcon arrsaveasic = new ImageIcon("./image/saveas_1.png");
        Image arrsaveasico=arrsaveasic.getImage().getScaledInstance(16,18,Image.SCALE_SMOOTH);
        ImageIcon arrsaveasicon=new ImageIcon(arrsaveasico);
        arrsaveas.setIcon(arrsaveasicon);
        farrow.add(arrrename);
        ImageIcon arrrenameic = new ImageIcon("./image/rename.png");
        Image arrrenameico=arrrenameic.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon arrrenameicon=new ImageIcon(arrrenameico);
        arrrename.setIcon(arrrenameicon);
        farrow.add(farrimport);
        ImageIcon farrimportic = new ImageIcon("./image/import.png");
        Image farrimportico=farrimportic.getImage().getScaledInstance(18,19,Image.SCALE_SMOOTH);
        ImageIcon farrimporticon=new ImageIcon(farrimportico);
        farrimport.setIcon(farrimporticon);
        farrow.add(farrexport);
        ImageIcon farrexportic = new ImageIcon("./image/export.png");
        Image farrexportico=farrexportic.getImage().getScaledInstance(18,19,Image.SCALE_SMOOTH);
        ImageIcon farrexporticon=new ImageIcon(farrexportico);
        farrexport.setIcon(farrexporticon);
        farrow.add(arrtheme);
        ImageIcon arrthemeic = new ImageIcon("./image/theme.png");
        Image arrthemeico=arrthemeic.getImage().getScaledInstance(18,19,Image.SCALE_SMOOTH);
        ImageIcon arrthemeicon=new ImageIcon(arrthemeico);
        arrtheme.setIcon(arrthemeicon);
        farrow.add(farrclose);
        ImageIcon farrcloseic = new ImageIcon("./image/closef_1.png");
        Image farrcloseico=farrcloseic.getImage().getScaledInstance(20,19,Image.SCALE_SMOOTH);
        ImageIcon farrcloseicon=new ImageIcon(farrcloseico);
        farrclose.setIcon(farrcloseicon);
        farrow.setBorder(null);
        ImageIcon farrowf=new ImageIcon("./image/file.png");
        Image farrowfi=farrowf.getImage();
        Image farrowfj=farrowfi.getScaledInstance(23, 22, Image.SCALE_SMOOTH);
        ImageIcon farrowfjicon=new ImageIcon(farrowfj);
        farrow.setIcon(farrowfjicon);
        for(int m=0;m<farrow.getItemCount();m++){
            farrow.getItem(m).setBackground(Color.BLACK);
            int x=farrow.getItem(m).getBorder().getBorderInsets(farrow.getItem(m)).right;
            farrow.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            farrow.getItem(m).setForeground(Color.WHITE);
            farrow.getItem(m).setCursor(c);
            farrow.getItem(m).setUI(new CustomUIItem());
        }
        farrow.getPopupMenu().setBackground(Color.BLACK);
        arrow.add(farrow);
        JMenu earrow=new JMenu("Edit");
        JMenuItem arrundo=new JMenuItem("Undo");
        JMenuItem arrredo=new JMenuItem("Redo");
        JMenuItem arrcut=new JMenuItem("Cut");
        JMenuItem arrcopy=new JMenuItem("Copy");
        JMenuItem arrpaste=new JMenuItem("Paste");
        JMenuItem arrfind=new JMenuItem("Find");
        JMenuItem arrselectall=new JMenuItem("Select All");
        earrow.add(arrundo);
        ImageIcon arrundoic = new ImageIcon("./image/undo.png");
        Image arrundoico=arrundoic.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon arrundoicon=new ImageIcon(arrundoico);
        arrundo.setIcon(arrundoicon);
        earrow.add(arrredo);
        ImageIcon arrredoic = new ImageIcon("./image/redo.png");
        Image arrredoico=arrredoic.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon arrredoicon=new ImageIcon(arrredoico);
        arrredo.setIcon(arrredoicon);
        earrow.add(arrcut);
        ImageIcon arrcutic = new ImageIcon("./image/cut.png");
        Image arrcutico=arrcutic.getImage().getScaledInstance(19,19,Image.SCALE_SMOOTH);
        ImageIcon arrcuticon=new ImageIcon(arrcutico);
        arrcut.setIcon(arrcuticon);
        earrow.add(arrcopy);
        ImageIcon arrcopyic = new ImageIcon("./image/copy.png");
        Image arrcopyico=arrcopyic.getImage().getScaledInstance(20,19,Image.SCALE_SMOOTH);
        ImageIcon arrcopyicon=new ImageIcon(arrcopyico);
        arrcopy.setIcon(arrcopyicon);
        earrow.add(arrpaste);
        ImageIcon arrpasteic = new ImageIcon("./image/paste.png");
        Image arrpasteico=arrpasteic.getImage().getScaledInstance(18,17,Image.SCALE_SMOOTH);
        ImageIcon arrpasteicon=new ImageIcon(arrpasteico);
        arrpaste.setIcon(arrpasteicon);
        earrow.add(arrselectall);
        ImageIcon arrselectallic = new ImageIcon("./image/selectall.png");
        Image arrselectallico=arrselectallic.getImage().getScaledInstance(21,21,Image.SCALE_SMOOTH);
        ImageIcon arrselectallicon=new ImageIcon(arrselectallico);
        arrselectall.setIcon(arrselectallicon);
        earrow.add(arrfind);
        ImageIcon arrfindic = new ImageIcon("./image/find.png");
        Image arrfindico=arrfindic.getImage().getScaledInstance(16,16,Image.SCALE_SMOOTH);
        ImageIcon arrfindicon=new ImageIcon(arrfindico);
        arrfind.setIcon(arrfindicon);
        earrow.setBorder(null);
        ImageIcon earrowf=new ImageIcon("./image/edit.png");
        Image earrowfi=earrowf.getImage();
        Image earrowfj=earrowfi.getScaledInstance(25, 22, Image.SCALE_SMOOTH);
        ImageIcon earrowfjicon=new ImageIcon(earrowfj);
        earrow.setIcon(earrowfjicon);
        for(int m=0;m<earrow.getItemCount();m++){
            earrow.getItem(m).setBackground(Color.BLACK);
            int x=earrow.getItem(m).getBorder().getBorderInsets(earrow.getItem(m)).right;
            earrow.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            earrow.getItem(m).setForeground(Color.WHITE);
            earrow.getItem(m).setCursor(c);
            earrow.getItem(m).setUI(new CustomUIItem());
        }
        arrow.add(earrow);
        JMenu carrow=new JMenu("Customize");
        JMenuItem arrpath=new JMenuItem("Path");
        JMenuItem arrproject=new JMenuItem("Project");
        JMenuItem arrrun=new JMenuItem("Run");
        JMenuItem arrdebug=new JMenuItem("Debug");
        carrow.add(arrpath);
        ImageIcon arrpathic = new ImageIcon("./image/path.png");
        Image arrpathico=arrpathic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon arrpathicon=new ImageIcon(arrpathico);
        arrpath.setIcon(arrpathicon);
        carrow.add(arrproject);
        ImageIcon arrprojectic = new ImageIcon("./image/project.png");
        Image arrprojectico=arrprojectic.getImage().getScaledInstance(22,22,Image.SCALE_SMOOTH);
        ImageIcon arrprojecticon=new ImageIcon(arrprojectico);
        arrproject.setIcon(arrprojecticon);
        carrow.add(arrrun);
        ImageIcon arrrunic = new ImageIcon("./image/run.png");
        Image arrrunico=arrrunic.getImage().getScaledInstance(18,18,Image.SCALE_SMOOTH);
        ImageIcon arrrunicon=new ImageIcon(arrrunico);
        arrrun.setIcon(arrrunicon);
        carrow.add(arrdebug);
        ImageIcon arrdebugic = new ImageIcon("./image/debug_1.png");
        Image arrdebugico=arrdebugic.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon arrdebugicon=new ImageIcon(arrdebugico);
        arrdebug.setIcon(arrdebugicon);
        carrow.setBorder(null);
        ImageIcon carrowf=new ImageIcon("./image/layers.png");
        Image carrowfi=carrowf.getImage();
        Image carrowfj=carrowfi.getScaledInstance(24, 20, Image.SCALE_SMOOTH);
        ImageIcon carrowfjicon=new ImageIcon(carrowfj);
        carrow.setIcon(carrowfjicon);
        for(int m=0;m<carrow.getItemCount();m++){
            carrow.getItem(m).setBackground(Color.BLACK);
            int x=carrow.getItem(m).getBorder().getBorderInsets(carrow.getItem(m)).right;
            carrow.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            carrow.getItem(m).setForeground(Color.WHITE);
            carrow.getItem(m).setCursor(c);
            carrow.getItem(m).setUI(new CustomUIItem());
        }
        arrow.add(carrow);
        JMenu tarrow=new JMenu("Tools");
        JMenuItem arrstardet=new JMenuItem("Star_Detection");
        JMenu arrerrdet=new JMenu("Erorr_Detection");
        JMenu arrerrcor=new JMenu("Erorr_Correction");
        tarrow.add(arrstardet);
        ImageIcon arrstardetic = new ImageIcon("./image/star_detection.png");
        Image arrstardetico=arrstardetic.getImage().getScaledInstance(23,22,Image.SCALE_SMOOTH);
        ImageIcon arrstardeticon=new ImageIcon(arrstardetico);
        arrstardet.setIcon(arrstardeticon);
        tarrow.add(arrerrdet);
        ImageIcon arrerrdetic = new ImageIcon("./image/error_detection.png");
        Image arrerrdetico=arrerrdetic.getImage().getScaledInstance(22,21,Image.SCALE_SMOOTH);
        ImageIcon arrerrdeticon=new ImageIcon(arrerrdetico);
        arrerrdet.setIcon(arrerrdeticon);
        tarrow.add(arrerrcor);
        ImageIcon arrerrcoric = new ImageIcon("./image/error_correction.png");
        Image arrerrcorico=arrerrcoric.getImage().getScaledInstance(19,18,Image.SCALE_SMOOTH);
        ImageIcon arrerrcoricon=new ImageIcon(arrerrcorico);
        arrerrcor.setIcon(arrerrcoricon);
        tarrow.setBorder(null);
        ImageIcon tarrowf=new ImageIcon("./image/tools_1.png");
        Image tarrowfi=tarrowf.getImage();
        Image tarrowfj=tarrowfi.getScaledInstance(26, 23, Image.SCALE_SMOOTH);
        ImageIcon tarrowfjicon=new ImageIcon(tarrowfj);
        tarrow.setIcon(tarrowfjicon);
        for(int m=0;m<tarrow.getItemCount();m++){
            tarrow.getItem(m).setBackground(Color.BLACK);
            int x=tarrow.getItem(m).getBorder().getBorderInsets(tarrow.getItem(m)).right;
            tarrow.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            tarrow.getItem(m).setForeground(Color.WHITE);
            tarrow.getItem(m).setCursor(c);
            tarrow.getItem(m).setUI(new CustomUIItem());
        }
        tarrow.getPopupMenu().setBackground(Color.BLACK);
        arrow.add(tarrow);
        JMenu sarrow=new JMenu("Security");
        JMenu arrencryption=new JMenu("Encryption");
        JMenu arrdecryption=new JMenu("Decryption");
        JMenu arrdigitalsign=new JMenu("Digital_Signature");
        JMenu arrhashing=new JMenu("Hashing");
        JMenuItem arrauthentication=new JMenuItem("Authentication");
        JMenuItem arracesscontrol=new JMenuItem("Acess_Control");
        JMenuItem arrsetpasswd=new JMenuItem("Set_PassWord");
        sarrow.add(arrencryption);
        ImageIcon arrencryptionic = new ImageIcon("./image/encryption.png");
        Image arrencryptionico=arrencryptionic.getImage().getScaledInstance(24,20,Image.SCALE_SMOOTH);
        ImageIcon arrencryptionicon=new ImageIcon(arrencryptionico);
        arrencryption.setIcon(arrencryptionicon);
        sarrow.add(arrdecryption);
        ImageIcon arrdecryptionic = new ImageIcon("./image/decryption.png");
        Image arrdecryptionico=arrdecryptionic.getImage().getScaledInstance(24,20,Image.SCALE_SMOOTH);
        ImageIcon arrdecryptionicon=new ImageIcon(arrdecryptionico);
        arrdecryption.setIcon(arrdecryptionicon);
        sarrow.add(arrdigitalsign);
        ImageIcon arrdigitalsignic = new ImageIcon("./image/digitalsign.png");
        Image arrdigitalsignico=arrdigitalsignic.getImage().getScaledInstance(25,20,Image.SCALE_SMOOTH);
        ImageIcon arrdigitalsignicon=new ImageIcon(arrdigitalsignico);
        arrdigitalsign.setIcon(arrdigitalsignicon);
        sarrow.add(arrhashing);
        ImageIcon arrhashingic = new ImageIcon("./image/hashing.png");
        Image arrhashingico=arrhashingic.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon arrhashingicon=new ImageIcon(arrhashingico);
        arrhashing.setIcon(arrhashingicon);
        sarrow.add(arrauthentication);
        ImageIcon arrauthenticationic = new ImageIcon("./image/authentication.png");
        Image arrauthenticationico=arrauthenticationic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon arrauthenticationicon=new ImageIcon(arrauthenticationico);
        arrauthentication.setIcon(arrauthenticationicon);
        sarrow.add(arracesscontrol);
        ImageIcon arracesscontrolic = new ImageIcon("./image/acess_control_1.png");
        Image arracesscontrolico=arracesscontrolic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon arracesscontrolicon=new ImageIcon(arracesscontrolico);
        arracesscontrol.setIcon(arracesscontrolicon);
        sarrow.add(arrsetpasswd);
        ImageIcon arrsetpasswdic = new ImageIcon("./image/setpasswd.png");
        Image arrsetpasswdico=arrsetpasswdic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon arrsetpasswdicon=new ImageIcon(arrsetpasswdico);
        arrsetpasswd.setIcon(arrsetpasswdicon);
        sarrow.setBorder(null);
        ImageIcon sarrowf=new ImageIcon("./image/security_2.png");
        Image sarrowfi=sarrowf.getImage();
        Image sarrowfj=sarrowfi.getScaledInstance(27, 21, Image.SCALE_SMOOTH);
        ImageIcon sarrowfjicon=new ImageIcon(sarrowfj);
        sarrow.setIcon(sarrowfjicon);
        for(int m=0;m<sarrow.getItemCount();m++){
            sarrow.getItem(m).setBackground(Color.BLACK);
            int x=sarrow.getItem(m).getBorder().getBorderInsets(sarrow.getItem(m)).right;
            sarrow.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            sarrow.getItem(m).setForeground(Color.WHITE);
            sarrow.getItem(m).setCursor(c);
            sarrow.getItem(m).setUI(new CustomUIItem());
        }
        sarrow.getPopupMenu().setBackground(Color.BLACK);
        arrow.add(sarrow);
        JMenu aarrow=new JMenu("Analyze");
        JMenu arrspatial=new JMenu("Spatial");
        JMenu arrspectral=new JMenu("Spectral");
        JMenu arrtemporal=new JMenu("Temporal");
        JMenu arrradiometric=new JMenu("Radiometric");
        JMenu arrgrouping=new JMenu("Grouping");
        JMenu arralgorithms=new JMenu("Alorithms");
        JMenu arrquery=new JMenu("Query");
        aarrow.add(arrspatial);
        ImageIcon arrspatialic = new ImageIcon("./image/spatial.png");
        Image arrspatialico=arrspatialic.getImage().getScaledInstance(31,28,Image.SCALE_SMOOTH);
        ImageIcon arrspatialicon=new ImageIcon(arrspatialico);
        arrspatial.setIcon(arrspatialicon);
        aarrow.add(arrspectral);
        ImageIcon arrspectralic = new ImageIcon("./image/spectral_2.png");
        Image arrspectralico=arrspectralic.getImage().getScaledInstance(28,28,Image.SCALE_SMOOTH);
        ImageIcon arrspectralicon=new ImageIcon(arrspectralico);
        arrspectral.setIcon(arrspectralicon);
        aarrow.add(arrtemporal);
        ImageIcon arrtemporalic = new ImageIcon("./image/temporal_4.png");
        Image arrtemporalico=arrtemporalic.getImage().getScaledInstance(32,32,Image.SCALE_SMOOTH);
        ImageIcon arrtemporalicon=new ImageIcon(arrtemporalico);
        arrtemporal.setIcon(arrtemporalicon);
        aarrow.add(arrradiometric);
        ImageIcon arrradiometricic = new ImageIcon("./image/radiometric_3.png");
        Image arrradiometricico=arrradiometricic.getImage().getScaledInstance(26,24,Image.SCALE_SMOOTH);
        ImageIcon arrradiometricicon=new ImageIcon(arrradiometricico);
        arrradiometric.setIcon(arrradiometricicon);
        aarrow.add(arrgrouping);
        ImageIcon arrgroupingic = new ImageIcon("./image/grouping.png");
        Image arrgroupingico=arrgroupingic.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
        ImageIcon arrgroupingicon=new ImageIcon(arrgroupingico);
        arrgrouping.setIcon(arrgroupingicon);
        aarrow.add(arralgorithms);
        ImageIcon arralgorithmsic = new ImageIcon("./image/algorithm_1.png");
        Image arralgorithmsico=arralgorithmsic.getImage().getScaledInstance(24,28,Image.SCALE_SMOOTH);
        ImageIcon arralgorithmsicon=new ImageIcon(arralgorithmsico);
        arralgorithms.setIcon(arralgorithmsicon);
        aarrow.add(arrquery);
        ImageIcon arrqueryic = new ImageIcon("./image/query_1.png");
        Image arrqueryico=arrqueryic.getImage().getScaledInstance(20,18,Image.SCALE_SMOOTH);
        ImageIcon arrqueryicon=new ImageIcon(arrqueryico);
        arrquery.setIcon(arrqueryicon);
        aarrow.setBorder(null);
        ImageIcon aarrowf=new ImageIcon("./image/analyze.png");
        Image aarrowfi=aarrowf.getImage();
        Image aarrowfj=aarrowfi.getScaledInstance(30, 23, Image.SCALE_SMOOTH);
        ImageIcon aarrowfjicon=new ImageIcon(aarrowfj);
        aarrow.setIcon(aarrowfjicon);
        for(int m=0;m<aarrow.getItemCount();m++){
            aarrow.getItem(m).setBackground(Color.BLACK);
            int x=aarrow.getItem(m).getBorder().getBorderInsets(aarrow.getItem(m)).right;
            aarrow.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            aarrow.getItem(m).setForeground(Color.WHITE);
            aarrow.getItem(m).setCursor(c);
            aarrow.getItem(m).setUI(new CustomUIItem());
        }
        aarrow.getPopupMenu().setBackground(Color.BLACK);
        arrow.add(aarrow);
        JMenu varrow=new JMenu("View");
        JMenu arrflayout=new JMenu("Layout_File");
        JMenu arrsplitwindow=new JMenu("Split_Window");
        JMenu arrlayoutconsole=new JMenu("Layout_Window");
        JMenu arrgraphplot=new JMenu("Graph_Plot");
        varrow.add(arrflayout);
        ImageIcon arrflayoutic = new ImageIcon("./image/layout_file.png");
        Image arrflayoutico=arrflayoutic.getImage().getScaledInstance(23,21,Image.SCALE_SMOOTH);
        ImageIcon arrflayouticon=new ImageIcon(arrflayoutico);
        arrflayout.setIcon(arrflayouticon);
        varrow.add(arrsplitwindow);
        ImageIcon arrsplitwindowic = new ImageIcon("./image/split_1.png");
        Image arrsplitwindowico=arrsplitwindowic.getImage().getScaledInstance(20,18,Image.SCALE_SMOOTH);
        ImageIcon arrsplitwindowicon=new ImageIcon(arrsplitwindowico);
        arrsplitwindow.setIcon(arrsplitwindowicon);
        varrow.add(arrlayoutconsole);
        ImageIcon arrlayoutconsoleic = new ImageIcon("./image/layout_console.png");
        Image arrlayoutconsoleico=arrlayoutconsoleic.getImage().getScaledInstance(22,20,Image.SCALE_SMOOTH);
        ImageIcon arrlayoutconsoleicon=new ImageIcon(arrlayoutconsoleico);
        arrlayoutconsole.setIcon(arrlayoutconsoleicon);
        varrow.add(arrgraphplot);
        ImageIcon arrgraphplotic = new ImageIcon("./image/plot_2.png");
        Image arrgraphplotico=arrgraphplotic.getImage().getScaledInstance(21,20,Image.SCALE_SMOOTH);
        ImageIcon arrgraphploticon=new ImageIcon(arrgraphplotico);
        arrgraphplot.setIcon(arrgraphploticon);
        varrow.setBorder(null);
        ImageIcon varrowf=new ImageIcon("./image/view_2.png");
        Image varrowfi=varrowf.getImage();
        Image varrowfj=varrowfi.getScaledInstance(25, 20, Image.SCALE_SMOOTH);
        ImageIcon varrowfjicon=new ImageIcon(varrowfj);
        varrow.setIcon(varrowfjicon);
        for(int m=0;m<varrow.getItemCount();m++){
            varrow.getItem(m).setBackground(Color.BLACK);
            int x=varrow.getItem(m).getBorder().getBorderInsets(varrow.getItem(m)).right;
            varrow.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            varrow.getItem(m).setForeground(Color.WHITE);
            varrow.getItem(m).setCursor(c);
            varrow.getItem(m).setUI(new CustomUIItem());
        }
        varrow.getPopupMenu().setBackground(Color.BLACK);
        arrow.add(varrow);
        JMenu cnarrow=new JMenu("Control & Navigation");
        JMenuItem arrcommand=new JMenuItem("Command");
        JMenuItem arrcompile=new JMenuItem("Compile");
        JMenuItem arrstusatelite=new JMenuItem("Status_Satelite");
        JMenuItem arrstusensor=new JMenuItem("Status_Sensor");
        cnarrow.add(arrcommand);
        ImageIcon arrcommandic = new ImageIcon("./image/command.png");
        Image arrcommandico=arrcommandic.getImage().getScaledInstance(23,21,Image.SCALE_SMOOTH);
        ImageIcon arrcommandicon=new ImageIcon(arrcommandico);
        arrcommand.setIcon(arrcommandicon);
        cnarrow.add(arrcompile);
        ImageIcon arrcompileic = new ImageIcon("./image/compile.png");
        Image arrcompileico=arrcompileic.getImage().getScaledInstance(28,22,Image.SCALE_SMOOTH);
        ImageIcon arrcompileicon=new ImageIcon(arrcompileico);
        arrcompile.setIcon(arrcompileicon);
        cnarrow.add(arrstusatelite);
        ImageIcon arrstusateliteic = new ImageIcon("./image/status_satellite.png");
        Image arrstusateliteico=arrstusateliteic.getImage().getScaledInstance(26,22,Image.SCALE_SMOOTH);
        ImageIcon arrstusateliteicon=new ImageIcon(arrstusateliteico);
        arrstusatelite.setIcon(arrstusateliteicon);
        cnarrow.add(arrstusensor);
        ImageIcon arrstusensoric = new ImageIcon("./image/status_satellite_sensor.png");
        Image arrstusensorico=arrstusensoric.getImage().getScaledInstance(26,22,Image.SCALE_SMOOTH);
        ImageIcon arrstusensoricon=new ImageIcon(arrstusensorico);
        arrstusensor.setIcon(arrstusensoricon);
        cnarrow.setBorder(null);
        ImageIcon cnarrowf=new ImageIcon("./image/earth.png");
        Image cnarrowfi=cnarrowf.getImage();
        Image cnarrowfj=cnarrowfi.getScaledInstance(32, 24, Image.SCALE_SMOOTH);
        ImageIcon cnarrowfjicon=new ImageIcon(cnarrowfj);
        cnarrow.setIcon(cnarrowfjicon);
        for(int m=0;m<cnarrow.getItemCount();m++){
            cnarrow.getItem(m).setBackground(Color.BLACK);
            int x=cnarrow.getItem(m).getBorder().getBorderInsets(cnarrow.getItem(m)).right;
            cnarrow.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            cnarrow.getItem(m).setForeground(Color.WHITE);
            cnarrow.getItem(m).setCursor(c);
            cnarrow.getItem(m).setUI(new CustomUIItem());
        }
        arrow.add(cnarrow);
        JMenu alarrow=new JMenu("Alert");
        JMenu arrconstraints=new JMenu("Constraints");
        JMenu arrtimer=new JMenu("Timer");
        alarrow.add(arrconstraints);
        ImageIcon arrconstraintsic = new ImageIcon("./image/constraints.png");
        Image arrconstraintsico=arrconstraintsic.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon arrconstraintsicon=new ImageIcon(arrconstraintsico);
        arrconstraints.setIcon(arrconstraintsicon);
        alarrow.add(arrtimer);
        ImageIcon arrtimeric = new ImageIcon("./image/timer.png");
        Image arrtimerico=arrtimeric.getImage().getScaledInstance(23,21,Image.SCALE_SMOOTH);
        ImageIcon arrtimericon=new ImageIcon(arrtimerico);
        arrtimer.setIcon(arrtimericon);
        alarrow.setBorder(null);
        ImageIcon alarrowf=new ImageIcon("./image/alert.png");
        Image alarrowfi=alarrowf.getImage();
        Image alarrowfj=alarrowfi.getScaledInstance(26, 22, Image.SCALE_SMOOTH);
        ImageIcon alarrowfjicon=new ImageIcon(alarrowfj);
        alarrow.setIcon(alarrowfjicon);
        for(int m=0;m<alarrow.getItemCount();m++){
            alarrow.getItem(m).setBackground(Color.BLACK);
            int x=alarrow.getItem(m).getBorder().getBorderInsets(alarrow.getItem(m)).right;
            alarrow.getItem(m).setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
            alarrow.getItem(m).setForeground(Color.WHITE);
            alarrow.getItem(m).setCursor(c);
            alarrow.getItem(m).setUI(new CustomUIItem());
        }
        alarrow.getPopupMenu().setBackground(Color.BLACK);
        arrow.add(alarrow);
        for(int m=0;m<arrow.getItemCount();m++){
            arrow.getItem(m).setBackground(Color.BLACK);
            arrow.getItem(m).setForeground(Color.WHITE);
            arrow.getItem(m).setCursor(c);
        }
        arrow.getPopupMenu().setBackground(Color.BLACK);
        ImageIcon arriconmin = new ImageIcon("./image/minimize.png");
        JLabel arrmin=new JLabel("     Minimize");
        arrmin.setForeground(Color.WHITE);
        arrmin.setBackground(Color.BLACK);
        arrmin.setCursor(c);
        Image arrmini=arriconmin.getImage();
        Image arrminj=arrmini.getScaledInstance(18, 25, Image.SCALE_SMOOTH);
        ImageIcon arrminjicon=new ImageIcon(arrminj);
        arrmin.setIcon(arrminjicon);
        arrmin.addMouseListener(this);
        arrmin.setName("ARRMINIMIZE");
        arrmin.setToolTipText("Minimize");
        arrow.add(arrmin);
        ImageIcon arriconrestore = new ImageIcon("./image/maximize.png");
        JLabel arrrestore=new JLabel("     Restore");
        arrrestore.setForeground(Color.WHITE);
        arrrestore.setBackground(Color.BLACK);
        arrrestore.setCursor(c);
        Image arrrestorei=arriconrestore.getImage();
        Image arrrestorej=arrrestorei.getScaledInstance(20, 17, Image.SCALE_SMOOTH);
        ImageIcon arrrestorejicon=new ImageIcon(arrrestorej);
        arrrestore.setIcon(arrrestorejicon);
        arrrestore.addMouseListener(this);
        arrrestore.setName("ARRRESTORE");
        arrrestore.setToolTipText("Restore");
        arrow.add(arrrestore);
        ImageIcon arriconclose = new ImageIcon("./image/close.png");
        JLabel arrclose=new JLabel("   Close");
        arrclose.setForeground(Color.WHITE);
        arrclose.setBackground(Color.BLACK);
        arrclose.setCursor(c);
        Image arrclosei=arriconclose.getImage();
        Image arrclosej=arrclosei.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon arrclosejicon=new ImageIcon(arrclosej);
        arrclose.setIcon(arrclosejicon);
        arrclose.addMouseListener(this);
        arrclose.setName("ARRCLOSE");
        arrclose.setToolTipText("Close");
        arrow.add(arrclose);
        mb.add(project_name);
        mb.add(p);
        mb.setBackground(Color.BLACK);
        arrow.setBackground(Color.BLACK);
        file.setForeground(Color.WHITE);
        edit.setForeground(Color.WHITE);
        customize.setForeground(Color.WHITE);
        tools.setForeground(Color.WHITE);
        security.setForeground(Color.WHITE);
        analyze.setForeground(Color.WHITE);
        view.setForeground(Color.WHITE);
        cn.setForeground(Color.WHITE);
        alert.setForeground(Color.WHITE);
        farrow.setVisible(false);
        earrow.setVisible(false);
        carrow.setVisible(false);
        tarrow.setVisible(false);
        sarrow.setVisible(false);
        aarrow.setVisible(false);
        varrow.setVisible(false);
        cnarrow.setVisible(false);
        alarrow.setVisible(false);
        arrow.setVisible(false);
         class CustomUI extends BasicMenuUI{
            final protected void installDefaults(){
                super.installDefaults();
                selectionForeground=Color.WHITE;
                selectionBackground=Color.DARK_GRAY;
            }
        }
        arrow.setUI(new CustomUI());
        file.setUI(new CustomUI());
        edit.setUI(new CustomUI());
        customize.setUI(new CustomUI());
        tools.setUI(new CustomUI());
        security.setUI(new CustomUI());
        analyze.setUI(new CustomUI());
        view.setUI(new CustomUI());
        cn.setUI(new CustomUI());
        alert.setUI(new CustomUI());
        farrow.setUI(new CustomUI());
        earrow.setUI(new CustomUI());
        carrow.setUI(new CustomUI());
        tarrow.setUI(new CustomUI());
        sarrow.setUI(new CustomUI());
        aarrow.setUI(new CustomUI());
        varrow.setUI(new CustomUI());
        cnarrow.setUI(new CustomUI());
        alarrow.setUI(new CustomUI());
        arrow.addMenuListener(this);
        file.addMenuListener(this);
        edit.addMenuListener(this);
        customize.addMenuListener(this);
        analyze.addMenuListener(this);
        security.addMenuListener(this);
        tools.addMenuListener(this);
        cn.addMenuListener(this);
        view.addMenuListener(this);
        alert.addMenuListener(this);
        farrow.addMenuListener(this);
        earrow.addMenuListener(this);
        carrow.addMenuListener(this);
        tarrow.addMenuListener(this);
        sarrow.addMenuListener(this);
        aarrow.addMenuListener(this);
        varrow.addMenuListener(this);
        cnarrow.addMenuListener(this);
        alarrow.addMenuListener(this);
         display=new JPanel();
        display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
        display.setBackground(Color.BLACK);
        display.setLayout(new BorderLayout());
         explorer=new JPanel();
         terminal=new JPanel();//exdir
        explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
        explorer.setBackground(new Color(35, 36, 35));
        Cursor cexp=new Cursor(Cursor.HAND_CURSOR);
        ImageIcon iconfexp = new ImageIcon("./image/expfile.png");
        JLabel fexp=new JLabel();
        fexp.setCursor(cexp);
        fexp.setToolTipText("New File");
        Image fexpi=iconfexp.getImage();
        Image fexpj=fexpi.getScaledInstance(25, 23, Image.SCALE_SMOOTH);
        ImageIcon fexpjicon=new ImageIcon(fexpj);
        fexp.setIcon(fexpjicon);
        ImageIcon iconfoexp = new ImageIcon("./image/expfolder.png");
        fexp.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                file_1_count=file_1_count-1;
                file_2_count=file_2_count-1;
                file_3_count=file_3_count-1;
                file_4_count=file_4_count-1;
                if(fc<=5){
                    fc++;
                }
                if(temp_new<=5){
                    temp_new++;
                }
                if(temp_new>5){
                    ImageIcon fnewerr = new ImageIcon("./image/warning_1.png");
        Image fnewerro=fnewerr.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon fnewerron=new ImageIcon(fnewerro);
        JLabel cmbox_l=new JLabel("Sorry for your inconvenience, but the current version of Orb permits only five files to be displayed concurrently. Please remove one or more files before opening or creating a new file.");
        Toolkit tdir=Toolkit.getDefaultToolkit();
        Dimension sizedir=tdir.getScreenSize();
        cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
        cmbox_l.setBackground(Color.BLACK);
        cmbox_l.setForeground(Color.CYAN);
        JOptionPane.showMessageDialog(null,cmbox_l,"Open Error"
        ,JOptionPane.INFORMATION_MESSAGE,fnewerron);
                }
             switch(temp_new){
                case 2:
                file2.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(true);
                file3butt.setVisible(false);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file3.setBorder(null);
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=2;
                file2isnew=true;
                fileteron_2=orb_exton;
                fileion_2=orb_exton;
                 break;
                case 3:
                file3.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(true);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=3;
                file3isnew=true;
                fileteron_3=orb_exton;
                fileion_3=orb_exton;
                 break;
                case 4:
                file4.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(false);
                file4butt.setVisible(true);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(null);
                file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file5.setBorder(null);
                fileselect=4;
                file4isnew=true;
                fileteron_4=orb_exton;
                fileion_4=orb_exton;
                 break;
                case 5:
                 file5.setVisible(true);
                 file1butt.setVisible(false);
                 file2butt.setVisible(false);
                 file3butt.setVisible(false);
                 file4butt.setVisible(false);
                 file5butt.setVisible(true);
                 file1.setBorder(null);
                 file2.setBorder(null);
                 file3.setBorder(null);
                 file4.setBorder(null);
                 file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 fileselect=5;
                 file5isnew=true;
                 fileteron_5=orb_exton;
                 fileion_5=orb_exton;
                  break;
             }
             if(temp_new<=5){
                 codetarea.setText(null);
                 index.setText(null);
                 codetarea.setText("//  Welcome To Orb");
                 index.setText(" 1  ");
             }
          try{
              String fc_s=Integer.toString(temp_new);
              if(temp_new<=5){
                  BufferedWriter filefctemp1=new BufferedWriter(new FileWriter(filefcpathmeta));
                                   filefctemp1.write(fc_s);
                                   filefctemp1.flush();
                                   filefctemp1.close();
             }
          }
          catch(IOException exc){
  
          }
            }
        });
        JLabel foexp=new JLabel();
        foexp.setCursor(cexp);
        foexp.setToolTipText("New Folder");
        Image foexpi=iconfoexp.getImage();
        Image foexpj=foexpi.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon foexpjicon=new ImageIcon(foexpj);
        foexp.setIcon(foexpjicon);
        ImageIcon iconsexp = new ImageIcon("./image/expsearch.png");
        JLabel sexp=new JLabel();
        sexp.setCursor(cexp);
        sexp.setToolTipText("Search File/Folder");
        Image sexpi=iconsexp.getImage();
        Image sexpj=sexpi.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon sexpjicon=new ImageIcon(sexpj);
        sexp.setIcon(sexpjicon);
         exp=new JPanel();
        exp.setPreferredSize(new Dimension(170,50));
        exp.setLayout(new GridLayout());
        exp.setBackground(new Color(35, 36, 35));
        exp.add(fexp);
        exp.add(foexp);
        exp.add(sexp);
        explorer.add(exp);
        explorer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.BLACK ));
        File rootFile = new File("D:\\Project");
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootFile.getName());
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        addNodes(rootNode, rootFile);
        JTree fileTree = new JTree(treeModel);
        ImageIcon tnode = new ImageIcon("./image/file_hir.png");
        Image tnodeo=tnode.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon tnodeon=new ImageIcon(tnodeo);
        ImageIcon tnode2 = new ImageIcon("./image/file_hir_4.png");
        Image tnode2o=tnode2.getImage().getScaledInstance(27,22,Image.SCALE_SMOOTH);
        ImageIcon tnode2on=new ImageIcon(tnode2o);
        ImageIcon tnode3 = new ImageIcon("./image/file_hir_3.png");
        Image tnode3o=tnode3.getImage().getScaledInstance(27,22,Image.SCALE_SMOOTH);
        ImageIcon tnode3on=new ImageIcon(tnode3o);
        TreeCellRenderer cr = fileTree.getCellRenderer();
if (cr instanceof DefaultTreeCellRenderer) {
  DefaultTreeCellRenderer dtcr =
               (DefaultTreeCellRenderer)cr; 
  dtcr.setBackgroundNonSelectionColor(Color.DARK_GRAY);
  dtcr.setBackgroundSelectionColor(Color.DARK_GRAY);
  dtcr.setTextSelectionColor(new Color(3, 252, 7)); 
  dtcr.setTextNonSelectionColor(Color.CYAN); 
//    System.out.println(dtcr);
//   dtcr.addMouseListener(new MouseAdapter(){
//       public void mouseClicked(MouseEvent e){
//           System.out.println("dtcr.getText()");
//       }
//   });
//   dtcr.addFocusListener(new FocusAdapter(){
//       public void focusGained(FocusEvent e){
//         System.out.println("dtcr.getText()");
//       }
//   });
  dtcr.setLeafIcon(tnodeon);
  dtcr.setClosedIcon(tnode2on);
  dtcr.setOpenIcon(tnode3on);
} 
class fdpscBar extends BasicScrollBarUI{
    protected void configureScorllBarColors(){
       trackColor=(Color)UIManager.get("ScrollBar.track");
       thumbColor=(Color)UIManager.get("ScrollBar.thumb");
    }
protected JButton createDecreaseButton(int orientation) {
return createZeroButton();
   }
protected JButton createIncreaseButton(int orientation) {
return createZeroButton();
   }
public JButton createZeroButton() {
JButton button_1 = new JButton();
button_1.setPreferredSize(new Dimension(0, 0));
button_1.setMinimumSize(new Dimension(0, 0));
button_1.setMaximumSize(new Dimension(0, 0));
button_1.setFocusable(false);
return button_1;
    }
}
// JDialog treenodepop=new JDialog(this);
fileTree.addMouseListener(new MouseAdapter(){
   public void mouseClicked(MouseEvent e){
       TreePath p=fileTree.getPathForLocation(e.getX(),e.getY());
       if(p.getLastPathComponent()!=null){
           String path="";
           for(int i=0;i<p.getPathCount();i++){
              path=path+"\\"+p.getPathComponent(i).toString();
           }
           prepath="D:";//currently we explicitly define but when user open folder then at that time 
           //we fetch parent path upto root
           path=prepath+path;
           TreeNode t=(TreeNode)p.getLastPathComponent();
           if(t.isLeaf()){
            BufferedReader filebuf;
            String str="";
            String str1="";
             try{
                 filebuf=new BufferedReader(new FileReader(path));
                 while((str=filebuf.readLine())!=null){
                     str1=str1+str+"\n";
                }
                filebuf.close();
                JDialog treenodepop=new JDialog();
                ImageIcon treenodei = new ImageIcon("./image/import.png");
                Image treenodeio=treenodei.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
                ImageIcon treenodeion=new ImageIcon(treenodeio);
                treenodepop.setIconImage(treenodeion.getImage());
                treenodepop.setTitle(p.getLastPathComponent().toString());
                Toolkit ttnpop=Toolkit.getDefaultToolkit();
                Dimension sizetnpop=ttnpop.getScreenSize();
                treenodepop.setSize((sizetnpop.width/2),(sizetnpop.height/2));
                      treenodepop.setModal(true);
                      treenodepop.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                      treenodepop.setLocationRelativeTo(null);
                String ext_tn="";
                int dot_1=path.lastIndexOf(".");
                if(dot_1>0&dot_1<path.length()-1){
                    ext_tn=path.substring(dot_1+1);
                }
                if(ext_tn.equals("txt")||ext_tn.equals("java")||ext_tn.equals("orb")){
                //currently we explicititly define but after we should create one data storage which can 
                //store this all extension and then retrive and compare like above.
                Font fonttree=new Font("Serif",Font.BOLD,12);
                JTextArea ftreedata=new JTextArea();
                ftreedata.setText(str1);
                ftreedata.setEditable(false);
                ftreedata.setFont(fonttree);
                ftreedata.setForeground(Color.CYAN);
                ftreedata.setBackground(Color.BLACK);
                ftreedata.setFocusable(true);
                ftreedata.setSelectedTextColor(new Color(3, 252, 7));
                ftreedata.setSelectionColor(Color.DARK_GRAY);
                ftreedata.setCaretColor(Color.CYAN);
                ftreedata.setBackground(Color.BLACK);
                // File tnfile=new File(path);
                //            String name_for_ext_1=tnfile.getName();
                ftreedata.addKeyListener(new KeyAdapter(){
                    public void keyTyped(KeyEvent e){
                        int key1=(int)e.getKeyChar();
                        if(key1==23){
                            ftreedata.setLineWrap(true);
                            ftreedata.setWrapStyleWord(true);
                        }
                        if(key1==9){
                            ftreedata.setFont(ftreedata.getFont().deriveFont(ftreedata.getFont().getSize2D()+2f));
                        }
                        if(key1==4){
                            ftreedata.setFont(ftreedata.getFont().deriveFont(ftreedata.getFont().getSize2D()-2f));
                        }
                    }
                });
                JScrollPane ftreedatasc=new JScrollPane(ftreedata);
                ftreedata.setBackground(Color.BLACK);
                ftreedatasc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                ftreedatasc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                JPanel cotecorner=new JPanel();
                cotecorner.setBackground(new Color(3, 252, 7));
                ftreedatasc.setCorner(ftreedatasc.LOWER_RIGHT_CORNER, cotecorner);
                JScrollBar treedatascvbar=ftreedatasc.getVerticalScrollBar();
                treedatascvbar.setCursor(c);
                treedatascvbar.setPreferredSize(new Dimension(7,7));
                JScrollBar treedataschbar=ftreedatasc.getHorizontalScrollBar();
                treedataschbar.setCursor(c);
                treedataschbar.setPreferredSize(new Dimension(7,7));
                treedatascvbar.setUI(new fdpscBar());
                treedataschbar.setUI(new fdpscBar());
                treenodepop.add(ftreedatasc);
                treenodepop.setVisible(true);
                }
                if(ext_tn.equals("png")||ext_tn.equals("jpeg")||ext_tn.equals("jpg")){
                    Image image=new ImageIcon(path).getImage();
                    //high resolution image gets more time so must try logic for less time
                    JPanel treenodepanel=new JPanel(){
                        public void paintComponent(Graphics g){
                            super.paintComponent(g);
                            g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
                        }
                    };
                treenodepanel.setBackground(Color.BLACK);
                treenodepanel.setSize((sizetnpop.width/2),(sizetnpop.height/2));
                treenodepop.add(treenodepanel);
                treenodepop.setVisible(true);
                }
             }
             catch(IOException exc){

             }
           }
       }
   }
});
        fileTree.setBackground(new Color(54, 53, 53));
        fileTree.setForeground(Color.CYAN);
        // System.out.println(fileTree.getComponent(0));
        fileTree.setFocusable(false);
         sp=new JScrollPane(fileTree);
        sp.setCursor(c);
        sp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(54, 53, 53) ));
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setPreferredSize(new Dimension(this.getWidth()/6-10,this.getHeight()/2+50));
        JScrollBar svbar=sp.getVerticalScrollBar();
        svbar.setBackground(new Color(54, 53, 53));
        svbar.setPreferredSize(new Dimension(10,10));
        JScrollBar shbar=sp.getHorizontalScrollBar();
        shbar.setBackground(new Color(54, 53, 53));
        shbar.setPreferredSize(new Dimension(10,10));
        UIManager.put("ScrollBar.track", new Color(54, 53, 53));
        UIManager.put("ScrollBar.thumb", new Color(3, 252, 7));
        class CSBar extends BasicScrollBarUI{
            protected void configureScorllBarColors(){
               trackColor=(Color)UIManager.get("ScrollBar.track");
               thumbColor=(Color)UIManager.get("ScrollBar.thumb");
            }
      protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
           }
      protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
           }
      public JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(0, 0));
        button.setFocusable(false);
        return button;
            }
        }
        svbar.setUI(new CSBar());
        shbar.setUI(new CSBar());
        JPanel corner=new JPanel();
        corner.setBackground(new Color(3, 252, 7));
        sp.setCorner(sp.LOWER_RIGHT_CORNER, corner);
        explorer.add(sp);
        JPanel ser=new JPanel();
        tx=new JTextArea("                 Search",1,13);
        tx.setBackground(new Color(54, 53, 53));
        tx.setForeground(Color.CYAN);
        tx.setSelectedTextColor(new Color(3, 252, 7));
        tx.setSelectionColor(Color.BLACK);
        tx.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.CYAN));
        tx.setFocusable(false);
        tx.setCaretColor(Color.CYAN);
        ImageIcon seric = new ImageIcon("./image/ser.png");
        Image serico=seric.getImage().getScaledInstance(17,17,Image.SCALE_SMOOTH);
        ImageIcon sericon=new ImageIcon(serico);
        ser.setLayout(new BorderLayout());
        ser.add(tx,BorderLayout.WEST);
        JLabel temp=new JLabel(" ");
        tx.addMouseListener(new Temp3());
        JFrame tempf=this;
        tx.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e){
                tx.setText(null);
            }
            public void focusLost(FocusEvent e){
                tx.setText("                 Search");
                tempf.requestFocus();
            }
        });
        temp.setName("searchdir");
        temp.setCursor(c);
        temp.setIcon(sericon);
        temp.setIconTextGap(-30);
        ser.add(temp,BorderLayout.EAST);
        ser.setBackground(new Color(35, 36, 35));
        explorer.add(ser);
        explorer.setName("expdir");
        terminal.setName("terdir");
        explorer.addMouseListener(new Temp());
        terminal.setLayout(new BorderLayout());
        terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
        terminal.setBackground(Color.BLACK);
        JPanel tertool=new JPanel();
        tertool.setBackground(new Color(35, 36, 35));
        ImageIcon runcode = new ImageIcon("./image/run_tool.png");
        Image runcodeo=runcode.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH);
        ImageIcon runcodeon=new ImageIcon(runcodeo);
        ImageIcon split = new ImageIcon("./image/split_tool_2.png");
        Image splito=split.getImage().getScaledInstance(24,21,Image.SCALE_SMOOTH);
        ImageIcon spliton=new ImageIcon(splito);
        ImageIcon more = new ImageIcon("./image/more_tool_1.png");
        Image moreo=more.getImage().getScaledInstance(22,21,Image.SCALE_SMOOTH);
        ImageIcon moreon=new ImageIcon(moreo);
        ImageIcon moref = new ImageIcon("./image/moref_tool.png");
        Image morefo=moref.getImage().getScaledInstance(22,21,Image.SCALE_SMOOTH);
        ImageIcon morefon=new ImageIcon(morefo);
        ImageIcon setting = new ImageIcon("./image/setting_1.png");
        Image settingo=setting.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
        ImageIcon settingon=new ImageIcon(settingo);
        ImageIcon login = new ImageIcon("./image/login_6.png");
        Image logino=login.getImage().getScaledInstance(23,22,Image.SCALE_SMOOTH);
        ImageIcon loginon=new ImageIcon(logino);
        tertool.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()/20));
        tertool.setLayout(new BorderLayout());
        tertool.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.ORANGE));
        JLabel settingp=new JLabel();
        settingp.setIcon(settingon);
        JLabel runp=new JLabel();
        runp.setIcon(runcodeon);
        JLabel splitp=new JLabel();
        splitp.setIcon(spliton);
        JLabel morep=new JLabel();
        morep.setIcon(moreon);
        JLabel loginp=new JLabel();
        loginp.setIcon(loginon);
        // ImageIcon fileter = new ImageIcon("./image/fileter.png");
        // Image filetero=fileter.getImage().getScaledInstance(12,12,Image.SCALE_SMOOTH);
        // ImageIcon fileteron=new ImageIcon(filetero);
        ImageIcon closeter = new ImageIcon("./image/closeter_1.png");
        Image closetero=closeter.getImage().getScaledInstance(10,9,Image.SCALE_SMOOTH);
        ImageIcon closeteron=new ImageIcon(closetero);
        JMenuBar filetermenubar=new JMenuBar();
        JMenu filetermenu=new JMenu();
        filetermenu.setIcon(morefon);
        class CustomUI_1 extends BasicMenuUI{
            final protected void installDefaults(){
                super.installDefaults();
                selectionForeground=Color.WHITE;
                selectionBackground=Color.DARK_GRAY;
                filetermenu.setBorder(null);
            }
        }
        JPanel tertoolp=new JPanel();
        tertoolp.setLayout(new GridLayout(1,6,5,0));
        tertoolp.setPreferredSize(new Dimension((this.getWidth()-this.getWidth()/6)/5,this.getHeight()/20));
        tertoolp.setBackground(new Color(35, 36, 35));
        filetermenu.setCursor(c);
        filetermenu.setToolTipText("File_Meta_Data");
        settingp.setCursor(c);
        settingp.setToolTipText("Advance Settings");
        runp.setCursor(c);
        runp.setToolTipText("Run Code");
        splitp.setCursor(c);
        splitp.setToolTipText("Split Window");
        morep.setCursor(c);
        morep.setToolTipText("More Features");
        loginp.setCursor(c);
        loginp.setToolTipText("User Login");
        JMenuItem file1i= new JMenuItem("File.Orb");
        JMenuItem file2i= new JMenuItem("File.Orb");
        JMenuItem file3i= new JMenuItem("File.Orb");
        JMenuItem file4i= new JMenuItem("File.Orb");
        JMenuItem file5i= new JMenuItem("File.Orb");
        filetermenu.add(file1i);
        filetermenu.add(file2i);
        filetermenu.add(file3i);
        filetermenu.add(file4i);
        filetermenu.add(file5i);
        // System.out.println(file2i.getMouseListeners());
        
        JDialog file1d=new JDialog(this);
        // JDialog signup=new JDialog(this);
        file1i.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ImageIcon fdpicon = new ImageIcon("./image/fdpicon.png");
                Image fdpicono=fdpicon.getImage().getScaledInstance(22,22,Image.SCALE_SMOOTH);
                ImageIcon fdpiconon=new ImageIcon(fdpicono);
                File fdpfile=null;
                String user="",group="";
                String perm_user="",perm_group="";
        String objective="Contains modules which have capabilities to improve image analysis for earth data";
        String project="Landsat_Orb";
        String tags="#Orb #Earth #GIS #ImageAnalysis";
        String requirements="Platform for run and compilation / Debug";
        String status="secure";
        String m_date="",c_date="";
                try{
                    BufferedReader fdpr=new BufferedReader(new FileReader(filepathmeta));
                    String path=fdpr.readLine();
                     fdpfile=new File(path);
                    fdpr.close();
                    Date lastmodified=new Date(fdpfile.lastModified());
                    SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    m_date=dateformat.format(lastmodified);
                    // System.out.println(date);
                    Path perm_path=Path.of(fdpfile.getAbsolutePath());
                    if(System.getProperty("os.name").contains("Windows")){
                        AclFileAttributeView aclview=Files.getFileAttributeView(perm_path,AclFileAttributeView.class);
                     Iterable<AclEntry> permission=aclview.getAcl();
                     UserPrincipal owner=aclview.getOwner();
                     for(AclEntry p : permission){
                            if(p.principal().toString().contains("group")||p.principal().toString().contains("Group")||p.principal().toString().contains("GROUP")){
                               group=p.principal().getName();
                               perm_group=p.permissions().toString();
                            }
                            if(owner.toString().split(" ")[0].equals(p.principal().getName())){
                                user=p.principal().getName();
                                perm_user=p.permissions().toString();
                            }
                        }
                    }
                    else{
                        PosixFileAttributes attributeview=Files.readAttributes(perm_path,PosixFileAttributes.class);
                        String owner=attributeview.owner().getName();
                        user=owner;
                        String group_temp=attributeview.group().getName();
                         group=group_temp;
                            Set<PosixFilePermission> permission;
                            permission=Files.getPosixFilePermissions(perm_path);
                            perm_user=permission.contains(PosixFilePermission.OWNER_READ)+" "
                            +permission.contains(PosixFilePermission.OWNER_WRITE)+" "
                            +permission.contains(PosixFilePermission.OWNER_EXECUTE);
                        perm_group=permission.contains(PosixFilePermission.GROUP_READ)+" "
                        +permission.contains(PosixFilePermission.GROUP_WRITE)+" "
                        +permission.contains(PosixFilePermission.GROUP_EXECUTE);
                    }
         BasicFileAttributes attribute=Files.readAttributes(perm_path,BasicFileAttributes.class);
        FileTime createtime=attribute.creationTime();
        Date createddate=new Date(createtime.toMillis());
        SimpleDateFormat dateformat_1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c_date=dateformat.format(createddate);
        // System.out.println(createtime);
                }
                catch(IOException exc){

                }
                String read="",write="",execute="";
                if(fdpfile.canRead()){
                    read="Read";
                }
                else{
                    read="-";
                }
                if(fdpfile.canWrite()){
                    write="Write";
                }
                else{
                    write="-";
                }
                if(fdpfile.canExecute()){
                    execute="Execute";
                }
                else{
                    execute="-";
                }
                file1d.setTitle(fdpfile.getName());
                file1d.setIconImage(fdpiconon.getImage());
                file1d.setModal(true);
                Font fdpfont=new Font("Serif",Font.BOLD,13);
                Toolkit tfd=Toolkit.getDefaultToolkit();
                Dimension sizefd=tfd.getScreenSize();
                String fdptype=fdpfile.getName();
                     String type="";
                     int dot=fdptype.lastIndexOf(".");
                     if(dot>0&dot<fdptype.length()-1){
                         type=fdptype.substring(dot+1);
                     }
                JLabel fdp1name=new JLabel("Name:  "+fdpfile.getName());
                JLabel fdp1path=new JLabel("Path:  "+fdpfile.getAbsolutePath());
                JLabel fdp1type=new JLabel("Type:  "+type+" File");
                JLabel fdp1permission=new JLabel("Permission: "+read+" "+write+" "+execute);
                JLabel fdp1size=new JLabel("Size:  "+fdpfile.length()+" Bytes");
                JLabel fdp1source=new JLabel("Source: $"+user);
                JLabel fdp1status=new JLabel("Status: "+status);
                JLabel fdp1project=new JLabel("Project / Library: "+project);
                JLabel fdp1tags=new JLabel("Tags: "+tags);
                JLabel fdp1access=new JLabel("Access Control / User Authentication: "+"User : $"
                +user+": Access : $"+perm_user+": Group : @"+group+": Acess : @"+perm_group);
                JLabel fdp1speed=new JLabel("Execution Time / Execution Speed: "+"Not found yet");
                JLabel fdp1createtime=new JLabel("Created Time: "+c_date);
                JLabel fdp1modifytime=new JLabel("Last Modified Time: "+m_date);
                JLabel fdp1requirements=new JLabel("Requirements: "+requirements);
                JLabel fdp1objective=new JLabel("Objective: "+objective);
                JPanel fdp1=new JPanel();
                fdp1.setLayout(new GridLayout(15,1,0,2));
                fdp1.add(fdp1name);
                fdp1.add(fdp1path);
                fdp1.add(fdp1type);
                fdp1.add(fdp1permission);
                fdp1.add(fdp1size);
                fdp1.add(fdp1access);
                fdp1.add(fdp1createtime);
                fdp1.add(fdp1modifytime);
                fdp1.add(fdp1objective);
                fdp1.add(fdp1requirements);
                fdp1.add(fdp1source);
                fdp1.add(fdp1status);
                fdp1.add(fdp1tags);
                fdp1.add(fdp1speed);
                fdp1.add(fdp1project);
                for(int fdpi=0;fdpi<fdp1.getComponentCount();fdpi++){
                    fdp1.getComponent(fdpi).setForeground(Color.WHITE);
                    fdp1.getComponent(fdpi).setFont(fdpfont);
                }
                JScrollPane fdp1sc=new JScrollPane(fdp1);

                fdp1.setBackground(Color.BLACK);
                fdp1sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                fdp1sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                JPanel cotecorner=new JPanel();
                cotecorner.setBackground(new Color(3, 252, 7));
                fdp1sc.setCorner(fdp1sc.LOWER_RIGHT_CORNER, cotecorner);
                JScrollBar fdpscvbar=fdp1sc.getVerticalScrollBar();
                fdpscvbar.setCursor(c);
                fdpscvbar.setPreferredSize(new Dimension(7,7));
                JScrollBar fdpschbar=fdp1sc.getHorizontalScrollBar();
                fdpschbar.setCursor(c);
                fdpschbar.setPreferredSize(new Dimension(7,7));
                fdpscvbar.setUI(new fdpscBar());
                fdpschbar.setUI(new fdpscBar());
                file1d.add(fdp1sc);
                file1d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                file1d.setSize((sizefd.width/4),(sizefd.height/4));
                file1d.setLocationRelativeTo(null);
                   file1d.setVisible(true);
            }
        });
        JDialog file2d=new JDialog(this);
        file2i.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ImageIcon fdpicon = new ImageIcon("./image/fdpicon.png");
                Image fdpicono=fdpicon.getImage().getScaledInstance(22,22,Image.SCALE_SMOOTH);
                ImageIcon fdpiconon=new ImageIcon(fdpicono);
                File fdpfile=null;
                String user="",group="";
                String perm_user="",perm_group="";
        String objective="Contains modules which have capabilities to improve image analysis for earth data";
        String project="Landsat_Orb";
        String tags="#Orb #Earth #GIS #ImageAnalysis";
        String requirements="Platform for run and compilation / Debug";
        String status="secure";
        String m_date="",c_date="";
                try{
                    BufferedReader fdpr=new BufferedReader(new FileReader(filepathmeta));
                    for(int i=1;i<2;i++){
                        fdpr.readLine();
                    }
                    String path=fdpr.readLine();
                     fdpfile=new File(path);
                    fdpr.close();
                    Date lastmodified=new Date(fdpfile.lastModified());
                    SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    m_date=dateformat.format(lastmodified);
                    // System.out.println(date);
                    Path perm_path=Path.of(fdpfile.getAbsolutePath());
                    if(System.getProperty("os.name").contains("Windows")){
                        AclFileAttributeView aclview=Files.getFileAttributeView(perm_path,AclFileAttributeView.class);
                     Iterable<AclEntry> permission=aclview.getAcl();
                     UserPrincipal owner=aclview.getOwner();
                     for(AclEntry p : permission){
                            if(p.principal().toString().contains("group")||p.principal().toString().contains("Group")||p.principal().toString().contains("GROUP")){
                               group=p.principal().getName();
                               perm_group=p.permissions().toString();
                            }
                            if(owner.toString().split(" ")[0].equals(p.principal().getName())){
                                user=p.principal().getName();
                                perm_user=p.permissions().toString();
                            }
                        }
                    }
                    else{
                        PosixFileAttributes attributeview=Files.readAttributes(perm_path,PosixFileAttributes.class);
                        String owner=attributeview.owner().getName();
                        user=owner;
                        String group_temp=attributeview.group().getName();
                         group=group_temp;
                            Set<PosixFilePermission> permission;
                            permission=Files.getPosixFilePermissions(perm_path);
                            perm_user=permission.contains(PosixFilePermission.OWNER_READ)+" "
                            +permission.contains(PosixFilePermission.OWNER_WRITE)+" "
                            +permission.contains(PosixFilePermission.OWNER_EXECUTE);
                        perm_group=permission.contains(PosixFilePermission.GROUP_READ)+" "
                        +permission.contains(PosixFilePermission.GROUP_WRITE)+" "
                        +permission.contains(PosixFilePermission.GROUP_EXECUTE);
                    }
         BasicFileAttributes attribute=Files.readAttributes(perm_path,BasicFileAttributes.class);
        FileTime createtime=attribute.creationTime();
        Date createddate=new Date(createtime.toMillis());
        SimpleDateFormat dateformat_1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c_date=dateformat.format(createddate);
        // System.out.println(createtime);
                }
                catch(IOException exc){

                }
                String read="",write="",execute="";
                if(fdpfile.canRead()){
                    read="Read";
                }
                else{
                    read="-";
                }
                if(fdpfile.canWrite()){
                    write="Write";
                }
                else{
                    write="-";
                }
                if(fdpfile.canExecute()){
                    execute="Execute";
                }
                else{
                    execute="-";
                }
                file2d.setTitle(fdpfile.getName());
                file2d.setIconImage(fdpiconon.getImage());
                file2d.setModal(true);
                Font fdpfont=new Font("Serif",Font.BOLD,13);
                Toolkit tfd=Toolkit.getDefaultToolkit();
                Dimension sizefd=tfd.getScreenSize();
                String fdptype=fdpfile.getName();
                     String type="";
                     int dot=fdptype.lastIndexOf(".");
                     if(dot>0&dot<fdptype.length()-1){
                         type=fdptype.substring(dot+1);
                     }
                JLabel fdp1name=new JLabel("Name:  "+fdpfile.getName());
                JLabel fdp1path=new JLabel("Path:  "+fdpfile.getAbsolutePath());
                JLabel fdp1type=new JLabel("Type:  "+type+" File");
                JLabel fdp1permission=new JLabel("Permission: "+read+" "+write+" "+execute);
                JLabel fdp1size=new JLabel("Size:  "+fdpfile.length()+" Bytes");
                JLabel fdp1source=new JLabel("Source: $"+user);
                JLabel fdp1status=new JLabel("Status: "+status);
                JLabel fdp1project=new JLabel("Project / Library: "+project);
                JLabel fdp1tags=new JLabel("Tags: "+tags);
                JLabel fdp1access=new JLabel("Access Control / User Authentication: "+"User : $"
                +user+": Access : $"+perm_user+": Group : @"+group+": Acess : @"+perm_group);
                JLabel fdp1speed=new JLabel("Execution Time / Execution Speed: "+"Not found yet");
                JLabel fdp1createtime=new JLabel("Created Time: "+c_date);
                JLabel fdp1modifytime=new JLabel("Last Modified Time: "+m_date);
                JLabel fdp1requirements=new JLabel("Requirements: "+requirements);
                JLabel fdp1objective=new JLabel("Objective: "+objective);
                JPanel fdp1=new JPanel();
                fdp1.setLayout(new GridLayout(15,1,0,2));
                fdp1.add(fdp1name);
                fdp1.add(fdp1path);
                fdp1.add(fdp1type);
                fdp1.add(fdp1permission);
                fdp1.add(fdp1size);
                fdp1.add(fdp1access);
                fdp1.add(fdp1createtime);
                fdp1.add(fdp1modifytime);
                fdp1.add(fdp1objective);
                fdp1.add(fdp1requirements);
                fdp1.add(fdp1source);
                fdp1.add(fdp1status);
                fdp1.add(fdp1tags);
                fdp1.add(fdp1speed);
                fdp1.add(fdp1project);
                for(int fdpi=0;fdpi<fdp1.getComponentCount();fdpi++){
                    fdp1.getComponent(fdpi).setForeground(Color.WHITE);
                    fdp1.getComponent(fdpi).setFont(fdpfont);
                }
                JScrollPane fdp1sc=new JScrollPane(fdp1);

                fdp1.setBackground(Color.BLACK);
                fdp1sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                fdp1sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                JPanel cotecorner=new JPanel();
                cotecorner.setBackground(new Color(3, 252, 7));
                fdp1sc.setCorner(fdp1sc.LOWER_RIGHT_CORNER, cotecorner);
                JScrollBar fdpscvbar=fdp1sc.getVerticalScrollBar();
                fdpscvbar.setCursor(c);
                fdpscvbar.setPreferredSize(new Dimension(7,7));
                JScrollBar fdpschbar=fdp1sc.getHorizontalScrollBar();
                fdpschbar.setCursor(c);
                fdpschbar.setPreferredSize(new Dimension(7,7));
                fdpscvbar.setUI(new fdpscBar());
                fdpschbar.setUI(new fdpscBar());
                file2d.add(fdp1sc);
                file2d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                file2d.setSize((sizefd.width/4),(sizefd.height/4));
                file2d.setLocationRelativeTo(null);
                   file2d.setVisible(true);
            }
        });
        JDialog file3d=new JDialog(this);
        file3i.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 ImageIcon fdpicon = new ImageIcon("./image/fdpicon.png");
                Image fdpicono=fdpicon.getImage().getScaledInstance(22,22,Image.SCALE_SMOOTH);
                ImageIcon fdpiconon=new ImageIcon(fdpicono);
                File fdpfile=null;
                String user="",group="";
                String perm_user="",perm_group="";
        String objective="Contains modules which have capabilities to improve image analysis for earth data";
        String project="Landsat_Orb";
        String tags="#Orb #Earth #GIS #ImageAnalysis";
        String requirements="Platform for run and compilation / Debug";
        String status="secure";
        String m_date="",c_date="";
                try{
                    BufferedReader fdpr=new BufferedReader(new FileReader(filepathmeta));
                    for(int i=1;i<3;i++){
                        fdpr.readLine();
                    }
                    String path=fdpr.readLine();
                     fdpfile=new File(path);
                    fdpr.close();
                    Date lastmodified=new Date(fdpfile.lastModified());
                    SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    m_date=dateformat.format(lastmodified);
                    // System.out.println(date);
                    Path perm_path=Path.of(fdpfile.getAbsolutePath());
                    if(System.getProperty("os.name").contains("Windows")){
                        AclFileAttributeView aclview=Files.getFileAttributeView(perm_path,AclFileAttributeView.class);
                     Iterable<AclEntry> permission=aclview.getAcl();
                     UserPrincipal owner=aclview.getOwner();
                     for(AclEntry p : permission){
                            if(p.principal().toString().contains("group")||p.principal().toString().contains("Group")||p.principal().toString().contains("GROUP")){
                               group=p.principal().getName();
                               perm_group=p.permissions().toString();
                            }
                            if(owner.toString().split(" ")[0].equals(p.principal().getName())){
                                user=p.principal().getName();
                                perm_user=p.permissions().toString();
                            }
                        }
                    }
                    else{
                        PosixFileAttributes attributeview=Files.readAttributes(perm_path,PosixFileAttributes.class);
                        String owner=attributeview.owner().getName();
                        user=owner;
                        String group_temp=attributeview.group().getName();
                         group=group_temp;
                            Set<PosixFilePermission> permission;
                            permission=Files.getPosixFilePermissions(perm_path);
                            perm_user=permission.contains(PosixFilePermission.OWNER_READ)+" "
                            +permission.contains(PosixFilePermission.OWNER_WRITE)+" "
                            +permission.contains(PosixFilePermission.OWNER_EXECUTE);
                        perm_group=permission.contains(PosixFilePermission.GROUP_READ)+" "
                        +permission.contains(PosixFilePermission.GROUP_WRITE)+" "
                        +permission.contains(PosixFilePermission.GROUP_EXECUTE);
                    }
         BasicFileAttributes attribute=Files.readAttributes(perm_path,BasicFileAttributes.class);
        FileTime createtime=attribute.creationTime();
        Date createddate=new Date(createtime.toMillis());
        SimpleDateFormat dateformat_1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c_date=dateformat.format(createddate);
        // System.out.println(createtime);
                }
                catch(IOException exc){

                }
                String read="",write="",execute="";
                if(fdpfile.canRead()){
                    read="Read";
                }
                else{
                    read="-";
                }
                if(fdpfile.canWrite()){
                    write="Write";
                }
                else{
                    write="-";
                }
                if(fdpfile.canExecute()){
                    execute="Execute";
                }
                else{
                    execute="-";
                }
                file3d.setTitle(fdpfile.getName());
                file3d.setIconImage(fdpiconon.getImage());
                file3d.setModal(true);
                Font fdpfont=new Font("Serif",Font.BOLD,13);
                Toolkit tfd=Toolkit.getDefaultToolkit();
                Dimension sizefd=tfd.getScreenSize();
                String fdptype=fdpfile.getName();
                     String type="";
                     int dot=fdptype.lastIndexOf(".");
                     if(dot>0&dot<fdptype.length()-1){
                         type=fdptype.substring(dot+1);
                     }
                JLabel fdp1name=new JLabel("Name:  "+fdpfile.getName());
                JLabel fdp1path=new JLabel("Path:  "+fdpfile.getAbsolutePath());
                JLabel fdp1type=new JLabel("Type:  "+type+" File");
                JLabel fdp1permission=new JLabel("Permission: "+read+" "+write+" "+execute);
                JLabel fdp1size=new JLabel("Size:  "+fdpfile.length()+" Bytes");
                JLabel fdp1source=new JLabel("Source: $"+user);
                JLabel fdp1status=new JLabel("Status: "+status);
                JLabel fdp1project=new JLabel("Project / Library: "+project);
                JLabel fdp1tags=new JLabel("Tags: "+tags);
                JLabel fdp1access=new JLabel("Access Control / User Authentication: "+"User : $"
                +user+": Access : $"+perm_user+": Group : @"+group+": Acess : @"+perm_group);
                JLabel fdp1speed=new JLabel("Execution Time / Execution Speed: "+"Not found yet");
                JLabel fdp1createtime=new JLabel("Created Time: "+c_date);
                JLabel fdp1modifytime=new JLabel("Last Modified Time: "+m_date);
                JLabel fdp1requirements=new JLabel("Requirements: "+requirements);
                JLabel fdp1objective=new JLabel("Objective: "+objective);
                JPanel fdp1=new JPanel();
                fdp1.setLayout(new GridLayout(15,1,0,2));
                fdp1.add(fdp1name);
                fdp1.add(fdp1path);
                fdp1.add(fdp1type);
                fdp1.add(fdp1permission);
                fdp1.add(fdp1size);
                fdp1.add(fdp1access);
                fdp1.add(fdp1createtime);
                fdp1.add(fdp1modifytime);
                fdp1.add(fdp1objective);
                fdp1.add(fdp1requirements);
                fdp1.add(fdp1source);
                fdp1.add(fdp1status);
                fdp1.add(fdp1tags);
                fdp1.add(fdp1speed);
                fdp1.add(fdp1project);
                for(int fdpi=0;fdpi<fdp1.getComponentCount();fdpi++){
                    fdp1.getComponent(fdpi).setForeground(Color.WHITE);
                    fdp1.getComponent(fdpi).setFont(fdpfont);
                }
                JScrollPane fdp1sc=new JScrollPane(fdp1);

                fdp1.setBackground(Color.BLACK);
                fdp1sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                fdp1sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                JPanel cotecorner=new JPanel();
                cotecorner.setBackground(new Color(3, 252, 7));
                fdp1sc.setCorner(fdp1sc.LOWER_RIGHT_CORNER, cotecorner);
                JScrollBar fdpscvbar=fdp1sc.getVerticalScrollBar();
                fdpscvbar.setCursor(c);
                fdpscvbar.setPreferredSize(new Dimension(7,7));
                JScrollBar fdpschbar=fdp1sc.getHorizontalScrollBar();
                fdpschbar.setCursor(c);
                fdpschbar.setPreferredSize(new Dimension(7,7));
                fdpscvbar.setUI(new fdpscBar());
                fdpschbar.setUI(new fdpscBar());
                file3d.add(fdp1sc);
                file3d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                file3d.setSize((sizefd.width/4),(sizefd.height/4));
                file3d.setLocationRelativeTo(null);
                   file3d.setVisible(true);
            }
        });
        JDialog file4d=new JDialog(this);
        file4i.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ImageIcon fdpicon = new ImageIcon("./image/fdpicon.png");
                Image fdpicono=fdpicon.getImage().getScaledInstance(22,22,Image.SCALE_SMOOTH);
                ImageIcon fdpiconon=new ImageIcon(fdpicono);
                File fdpfile=null;
                String user="",group="";
                String perm_user="",perm_group="";
        String objective="Contains modules which have capabilities to improve image analysis for earth data";
        String project="Landsat_Orb";
        String tags="#Orb #Earth #GIS #ImageAnalysis";
        String requirements="Platform for run and compilation / Debug";
        String status="secure";
        String m_date="",c_date="";
                try{
                    BufferedReader fdpr=new BufferedReader(new FileReader(filepathmeta));
                    for(int i=1;i<4;i++){
                        fdpr.readLine();
                    }
                    String path=fdpr.readLine();
                     fdpfile=new File(path);
                    fdpr.close();
                    Date lastmodified=new Date(fdpfile.lastModified());
                    SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    m_date=dateformat.format(lastmodified);
                    // System.out.println(date);
                    Path perm_path=Path.of(fdpfile.getAbsolutePath());
                    if(System.getProperty("os.name").contains("Windows")){
                        AclFileAttributeView aclview=Files.getFileAttributeView(perm_path,AclFileAttributeView.class);
                     Iterable<AclEntry> permission=aclview.getAcl();
                     UserPrincipal owner=aclview.getOwner();
                     for(AclEntry p : permission){
                            if(p.principal().toString().contains("group")||p.principal().toString().contains("Group")||p.principal().toString().contains("GROUP")){
                               group=p.principal().getName();
                               perm_group=p.permissions().toString();
                            }
                            if(owner.toString().split(" ")[0].equals(p.principal().getName())){
                                user=p.principal().getName();
                                perm_user=p.permissions().toString();
                            }
                        }
                    }
                    else{
                        PosixFileAttributes attributeview=Files.readAttributes(perm_path,PosixFileAttributes.class);
                        String owner=attributeview.owner().getName();
                        user=owner;
                        String group_temp=attributeview.group().getName();
                         group=group_temp;
                            Set<PosixFilePermission> permission;
                            permission=Files.getPosixFilePermissions(perm_path);
                            perm_user=permission.contains(PosixFilePermission.OWNER_READ)+" "
                            +permission.contains(PosixFilePermission.OWNER_WRITE)+" "
                            +permission.contains(PosixFilePermission.OWNER_EXECUTE);
                        perm_group=permission.contains(PosixFilePermission.GROUP_READ)+" "
                        +permission.contains(PosixFilePermission.GROUP_WRITE)+" "
                        +permission.contains(PosixFilePermission.GROUP_EXECUTE);
                    }
         BasicFileAttributes attribute=Files.readAttributes(perm_path,BasicFileAttributes.class);
        FileTime createtime=attribute.creationTime();
        Date createddate=new Date(createtime.toMillis());
        SimpleDateFormat dateformat_1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c_date=dateformat.format(createddate);
        // System.out.println(createtime);
                }
                catch(IOException exc){

                }
                String read="",write="",execute="";
                if(fdpfile.canRead()){
                    read="Read";
                }
                else{
                    read="-";
                }
                if(fdpfile.canWrite()){
                    write="Write";
                }
                else{
                    write="-";
                }
                if(fdpfile.canExecute()){
                    execute="Execute";
                }
                else{
                    execute="-";
                }
                file4d.setTitle(fdpfile.getName());
                file4d.setIconImage(fdpiconon.getImage());
                file4d.setModal(true);
                Font fdpfont=new Font("Serif",Font.BOLD,13);
                Toolkit tfd=Toolkit.getDefaultToolkit();
                Dimension sizefd=tfd.getScreenSize();
                String fdptype=fdpfile.getName();
                     String type="";
                     int dot=fdptype.lastIndexOf(".");
                     if(dot>0&dot<fdptype.length()-1){
                         type=fdptype.substring(dot+1);
                     }
                JLabel fdp1name=new JLabel("Name:  "+fdpfile.getName());
                JLabel fdp1path=new JLabel("Path:  "+fdpfile.getAbsolutePath());
                JLabel fdp1type=new JLabel("Type:  "+type+" File");
                JLabel fdp1permission=new JLabel("Permission: "+read+" "+write+" "+execute);
                JLabel fdp1size=new JLabel("Size:  "+fdpfile.length()+" Bytes");
                JLabel fdp1source=new JLabel("Source: $"+user);
                JLabel fdp1status=new JLabel("Status: "+status);
                JLabel fdp1project=new JLabel("Project / Library: "+project);
                JLabel fdp1tags=new JLabel("Tags: "+tags);
                JLabel fdp1access=new JLabel("Access Control / User Authentication: "+"User : $"
                +user+": Access : $"+perm_user+": Group : @"+group+": Acess : @"+perm_group);
                JLabel fdp1speed=new JLabel("Execution Time / Execution Speed: "+"Not found yet");
                JLabel fdp1createtime=new JLabel("Created Time: "+c_date);
                JLabel fdp1modifytime=new JLabel("Last Modified Time: "+m_date);
                JLabel fdp1requirements=new JLabel("Requirements: "+requirements);
                JLabel fdp1objective=new JLabel("Objective: "+objective);
                JPanel fdp1=new JPanel();
                fdp1.setLayout(new GridLayout(15,1,0,2));
                fdp1.add(fdp1name);
                fdp1.add(fdp1path);
                fdp1.add(fdp1type);
                fdp1.add(fdp1permission);
                fdp1.add(fdp1size);
                fdp1.add(fdp1access);
                fdp1.add(fdp1createtime);
                fdp1.add(fdp1modifytime);
                fdp1.add(fdp1objective);
                fdp1.add(fdp1requirements);
                fdp1.add(fdp1source);
                fdp1.add(fdp1status);
                fdp1.add(fdp1tags);
                fdp1.add(fdp1speed);
                fdp1.add(fdp1project);
                for(int fdpi=0;fdpi<fdp1.getComponentCount();fdpi++){
                    fdp1.getComponent(fdpi).setForeground(Color.WHITE);
                    fdp1.getComponent(fdpi).setFont(fdpfont);
                }
                JScrollPane fdp1sc=new JScrollPane(fdp1);

                fdp1.setBackground(Color.BLACK);
                fdp1sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                fdp1sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                JPanel cotecorner=new JPanel();
                cotecorner.setBackground(new Color(3, 252, 7));
                fdp1sc.setCorner(fdp1sc.LOWER_RIGHT_CORNER, cotecorner);
                JScrollBar fdpscvbar=fdp1sc.getVerticalScrollBar();
                fdpscvbar.setCursor(c);
                fdpscvbar.setPreferredSize(new Dimension(7,7));
                JScrollBar fdpschbar=fdp1sc.getHorizontalScrollBar();
                fdpschbar.setCursor(c);
                fdpschbar.setPreferredSize(new Dimension(7,7));
                fdpscvbar.setUI(new fdpscBar());
                fdpschbar.setUI(new fdpscBar());
                file4d.add(fdp1sc);
                file4d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                file4d.setSize((sizefd.width/4),(sizefd.height/4));
                file4d.setLocationRelativeTo(null);
                   file4d.setVisible(true);
            }
        });
        JDialog file5d=new JDialog(this);
        file5i.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ImageIcon fdpicon = new ImageIcon("./image/fdpicon.png");
                Image fdpicono=fdpicon.getImage().getScaledInstance(22,22,Image.SCALE_SMOOTH);
                ImageIcon fdpiconon=new ImageIcon(fdpicono);
                File fdpfile=null;
                String user="",group="";
                String perm_user="",perm_group="";
        String objective="Contains modules which have capabilities to improve image analysis for earth data";
        String project="Landsat_Orb";
        String tags="#Orb #Earth #GIS #ImageAnalysis";
        String requirements="Platform for run and compilation / Debug";
        String status="secure";
        String m_date="",c_date="";
                try{
                    BufferedReader fdpr=new BufferedReader(new FileReader(filepathmeta));
                    for(int i=1;i<5;i++){
                        fdpr.readLine();
                    }
                    String path=fdpr.readLine();
                     fdpfile=new File(path);
                    fdpr.close();
                    Date lastmodified=new Date(fdpfile.lastModified());
                    SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    m_date=dateformat.format(lastmodified);
                    // System.out.println(date);
                    Path perm_path=Path.of(fdpfile.getAbsolutePath());
                    if(System.getProperty("os.name").contains("Windows")){
                        AclFileAttributeView aclview=Files.getFileAttributeView(perm_path,AclFileAttributeView.class);
                     Iterable<AclEntry> permission=aclview.getAcl();
                     UserPrincipal owner=aclview.getOwner();
                     for(AclEntry p : permission){
                            if(p.principal().toString().contains("group")||p.principal().toString().contains("Group")||p.principal().toString().contains("GROUP")){
                               group=p.principal().getName();
                               perm_group=p.permissions().toString();
                            }
                            if(owner.toString().split(" ")[0].equals(p.principal().getName())){
                                user=p.principal().getName();
                                perm_user=p.permissions().toString();
                            }
                        }
                    }
                    else{
                        PosixFileAttributes attributeview=Files.readAttributes(perm_path,PosixFileAttributes.class);
                        String owner=attributeview.owner().getName();
                        user=owner;
                        String group_temp=attributeview.group().getName();
                         group=group_temp;
                            Set<PosixFilePermission> permission;
                            permission=Files.getPosixFilePermissions(perm_path);
                            perm_user=permission.contains(PosixFilePermission.OWNER_READ)+" "
                            +permission.contains(PosixFilePermission.OWNER_WRITE)+" "
                            +permission.contains(PosixFilePermission.OWNER_EXECUTE);
                        perm_group=permission.contains(PosixFilePermission.GROUP_READ)+" "
                        +permission.contains(PosixFilePermission.GROUP_WRITE)+" "
                        +permission.contains(PosixFilePermission.GROUP_EXECUTE);
                    }
         BasicFileAttributes attribute=Files.readAttributes(perm_path,BasicFileAttributes.class);
        FileTime createtime=attribute.creationTime();
        Date createddate=new Date(createtime.toMillis());
        SimpleDateFormat dateformat_1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        c_date=dateformat.format(createddate);
        // System.out.println(createtime);
                }
                catch(IOException exc){

                }
                String read="",write="",execute="";
                if(fdpfile.canRead()){
                    read="Read";
                }
                else{
                    read="-";
                }
                if(fdpfile.canWrite()){
                    write="Write";
                }
                else{
                    write="-";
                }
                if(fdpfile.canExecute()){
                    execute="Execute";
                }
                else{
                    execute="-";
                }
                file5d.setTitle(fdpfile.getName());
                file5d.setIconImage(fdpiconon.getImage());
                file5d.setModal(true);
                Font fdpfont=new Font("Serif",Font.BOLD,13);
                Toolkit tfd=Toolkit.getDefaultToolkit();
                Dimension sizefd=tfd.getScreenSize();
                String fdptype=fdpfile.getName();
                     String type="";
                     int dot=fdptype.lastIndexOf(".");
                     if(dot>0&dot<fdptype.length()-1){
                         type=fdptype.substring(dot+1);
                     }
                JLabel fdp1name=new JLabel("Name:  "+fdpfile.getName());
                JLabel fdp1path=new JLabel("Path:  "+fdpfile.getAbsolutePath());
                JLabel fdp1type=new JLabel("Type:  "+type+" File");
                JLabel fdp1permission=new JLabel("Permission: "+read+" "+write+" "+execute);
                JLabel fdp1size=new JLabel("Size:  "+fdpfile.length()+" Bytes");
                JLabel fdp1source=new JLabel("Source: $"+user);
                JLabel fdp1status=new JLabel("Status: "+status);
                JLabel fdp1project=new JLabel("Project / Library: "+project);
                JLabel fdp1tags=new JLabel("Tags: "+tags);
                JLabel fdp1access=new JLabel("Access Control / User Authentication: "+"User : $"
                +user+": Access : $"+perm_user+": Group : @"+group+": Acess : @"+perm_group);
                JLabel fdp1speed=new JLabel("Execution Time / Execution Speed: "+"Not found yet");
                JLabel fdp1createtime=new JLabel("Created Time: "+c_date);
                JLabel fdp1modifytime=new JLabel("Last Modified Time: "+m_date);
                JLabel fdp1requirements=new JLabel("Requirements: "+requirements);
                JLabel fdp1objective=new JLabel("Objective: "+objective);
                JPanel fdp1=new JPanel();
                fdp1.setLayout(new GridLayout(15,1,0,2));
                fdp1.add(fdp1name);
                fdp1.add(fdp1path);
                fdp1.add(fdp1type);
                fdp1.add(fdp1permission);
                fdp1.add(fdp1size);
                fdp1.add(fdp1access);
                fdp1.add(fdp1createtime);
                fdp1.add(fdp1modifytime);
                fdp1.add(fdp1objective);
                fdp1.add(fdp1requirements);
                fdp1.add(fdp1source);
                fdp1.add(fdp1status);
                fdp1.add(fdp1tags);
                fdp1.add(fdp1speed);
                fdp1.add(fdp1project);
                for(int fdpi=0;fdpi<fdp1.getComponentCount();fdpi++){
                    fdp1.getComponent(fdpi).setForeground(Color.WHITE);
                    fdp1.getComponent(fdpi).setFont(fdpfont);
                }
                JScrollPane fdp1sc=new JScrollPane(fdp1);

                fdp1.setBackground(Color.BLACK);
                fdp1sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                fdp1sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                JPanel cotecorner=new JPanel();
                cotecorner.setBackground(new Color(3, 252, 7));
                fdp1sc.setCorner(fdp1sc.LOWER_RIGHT_CORNER, cotecorner);
                JScrollBar fdpscvbar=fdp1sc.getVerticalScrollBar();
                fdpscvbar.setCursor(c);
                fdpscvbar.setPreferredSize(new Dimension(7,7));
                JScrollBar fdpschbar=fdp1sc.getHorizontalScrollBar();
                fdpschbar.setCursor(c);
                fdpschbar.setPreferredSize(new Dimension(7,7));
                fdpscvbar.setUI(new fdpscBar());
                fdpschbar.setUI(new fdpscBar());
                file5d.add(fdp1sc);
                file5d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                file5d.setSize((sizefd.width/4),(sizefd.height/4));
                file5d.setLocationRelativeTo(null);
                   file5d.setVisible(true);
            }
        });
        filetermenu.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                File f[]=new File[5];
                try{
                    BufferedReader fdpr=new BufferedReader(new FileReader(filepathmeta));
                        for(int i=0;i<5;i++){
                            String path=fdpr.readLine();
                            f[i]=new File(path);
                        }
                }
                catch(IOException exc){

                }
                file1i.setVisible(true);
                file2i.setVisible(true);
                file3i.setVisible(true);
                file4i.setVisible(true);
                file5i.setVisible(true);
                if(!(file1.isVisible())||!(file1.getText().equals(f[0].getName()))){
                    file1i.setVisible(false);
                }
                if(!(file2.isVisible())||!(file2.getText().equals(f[1].getName()))){
                    file2i.setVisible(false);
                }
                if(!(file3.isVisible())||!(file3.getText().equals(f[2].getName()))){
                    file3i.setVisible(false);
                }
                if(!(file4.isVisible())||!(file4.getText().equals(f[3].getName()))){
                    file4i.setVisible(false);
                }
                if(!(file5.isVisible())||!(file5.getText().equals(f[4].getName()))){
                    file5i.setVisible(false);
                }
               file1i.setText(file1.getText());
               file1i.setIcon(fileion_1);
               file2i.setText(file2.getText());
               file2i.setIcon(fileion_2);
               file3i.setText(file3.getText());
               file3i.setIcon(fileion_3);
               file4i.setText(file4.getText());
               file4i.setIcon(fileion_4);
               file5i.setText(file5.getText());
               file5i.setIcon(fileion_5);
            }
        });
        class CustomUIItem_1 extends BasicMenuItemUI{
                final protected void installDefaults(){
                    super.installDefaults();
                    selectionForeground=new Color(3, 252, 7);
                    selectionBackground=Color.DARK_GRAY;
                    for(int m=0;m<filetermenu.getItemCount();m++){
                        filetermenu.getItem(m).setBorder(null);
                    }
                }
            }
        for(int m=0;m<filetermenu.getItemCount();m++){
            filetermenu.getItem(m).setBackground(new Color(35, 36, 35));
            filetermenu.getItem(m).setCursor(c);
            filetermenu.getItem(m).setForeground(Color.MAGENTA);
            filetermenu.getItem(m).setIcon(orb_exton);
            filetermenu.getItem(m).setHorizontalTextPosition(SwingConstants.LEFT);
            filetermenu.getItem(m).setIconTextGap(10);
            filetermenu.getItem(m).setBorder(null);
            filetermenu.getItem(m).setUI(new CustomUIItem_1());
        }
        filetermenu.setBorder(null);
        filetermenu.setUI(new CustomUI_1());
        filetermenubar.setBackground(new Color(35, 36, 35));
        filetermenubar.setBorder(null);
        filetermenubar.add(filetermenu);
        tertoolp.add(settingp);
        tertoolp.add(runp);
        tertoolp.add(splitp);
        tertoolp.add(morep);
        tertoolp.add(loginp);
        tertoolp.add(filetermenubar);
        tertool.add(tertoolp,BorderLayout.EAST);
        JPanel terfile=new JPanel();
        terfile.setBackground(new Color(35, 36, 35));
        int widthtf=(this.getWidth()-this.getWidth()/6)
        -(this.getWidth()-this.getWidth()/6)/5;
        terfile.setPreferredSize(new Dimension(widthtf,this.getHeight()/20));
        file1=new JLabel("File.Orb");
        file2=new JLabel("File.Orb");
        file3=new JLabel("File.Orb");
        file4=new JLabel("File.Orb");
        file5=new JLabel("File.Orb");
        file1butt=new JLabel(closeteron);
        file2butt=new JLabel(closeteron);
        file3butt=new JLabel(closeteron);
        file4butt=new JLabel(closeteron);
        file5butt=new JLabel(closeteron);
        file1butt.setPreferredSize(new Dimension(11,11));
        file2butt.setPreferredSize(new Dimension(11,11));
        file3butt.setPreferredSize(new Dimension(11,11));
        file4butt.setPreferredSize(new Dimension(11,11));
        file5butt.setPreferredSize(new Dimension(11,11));
         file2.setVisible(false);
        file3.setVisible(false);
        file4.setVisible(false);
        file5.setVisible(false);
        file1butt.setCursor(c);
        file2butt.setCursor(c);
        file3butt.setCursor(c);
        file4butt.setCursor(c);
        file5butt.setCursor(c);
        file2butt.setVisible(false);
        file3butt.setVisible(false);
        file4butt.setVisible(false);
        file5butt.setVisible(false);
        file1.setPreferredSize(new Dimension(widthtf/6,this.getHeight()/20));
        file2.setPreferredSize(new Dimension(widthtf/6,this.getHeight()/20));
        file3.setPreferredSize(new Dimension(widthtf/6,this.getHeight()/20));
        file4.setPreferredSize(new Dimension(widthtf/6,this.getHeight()/20));
        file5.setPreferredSize(new Dimension(widthtf/6,this.getHeight()/20));
        file1.setForeground(Color.MAGENTA);
        file2.setForeground(Color.MAGENTA);
        file3.setForeground(Color.MAGENTA);
        file4.setForeground(Color.MAGENTA);
        file5.setForeground(Color.MAGENTA);
        // terfile.setLayout(new GridLayout(1,5,0,0));
        file1.setIcon(fileteron);
        file1.setHorizontalTextPosition(SwingConstants.RIGHT);
        file1.setCursor(c);
        file2.setIcon(fileteron);
        file2.setHorizontalTextPosition(SwingConstants.RIGHT);
        file2.setCursor(c);
        file3.setIcon(fileteron);
        file3.setHorizontalTextPosition(SwingConstants.RIGHT);
        file3.setCursor(c);
        file4.setIcon(fileteron);
        file4.setHorizontalTextPosition(SwingConstants.RIGHT);
        file4.setCursor(c);
        file5.setIcon(fileteron);
        file5.setHorizontalTextPosition(SwingConstants.RIGHT);
        file5.setCursor(c);
        file1.setIconTextGap(10);
        file2.setIconTextGap(10);
        file3.setIconTextGap(10);
        file4.setIconTextGap(10);
        file5.setIconTextGap(10);
        file1.setName("1");
        file2.setName("2");
        file3.setName("3");
        file4.setName("4");
        file5.setName("5");
        file1butt.setName("10");
        file2butt.setName("20");
        file3butt.setName("30");
        file4butt.setName("40");
        file5butt.setName("50");
        file1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
        file1.addMouseListener(new Temp4());
        file2.addMouseListener(new Temp4());
        file3.addMouseListener(new Temp4());
        file4.addMouseListener(new Temp4());
        file5.addMouseListener(new Temp4());
        file1.addMouseListener(new MouseAdapter(){
          public void mouseEntered(MouseEvent f){
            //   System.out.println("hello");
              JLabel c=(JLabel)f.getComponent();
                  c.setIcon(fileteron_1);
                  c.setForeground(new Color(3, 252, 7));
                  c.setHorizontalTextPosition(SwingConstants.LEFT);
                 c.setIconTextGap(10);
          }
          public void mouseClicked(MouseEvent f){
            JLabel c=(JLabel)f.getComponent();
            String s=c.getName();
            file1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
            file2.setBorder(null);
            file3.setBorder(null);
            file4.setBorder(null);
            file5.setBorder(null);
            fc=1;
            fileselect=Integer.parseInt(s);
            file1butt.setVisible(true);
            file2butt.setVisible(false);
            file3butt.setVisible(false);
            file4butt.setVisible(false);
            file5butt.setVisible(false);
            try{
                BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                String s_fc_file[]=new String[s_fc_x_file];
                for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                    s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                }
                meta_1_file.close();
                meta_2_file.close();
                File f_file=new File(s_fc_file[0]);
                BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                String f_temp_file,f_temp_console_file="";
                while((f_temp_file=meta_3_file.readLine())!=null){
                    f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                }
                meta_3_file.close();
              if(f_file.exists()&(file1.getText().equals(f_file.getName()))){
                  index.setText(null);
                  index.setText(" 1  ");
                  codetarea.setText(f_temp_console_file);
                  file1.setText(f_file.getName());
                  for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                          index.append("\n "+f_con_file+" ");
                   }
              }
              if((!f_file.exists())||(!(file1.getText().equals(f_file.getName())))){
                codetarea.setText(null);
                index.setText(null);
                codetarea.setText("//  Welcome To Orb");
                index.setText(" 1  ");
              }
            }
            catch(IOException exc){
  
          }
          }
        });
        file2.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent f){
                  JLabel c=(JLabel)f.getComponent();
                      c.setIcon(fileteron_2);
                      c.setForeground(new Color(3, 252, 7));
                      c.setHorizontalTextPosition(SwingConstants.LEFT);
                     c.setIconTextGap(10);
              }
            public void mouseClicked(MouseEvent f){
              JLabel c=(JLabel)f.getComponent();
              String s=c.getName();
              file1.setBorder(null);
              file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
              file3.setBorder(null);
              file4.setBorder(null);
              file5.setBorder(null);
              fc=2;
              fileselect=Integer.parseInt(s);
              file1butt.setVisible(false);
              file2butt.setVisible(true);
            file3butt.setVisible(false);
            file4butt.setVisible(false);
            file5butt.setVisible(false);
              try{
                BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                String s_fc_file[]=new String[s_fc_x_file];
                for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                    s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                }
                meta_1_file.close();
                meta_2_file.close();
                File f_file=new File(s_fc_file[1]);
                BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                String f_temp_file,f_temp_console_file="";
                while((f_temp_file=meta_3_file.readLine())!=null){
                    f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                }
                meta_3_file.close();
              if(f_file.exists()&(file2.getText().equals(f_file.getName()))){
                  index.setText(null);
                  index.setText(" 1  ");
                  codetarea.setText(f_temp_console_file);
                  file2.setText(f_file.getName());
                  for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                          index.append("\n "+f_con_file+" ");
                   }
              }
              if((!f_file.exists())||(!(file2.getText().equals(f_file.getName())))){
                codetarea.setText(null);
                index.setText(null);
                codetarea.setText("//  Welcome To Orb");
                index.setText(" 1  ");
              }
            }
            catch(IOException exc){
  
          }
            }
          });
          file3.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent f){
                  JLabel c=(JLabel)f.getComponent();
                      c.setIcon(fileteron_3);
                      c.setForeground(new Color(3, 252, 7));
                      c.setHorizontalTextPosition(SwingConstants.LEFT);
                     c.setIconTextGap(10);
              }
            public void mouseClicked(MouseEvent f){
              JLabel c=(JLabel)f.getComponent();
              String s=c.getName();
              file1.setBorder(null);
              file2.setBorder(null);
              file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
              file4.setBorder(null);
              file5.setBorder(null);
              fc=3;
              fileselect=Integer.parseInt(s);
              file1butt.setVisible(false);
              file2butt.setVisible(false);
              file3butt.setVisible(true);
              file4butt.setVisible(false);
              file5butt.setVisible(false);
              try{
                BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                String s_fc_file[]=new String[s_fc_x_file];
                for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                    s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                }
                meta_1_file.close();
                meta_2_file.close();
                File f_file=new File(s_fc_file[2]);
                BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                String f_temp_file,f_temp_console_file="";
                while((f_temp_file=meta_3_file.readLine())!=null){
                    f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                }
                meta_3_file.close();
              if(f_file.exists()&(file3.getText().equals(f_file.getName()))){
                  index.setText(null);
                  index.setText(" 1  ");
                  codetarea.setText(f_temp_console_file);
                  file3.setText(f_file.getName());
                  for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                          index.append("\n "+f_con_file+" ");
                   }
              }
              if((!f_file.exists())||(!(file3.getText().equals(f_file.getName())))){
                codetarea.setText(null);
                index.setText(null);
                codetarea.setText("//  Welcome To Orb");
                index.setText(" 1  ");
              }
            }
            catch(IOException exc){
  
          }
            }
          });
          file4.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent f){
                  JLabel c=(JLabel)f.getComponent();
                      c.setIcon(fileteron_4);
                      c.setForeground(new Color(3, 252, 7));
                      c.setHorizontalTextPosition(SwingConstants.LEFT);
                     c.setIconTextGap(10);
              }
            public void mouseClicked(MouseEvent f){
              JLabel c=(JLabel)f.getComponent();
              String s=c.getName();
              file1.setBorder(null);
              file2.setBorder(null);
              file3.setBorder(null);
              file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
              file5.setBorder(null);
              fc=4;
              fileselect=Integer.parseInt(s);
              file1butt.setVisible(false);
              file2butt.setVisible(false);
              file3butt.setVisible(false);
              file4butt.setVisible(true);
              file5butt.setVisible(false);
              try{
                BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                String s_fc_file[]=new String[s_fc_x_file];
                for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                    s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                }
                meta_1_file.close();
                meta_2_file.close();
                File f_file=new File(s_fc_file[3]);
                BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                String f_temp_file,f_temp_console_file="";
                while((f_temp_file=meta_3_file.readLine())!=null){
                    f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                }
                meta_3_file.close();
              if(f_file.exists()&(file4.getText().equals(f_file.getName()))){
                  index.setText(null);
                  index.setText(" 1  ");
                  codetarea.setText(f_temp_console_file);
                  file4.setText(f_file.getName());
                  for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                          index.append("\n "+f_con_file+" ");
                   }
              }
              if((!f_file.exists())||(!(file4.getText().equals(f_file.getName())))){
                codetarea.setText(null);
                index.setText(null);
                codetarea.setText("//  Welcome To Orb");
                index.setText(" 1  ");
              }
            }
            catch(IOException exc){
  
          }
            }
          });
          file5.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent f){
                  JLabel c=(JLabel)f.getComponent();
                      c.setIcon(fileteron_5);
                      c.setForeground(new Color(3, 252, 7));
                      c.setHorizontalTextPosition(SwingConstants.LEFT);
                     c.setIconTextGap(10);
              }
            public void mouseClicked(MouseEvent f){
              JLabel c=(JLabel)f.getComponent();
              String s=c.getName();
              file1.setBorder(null);
              file2.setBorder(null);
              file3.setBorder(null);
              file4.setBorder(null);
              file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
              fc=5;
              fileselect=Integer.parseInt(s);
              file1butt.setVisible(false);
              file2butt.setVisible(false);
              file3butt.setVisible(false);
              file4butt.setVisible(false);
              file5butt.setVisible(true);
              try{
                BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                String s_fc_file[]=new String[s_fc_x_file];
                for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                    s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                }
                meta_1_file.close();
                meta_2_file.close();
                File f_file=new File(s_fc_file[4]);
                BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                String f_temp_file,f_temp_console_file="";
                while((f_temp_file=meta_3_file.readLine())!=null){
                    f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                }
                meta_3_file.close();
              if(f_file.exists()&(file5.getText().equals(f_file.getName()))){
                  index.setText(null);
                  index.setText(" 1  ");
                  codetarea.setText(f_temp_console_file);
                  file5.setText(f_file.getName());
                  for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                          index.append("\n "+f_con_file+" ");
                   }
              }
              if((!f_file.exists())||(!(file5.getText().equals(f_file.getName())))){
                codetarea.setText(null);
                index.setText(null);
                codetarea.setText("//  Welcome To Orb");
                index.setText(" 1  ");
              }
            }
            catch(IOException exc){
  
          }
            }
          });
        terfile.setLayout(new GridLayout(1,10,0,0));
        terfile.add(file1);
        terfile.add(file1butt);
        terfile.add(file2);
        terfile.add(file2butt);
        terfile.add(file3);
        terfile.add(file3butt);
        terfile.add(file4);
        terfile.add(file4butt);
        terfile.add(file5);
        terfile.add(file5butt);
         codesp=new JScrollPane();
        codesp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
        codesp.setBackground(Color.BLACK);
        codesp.getViewport().setBackground(Color.BLACK);
        codesp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        codesp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JScrollBar codesvbar=codesp.getVerticalScrollBar();
        codesvbar.setBackground(new Color(54, 53, 53));
        codesvbar.setCursor(c);
        codesvbar.setPreferredSize(new Dimension(10,10));
        JScrollBar codeshbar=codesp.getHorizontalScrollBar();
        codeshbar.setBackground(new Color(54, 53, 53));
        codeshbar.setCursor(c);
        codeshbar.setPreferredSize(new Dimension(10,10));
        UIManager.put("ScrollBar.track", new Color(54, 53, 53));
        UIManager.put("ScrollBar.thumb", new Color(3, 252, 7));
        class CoTeBar extends BasicScrollBarUI{
            protected void configureScorllBarColors(){
               trackColor=(Color)UIManager.get("ScrollBar.track");
               thumbColor=(Color)UIManager.get("ScrollBar.thumb");
            }
      protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
           }
      protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
           }
      public JButton createZeroButton() {
        JButton button_1 = new JButton();
        button_1.setPreferredSize(new Dimension(0, 0));
        button_1.setMinimumSize(new Dimension(0, 0));
        button_1.setMaximumSize(new Dimension(0, 0));
        button_1.setFocusable(false);
        return button_1;
            }
        }
        codesvbar.setUI(new CoTeBar());
        codeshbar.setUI(new CoTeBar());
        JPanel cotecorner=new JPanel();
        cotecorner.setBackground(new Color(3, 252, 7));
         codepanel=new JPanel();
         codepanel_child=new JPanel();
         codepanel_child.setBackground(Color.BLACK);
         index=new JTextArea();
        index.setBackground(Color.BLACK);
        Font font=new Font("Serif",Font.BOLD,15);
         codetarea=new JTextArea("//  Welcome To Orb");
         index.setFont(font);
        index.setForeground(Color.CYAN);
        index.setText(" 1  ");
        index.setEditable(false);
        index.setFocusable(false);
        index.setSelectedTextColor(new Color(3, 252, 7));
        index.setSelectionColor(Color.DARK_GRAY);
        codetarea.setFont(font);
        codetarea.setForeground(Color.CYAN);
        codetarea.setBackground(Color.BLACK);
        codetarea.setFocusable(false);
        codetarea.setName("codedir");
        codetarea.addMouseListener(new Temp3());
        codetarea.setSelectedTextColor(new Color(3, 252, 7));
        codetarea.setSelectionColor(Color.DARK_GRAY);
        codetarea.setCaretColor(Color.CYAN);
        codetarea.addCaretListener(new CaretListener(){
             public void caretUpdate(CaretEvent e){
                prevcaretpos=caretpos;
                   caretpos=codetarea.getCaretPosition();
             }
        });
        codetarea.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                int key1=(int)e.getKeyChar();
                if(key1==14){//for ctrl+n new file
                    file_1_count=file_1_count-1;
                            file_2_count=file_2_count-1;
                            file_3_count=file_3_count-1;
                            file_4_count=file_4_count-1;
                            if(fc<=5){
                                fc++;
                            }
                            if(temp_new<=5){
                                temp_new++;
                            }
                            if(temp_new>5){
                                ImageIcon fnewerr = new ImageIcon("./image/warning_1.png");
                    Image fnewerro=fnewerr.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
                    ImageIcon fnewerron=new ImageIcon(fnewerro);
                    JLabel cmbox_l=new JLabel("Sorry for your inconvenience, but the current version of Orb permits only five files to be displayed concurrently. Please remove one or more files before opening or creating a new file.");
                    Toolkit tdir=Toolkit.getDefaultToolkit();
                    Dimension sizedir=tdir.getScreenSize();
                    cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
                    cmbox_l.setBackground(Color.BLACK);
                    cmbox_l.setForeground(Color.CYAN);
                    JOptionPane.showMessageDialog(null,cmbox_l,"Open Error"
                    ,JOptionPane.INFORMATION_MESSAGE,fnewerron);
                            }
                         switch(temp_new){
                            case 2:
                            file2.setVisible(true);
                            file1butt.setVisible(false);
                            file2butt.setVisible(true);
                            file3butt.setVisible(false);
                            file4butt.setVisible(false);
                            file5butt.setVisible(false);
                            file1.setBorder(null);
                            file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                            file3.setBorder(null);
                            file4.setBorder(null);
                            file5.setBorder(null);
                            fileselect=2;
                            file2isnew=true;
                            fileteron_2=orb_exton;
                            fileion_2=orb_exton;
                             break;
                            case 3:
                            file3.setVisible(true);
                            file1butt.setVisible(false);
                            file2butt.setVisible(false);
                            file3butt.setVisible(true);
                            file4butt.setVisible(false);
                            file5butt.setVisible(false);
                            file1.setBorder(null);
                            file2.setBorder(null);
                            file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                            file4.setBorder(null);
                            file5.setBorder(null);
                            fileselect=3;
                            file3isnew=true;
                            fileteron_3=orb_exton;
                            fileion_3=orb_exton;
                             break;
                            case 4:
                            file4.setVisible(true);
                            file1butt.setVisible(false);
                            file2butt.setVisible(false);
                            file3butt.setVisible(false);
                            file4butt.setVisible(true);
                            file5butt.setVisible(false);
                            file1.setBorder(null);
                            file2.setBorder(null);
                            file3.setBorder(null);
                            file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                            file5.setBorder(null);
                            fileselect=4;
                            file4isnew=true;
                            fileteron_4=orb_exton;
                            fileion_4=orb_exton;
                             break;
                            case 5:
                             file5.setVisible(true);
                             file1butt.setVisible(false);
                             file2butt.setVisible(false);
                             file3butt.setVisible(false);
                             file4butt.setVisible(false);
                             file5butt.setVisible(true);
                             file1.setBorder(null);
                             file2.setBorder(null);
                             file3.setBorder(null);
                             file4.setBorder(null);
                             file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                             fileselect=5;
                             file5isnew=true;
                             fileteron_5=orb_exton;
                             fileion_5=orb_exton;
                              break;
                         }
                         if(temp_new<=5){
                             codetarea.setText(null);
                             index.setText(null);
                             codetarea.setText("//  Welcome To Orb");
                             index.setText(" 1  ");
                         }
                      try{
                          String fc_s=Integer.toString(temp_new);
                          if(temp_new<=5){
                              BufferedWriter filefctemp1=new BufferedWriter(new FileWriter(filefcpathmeta));
                                               filefctemp1.write(fc_s);
                                               filefctemp1.flush();
                                               filefctemp1.close();
                         }
                      }
                      catch(IOException exc){
              
                      }
                   }
                   if(key1==83){//for shift+S saveas file 
                    try{
                        BufferedReader filesavermeta=new BufferedReader(new FileReader(filesavepathmeta));
                    file1save=Boolean.valueOf(filesavermeta.readLine());
                    file2save=Boolean.valueOf(filesavermeta.readLine());
                    file3save=Boolean.valueOf(filesavermeta.readLine());
                    file4save=Boolean.valueOf(filesavermeta.readLine());
                    file5save=Boolean.valueOf(filesavermeta.readLine());
                    filesavermeta.close();
                    }
                    catch(IOException exc){
            
                    }
                    JFileChooser savedialog=new JFileChooser();
                    int tempsaveas=savedialog.showSaveDialog(null);
                    if(tempsaveas==JFileChooser.APPROVE_OPTION){
                        switch(fileselect){
                            case 1:
                            filetemp1=savedialog.getSelectedFile();
                            filenametemp1=filetemp1.getName();
                            filepathtemp1=filetemp1.getAbsolutePath();
                           String filecontenttemp1=codetarea.getText();
                           file1.setText(filenametemp1);
                           file1.setIcon(null);
                           file1.removeMouseListener(new Temp4());
                           file1.addMouseListener(new Temp5());
                           File f1_ext=filetemp1;
                           String name_for_ext_1=f1_ext.getName();
                           String ext_1="";
                           int dot_1=name_for_ext_1.lastIndexOf(".");
                           if(dot_1>0&dot_1<name_for_ext_1.length()-1){
                               ext_1=name_for_ext_1.substring(dot_1+1);
                           }
                           switch(ext_1){
                               case "orb":
                               fileteron_1=orb_exton;
                               fileion_1=orb_exton;
                                break;
                               case "java":
                               fileteron_1=icon_java_ext;
                               fileion_1=icon_java_ext;
                               break;
                             }
                          try{
                              if(!filetemp1.exists()){
                                      filetemp1.createNewFile();
                              }
                                BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                               filebftemp1.write(filecontenttemp1);
                               filebftemp1.close();
                               String s[]=new String[5];
                               BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                               String x= filebfrtempmeta1.readLine();
                               if(x==null){
                                BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                                filebftempmeta1.write(filepathtemp1);
                                filebftempmeta1.newLine();
                                filebftempmeta1.flush();
                                filebftempmeta1.close();
                               }
                               if(x!=null){
                                for(int i=1;i<5;i++){
                                    s[i]=filebfrtempmeta1.readLine();
                                }
                                filebfrtempmeta1.close();
                                BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                                filebftempmeta1.write("");
                                filebftempmeta1.flush();
                                filebftempmeta1.close();
                                BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                                filebfwtempmeta1.write(filepathtemp1);
                                filebfwtempmeta1.newLine();
                                if(s[1]!=null){
                                    filebfwtempmeta1.write(s[1]);
                                    filebfwtempmeta1.newLine();
                                }
                                if(s[2]!=null){
                                    filebfwtempmeta1.write(s[2]);
                                    filebfwtempmeta1.newLine();
                                }
                                if(s[3]!=null){
                                    filebfwtempmeta1.write(s[3]);
                                    filebfwtempmeta1.newLine();
                                }
                                if(s[4]!=null){
                                    filebfwtempmeta1.write(s[4]);
                                    filebfwtempmeta1.newLine();
                                }
                                filebfwtempmeta1.flush();
                                filebfwtempmeta1.close();
                            }
                        }
                          catch(IOException exc){
            
                          }
                          file1save=true;
                          break;
                            case 2:
                            filetemp2=savedialog.getSelectedFile();
                            filenametemp2=filetemp2.getName();
                            filepathtemp2=filetemp2.getAbsolutePath();
                           String filecontenttemp2=codetarea.getText();
                           file2.setText(filenametemp2);
                           file2.setIcon(null);
                           file2.removeMouseListener(new Temp4());
                           file2.addMouseListener(new Temp5());
                           File f2_ext=filetemp2;
                           String name_for_ext_2=f2_ext.getName();
                           String ext_2="";
                           int dot_2=name_for_ext_2.lastIndexOf(".");
                           if(dot_2>0&dot_2<name_for_ext_2.length()-1){
                               ext_2=name_for_ext_2.substring(dot_2+1);
                           }
                           switch(ext_2){
                               case "orb":
                               fileteron_2=orb_exton;
                               fileion_2=orb_exton;
                                break;
                               case "java":
                               fileteron_2=icon_java_ext;
                               fileion_2=icon_java_ext;
                               break;
                             }
                          try{
                              if(!filetemp2.exists()){
                                      filetemp2.createNewFile();
                              }
                                BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                               filebftemp2.write(filecontenttemp2);
                               filebftemp2.flush();
                               filebftemp2.close();
                               String s[]=new String[5];
                               BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                               for(int i=0;i<1;i++){
                                   s[i]=filebfrtempmeta2.readLine();
                               }
                               String x= filebfrtempmeta2.readLine();
                               if(x==null){
                                BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                                filebftempmeta2.write(filepathtemp2);
                                filebftempmeta2.newLine();
                                filebftempmeta2.flush();
                                filebftempmeta2.close();
                               }
                               if(x!=null){
                                for(int i=2;i<5;i++){
                                    s[i]=filebfrtempmeta2.readLine();
                                }
                                filebfrtempmeta2.close();
                                BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                                filebftempmeta2.write("");
                                filebftempmeta2.flush();
                                filebftempmeta2.close();
                                BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                                if(s[0]!=null){
                                    filebfwtempmeta2.write(s[0]);
                                    filebfwtempmeta2.newLine();
                                }
                                filebfwtempmeta2.write(filepathtemp2);
                                filebfwtempmeta2.newLine();
                                if(s[2]!=null){
                                    filebfwtempmeta2.write(s[2]);
                                    filebfwtempmeta2.newLine();
                                }
                                if(s[3]!=null){
                                    filebfwtempmeta2.write(s[3]);
                                    filebfwtempmeta2.newLine();
                                }
                                if(s[4]!=null){
                                    filebfwtempmeta2.write(s[4]);
                                    filebfwtempmeta2.newLine();
                                }
                                filebfwtempmeta2.flush();
                                filebfwtempmeta2.close();
                               }
                            }
                            catch(IOException exc){
            
                            }
                            file2save=true;
                          break;
                          case 3:
                            filetemp3=savedialog.getSelectedFile();
                            filenametemp3=filetemp3.getName();
                            filepathtemp3=filetemp3.getAbsolutePath();
                           String filecontenttemp3=codetarea.getText();
                           file3.setText(filenametemp3);
                           file3.setIcon(null);
                           file3.removeMouseListener(new Temp4());
                           file3.addMouseListener(new Temp5());
                           File f3_ext=filetemp3;
                           String name_for_ext_3=f3_ext.getName();
                           String ext_3="";
                           int dot_3=name_for_ext_3.lastIndexOf(".");
                           if(dot_3>0&dot_3<name_for_ext_3.length()-1){
                               ext_3=name_for_ext_3.substring(dot_3+1);
                           }
                           switch(ext_3){
                               case "orb":
                               fileteron_3=orb_exton;
                               fileion_3=orb_exton;
                                break;
                               case "java":
                               fileteron_3=icon_java_ext;
                               fileion_3=icon_java_ext;
                               break;
                             }
                          try{
                              if(!filetemp3.exists()){
                                      filetemp3.createNewFile();
                              }
                                BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                               filebftemp3.write(filecontenttemp3);
                               filebftemp3.flush();
                               filebftemp3.close();
                            String s[]=new String[5];
                               BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                               for(int i=0;i<2;i++){
                                   s[i]=filebfrtempmeta3.readLine();
                               }
                               String x= filebfrtempmeta3.readLine();
                               if(x==null){
                                BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                                filebftempmeta3.write(filepathtemp3);
                                filebftempmeta3.newLine();
                                filebftempmeta3.flush();
                                filebftempmeta3.close();
                               }
                               if(x!=null){
                                for(int i=3;i<5;i++){
                                    s[i]=filebfrtempmeta3.readLine();
                                }
                                filebfrtempmeta3.close();
                                BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                                filebftempmeta3.write("");
                                filebftempmeta3.flush();
                                filebftempmeta3.close();
                                BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                                if(s[0]!=null){
                                    filebfwtempmeta3.write(s[0]);
                                    filebfwtempmeta3.newLine();
                                }
                                if(s[1]!=null){
                                    filebfwtempmeta3.write(s[1]);
                                    filebfwtempmeta3.newLine();
                                }
                                filebfwtempmeta3.write(filepathtemp3);
                                filebfwtempmeta3.newLine();
                                if(s[3]!=null){
                                    filebfwtempmeta3.write(s[3]);
                                    filebfwtempmeta3.newLine();
                                }
                                if(s[4]!=null){
                                    filebfwtempmeta3.write(s[4]);
                                    filebfwtempmeta3.newLine();
                                }
                                filebfwtempmeta3.flush();
                                filebfwtempmeta3.close();
                               }
                          }
                          catch(IOException exc){
            
                          }
                          file3save=true;
                          break;
                          case 4:
                          filetemp4=savedialog.getSelectedFile();
                          filenametemp4=filetemp4.getName();
                          filepathtemp4=filetemp4.getAbsolutePath();
                         String filecontenttemp4=codetarea.getText();
                         file4.setText(filenametemp4);
                         file4.setIcon(null);
                         file4.removeMouseListener(new Temp4());
                         file4.addMouseListener(new Temp5());
                         File f4_ext=filetemp4;
                         String name_for_ext_4=f4_ext.getName();
                         String ext_4="";
                         int dot_4=name_for_ext_4.lastIndexOf(".");
                         if(dot_4>0&dot_4<name_for_ext_4.length()-1){
                             ext_4=name_for_ext_4.substring(dot_4+1);
                         }
                         switch(ext_4){
                             case "orb":
                             fileteron_4=orb_exton;
                             fileion_4=orb_exton;
                              break;
                             case "java":
                             fileteron_4=icon_java_ext;
                             fileion_4=icon_java_ext;
                             break;
                           }
                        try{
                            if(!filetemp4.exists()){
                                    filetemp4.createNewFile();
                            }
                              BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                             filebftemp4.write(filecontenttemp4);
                             filebftemp4.flush();
                             filebftemp4.close();
                             String s[]=new String[5];
                               BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                               for(int i=0;i<3;i++){
                                   s[i]=filebfrtempmeta4.readLine();
                               }
                               String x= filebfrtempmeta4.readLine();
                               if(x==null){
                                BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                                filebftempmeta4.write(filepathtemp4);
                                filebftempmeta4.newLine();
                                filebftempmeta4.flush();
                                filebftempmeta4.close();
                               }
                               if(x!=null){
                                for(int i=4;i<5;i++){
                                    s[i]=filebfrtempmeta4.readLine();
                                }
                                filebfrtempmeta4.close();
                                BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                                filebftempmeta4.write("");
                                filebftempmeta4.flush();
                                filebftempmeta4.close();
                                BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                                if(s[0]!=null){
                                    filebfwtempmeta4.write(s[0]);
                                    filebfwtempmeta4.newLine();
                                }
                                if(s[1]!=null){
                                    filebfwtempmeta4.write(s[1]);
                                    filebfwtempmeta4.newLine();
                                }
                                if(s[2]!=null){
                                    filebfwtempmeta4.write(s[2]);
                                    filebfwtempmeta4.newLine();
                                }
                                filebfwtempmeta4.write(filepathtemp4);
                                filebfwtempmeta4.newLine();
                                if(s[4]!=null){
                                    filebfwtempmeta4.write(s[4]);
                                    filebfwtempmeta4.newLine();
                                }
                                filebfwtempmeta4.flush();
                                filebfwtempmeta4.close();
                            }
                        }
                        catch(IOException exc){
            
                        }
                        file4save=true;
                        break;
                        case 5:
                        filetemp5=savedialog.getSelectedFile();
                        filenametemp5=filetemp5.getName();
                        filepathtemp5=filetemp5.getAbsolutePath();
                       String filecontenttemp5=codetarea.getText();
                       file5.setText(filenametemp5);
                       file5.setIcon(null);
                       file5.removeMouseListener(new Temp4());
                       file5.addMouseListener(new Temp5());
                       File f5_ext=filetemp5;
                           String name_for_ext_5=f5_ext.getName();
                           String ext_5="";
                           int dot_5=name_for_ext_5.lastIndexOf(".");
                           if(dot_5>0&dot_5<name_for_ext_5.length()-1){
                               ext_5=name_for_ext_5.substring(dot_5+1);
                           }
                           switch(ext_5){
                               case "orb":
                               fileteron_5=orb_exton;
                               fileion_5=orb_exton;
                                break;
                               case "java":
                               fileteron_5=icon_java_ext;
                               fileion_5=icon_java_ext;
                               break;
                             }
                      try{
                          if(!filetemp5.exists()){
                                  filetemp5.createNewFile();
                          }
                            BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                           filebftemp5.write(filecontenttemp5);
                           filebftemp5.flush();
                           filebftemp5.close();
                           String s[]=new String[5];
                               BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                               for(int i=0;i<4;i++){
                                   s[i]=filebfrtempmeta5.readLine();
                               }
                               String x= filebfrtempmeta5.readLine();
                               filebfrtempmeta5.close();
                               if(x==null){
                                BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                                filebftempmeta5.write(filepathtemp5);
                                filebftempmeta5.newLine();
                                filebftempmeta5.flush();
                                filebftempmeta5.close();
                               }
                               if(x!=null){
                                BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                                filebftempmeta5.write("");
                                filebftempmeta5.flush();
                                filebftempmeta5.close();
                                BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                                if(s[0]!=null){
                                    filebfwtempmeta5.write(s[0]);
                                    filebfwtempmeta5.newLine();
                                }
                                if(s[1]!=null){
                                    filebfwtempmeta5.write(s[1]);
                                    filebfwtempmeta5.newLine();
                                }
                                if(s[2]!=null){
                                    filebfwtempmeta5.write(s[2]);
                                    filebfwtempmeta5.newLine();
                                }
                                if(s[3]!=null){
                                    filebfwtempmeta5.write(s[3]);
                                    filebfwtempmeta5.newLine();
                                }
                                filebfwtempmeta5.write(filepathtemp5);
                                filebfwtempmeta5.newLine();
                                filebfwtempmeta5.flush();
                                filebfwtempmeta5.close();
                            }
                        }
                      catch(IOException exc){
            
                      }
                      file5save=true;
                      break;
                        }
                        try{
                            BufferedWriter filesavemeta=new BufferedWriter(new FileWriter(filesavepathmeta));
                                    String filesavetemp1=String.valueOf(file1save);
                                    String filesavetemp2=String.valueOf(file2save);
                                    String filesavetemp3=String.valueOf(file3save);
                                    String filesavetemp4=String.valueOf(file4save);
                                    String filesavetemp5=String.valueOf(file5save);
                                    filesavemeta.write(filesavetemp1);
                                    filesavemeta.newLine();
                                    filesavemeta.write(filesavetemp2);
                                    filesavemeta.newLine();
                                    filesavemeta.write(filesavetemp3);
                                    filesavemeta.newLine();
                                    filesavemeta.write(filesavetemp4);
                                    filesavemeta.newLine();
                                    filesavemeta.write(filesavetemp5);
                                    filesavemeta.flush();
                                    filesavemeta.close();
                        }
                        catch(IOException exc){
            
                        }
                    }
                   }
                   if(key1==19){//for ctrl+S save
                    try{
                        BufferedReader filesavermeta=new BufferedReader(new FileReader(filesavepathmeta));
                    file1save=Boolean.valueOf(filesavermeta.readLine());
                    file2save=Boolean.valueOf(filesavermeta.readLine());
                    file3save=Boolean.valueOf(filesavermeta.readLine());
                    file4save=Boolean.valueOf(filesavermeta.readLine());
                    file5save=Boolean.valueOf(filesavermeta.readLine());
                    filesavermeta.close();
                    }
                    catch(IOException exc){
            
                    }
                        String filecontenttemp=codetarea.getText();
                        try{
                           String s[]=new String[5];
                        BufferedReader meta=new BufferedReader(new FileReader(filepathmeta));
                        for(int i=0;i<5;i++){
                            s[i]=meta.readLine();
                        }
                        meta.close();
                        switch(fileselect){
                            case 1:
                            Boolean tempboolfile1=false;
                            file1.removeMouseListener(new Temp4());
                            file1.addMouseListener(new Temp5());
                            fcheck=new File(s[0]);
                            filetemp1=fcheck;
                            filepathtemp1=filetemp1.getAbsolutePath();
                           filenametemp1=filetemp1.getName();
                            if(fcheck.exists()==false&tempboolfile1==false){
                               JFileChooser savedialog=new JFileChooser();
                               int tempsave=savedialog.showSaveDialog(null);
                              if(tempsave==JFileChooser.APPROVE_OPTION){
                                 filetemp1=savedialog.getSelectedFile();
                                  filepathtemp1=filetemp1.getAbsolutePath();
                                 filenametemp1=filetemp1.getName();
                                 file1.setText(filenametemp1);
                                 file1.setIcon(null);
                                 File f1_ext=filetemp1;
                                 String name_for_ext_1=f1_ext.getName();
                                 String ext_1="";
                                 int dot_1=name_for_ext_1.lastIndexOf(".");
                                 if(dot_1>0&dot_1<name_for_ext_1.length()-1){
                                     ext_1=name_for_ext_1.substring(dot_1+1);
                                 }
                                 switch(ext_1){
                                     case "orb":
                                     fileteron_1=orb_exton;
                                     fileion_1=orb_exton;
                                      break;
                                     case "java":
                                     fileteron_1=icon_java_ext;
                                     fileion_1=icon_java_ext;
                                     break;
                                   }
                                 tempboolfile1=true;
                                 BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                                 filebftemp1.write(filecontenttemp);
                                 filebftemp1.flush();
                                 filebftemp1.close();
                            }
                        }
                            if(fcheck.exists()==true&tempboolfile1==false&(fcheck.getName().equals(file1.getText()))){
                                tempboolfile1=true;
                                filetemp1=fcheck;
                                filepathtemp1=filetemp1.getAbsolutePath();
                               filenametemp1=filetemp1.getName();
                               String filecontenttemp1=codetarea.getText();
                               file1.setText(filenametemp1);
                               file1.setIcon(null);
                               file1.removeMouseListener(new Temp4());
                               file1.addMouseListener(new Temp5());
                              try{
                                    BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                                   filebftemp1.write(filecontenttemp1);
                                   filebftemp1.flush();
                                   filebftemp1.close();
                            }
                              catch(IOException exc){
            
                              }
                            }
                            try{
                                String s_1[]=new String[5];
                                BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                                String x= filebfrtempmeta1.readLine();
                                if(x==null){
                                 BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                                 filebftempmeta1.write(filepathtemp1);
                                 filebftempmeta1.newLine();
                                 filebftempmeta1.flush();
                                 filebftempmeta1.close();
                                }
                                if(x!=null){
                                 for(int i=1;i<5;i++){
                                     s_1[i]=filebfrtempmeta1.readLine();
                                 }
                                 filebfrtempmeta1.close();
                                 BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                                 filebftempmeta1.write("");
                                 filebftempmeta1.flush();
                                 filebftempmeta1.close();
                                 BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                                 filebfwtempmeta1.write(filepathtemp1);
                                 filebfwtempmeta1.newLine();
                                 if(s_1[1]!=null){
                                     filebfwtempmeta1.write(s_1[1]);
                                     filebfwtempmeta1.newLine();
                                 }
                                 if(s_1[2]!=null){
                                     filebfwtempmeta1.write(s_1[2]);
                                     filebfwtempmeta1.newLine();
                                 }
                                 if(s_1[3]!=null){
                                     filebfwtempmeta1.write(s_1[3]);
                                     filebfwtempmeta1.newLine();
                                 }
                                 if(s_1[4]!=null){
                                     filebfwtempmeta1.write(s_1[4]);
                                     filebfwtempmeta1.newLine();
                                 }
                                 filebfwtempmeta1.flush();
                                 filebfwtempmeta1.close();
                             }
                            }
                            catch(IOException exc){
            
                            }
                            file1save=true;
                            break;
                         case 2:
                         Boolean tempboolfile2=false;
                         file2.removeMouseListener(new Temp4());
                          file2.addMouseListener(new Temp5());
                         fcheck=new File(s[1]);
                         filetemp2=fcheck;
                            filepathtemp2=filetemp2.getAbsolutePath();
                           filenametemp2=filetemp2.getName();
                         if((fcheck.exists()==false||file2isnew==true)&tempboolfile2==false){
                            JFileChooser savedialog=new JFileChooser();
                            int tempsave=savedialog.showSaveDialog(null);
                           if(tempsave==JFileChooser.APPROVE_OPTION){
                              filetemp2=savedialog.getSelectedFile();
                               filepathtemp2=filetemp2.getAbsolutePath();
                              filenametemp2=filetemp2.getName();
                              file2.setText(filenametemp2);
                              file2.setIcon(null);
                              File f2_ext=filetemp2;
                              String name_for_ext_2=f2_ext.getName();
                              String ext_2="";
                              int dot_2=name_for_ext_2.lastIndexOf(".");
                              if(dot_2>0&dot_2<name_for_ext_2.length()-1){
                                  ext_2=name_for_ext_2.substring(dot_2+1);
                              }
                              switch(ext_2){
                                  case "orb":
                                  fileteron_2=orb_exton;
                                  fileion_2=orb_exton;
                                   break;
                                  case "java":
                                  fileteron_2=icon_java_ext;
                                  fileion_2=icon_java_ext;
                                  break;
                                }
                              tempboolfile2=true;
                              BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                              filebftemp2.write(filecontenttemp);
                              filebftemp2.flush();
                              filebftemp2.close();
                              file2isnew=false;
                         }
                     }
                         if(fcheck.exists()==true&tempboolfile2==false&(fcheck.getName().equals(file2.getText()))){
                            tempboolfile2=true;
                            filetemp2=fcheck;
                            filepathtemp2=filetemp2.getAbsolutePath();
                           filenametemp2=filetemp2.getName();
                            String filecontenttemp2=codetarea.getText();
                            file2.setText(filenametemp2);
                            file2.setIcon(null);
                            file2.removeMouseListener(new Temp4());
                             file2.addMouseListener(new Temp5());
                           try{
                                 BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                                filebftemp2.write(filecontenttemp2);
                                filebftemp2.flush();
                                filebftemp2.close();
                             }
                             catch(IOException exc){
            
                             }
                         }
                         try{
                            String s_2[]=new String[5];
                            BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                            for(int i=0;i<1;i++){
                                s_2[i]=filebfrtempmeta2.readLine();
                            }
                            String x= filebfrtempmeta2.readLine();
                            if(x==null){
                             BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                             filebftempmeta2.write(filepathtemp2);
                             filebftempmeta2.newLine();
                             filebftempmeta2.flush();
                             filebftempmeta2.close();
                            }
                            if(x!=null){
                             for(int i=2;i<5;i++){
                                 s_2[i]=filebfrtempmeta2.readLine();
                             } 
                              filebfrtempmeta2.close();
                             BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                             filebftempmeta2.write("");
                             filebftempmeta2.flush();
                             filebftempmeta2.close();
                             BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                             if(s_2[0]!=null){
                                 filebfwtempmeta2.write(s_2[0]);
                                 filebfwtempmeta2.newLine();
                             }
                             filebfwtempmeta2.write(filepathtemp2);
                             filebfwtempmeta2.newLine();
                             if(s_2[2]!=null){
                                 filebfwtempmeta2.write(s_2[2]);
                                 filebfwtempmeta2.newLine();
                             }
                             if(s_2[3]!=null){
                                 filebfwtempmeta2.write(s_2[3]);
                                 filebfwtempmeta2.newLine();
                             }
                             if(s_2[4]!=null){
                                 filebfwtempmeta2.write(s_2[4]);
                                 filebfwtempmeta2.newLine();
                             }
                             filebfwtempmeta2.flush();
                             filebfwtempmeta2.close();
                            }
                         }
                         catch(IOException exc){
            
                        }
                        file2save=true;
                         break;
                         case 3:
                          Boolean tempboolfile3=false;
                          file3.removeMouseListener(new Temp4());
                        file3.addMouseListener(new Temp5());
                         fcheck=new File(s[2]);
                         filetemp3=fcheck;
                         filenametemp3=filetemp3.getName();
                         filepathtemp3=filetemp3.getAbsolutePath();
                            if((fcheck.exists()==false||file3isnew==true)&tempboolfile3==false){
                               JFileChooser savedialog=new JFileChooser();
                               int tempsave=savedialog.showSaveDialog(null);
                              if(tempsave==JFileChooser.APPROVE_OPTION){
                                 filetemp3=savedialog.getSelectedFile();
                                  filepathtemp3=filetemp3.getAbsolutePath();
                                 filenametemp3=filetemp3.getName();
                                 file3.setText(filenametemp3);
                                 file3.setIcon(null);
                                 File f3_ext=filetemp3;
                                 String name_for_ext_3=f3_ext.getName();
                                 String ext_3="";
                                 int dot_3=name_for_ext_3.lastIndexOf(".");
                                 if(dot_3>0&dot_3<name_for_ext_3.length()-1){
                                     ext_3=name_for_ext_3.substring(dot_3+1);
                                 }
                                 switch(ext_3){
                                     case "orb":
                                     fileteron_3=orb_exton;
                                     fileion_3=orb_exton;
                                      break;
                                     case "java":
                                     fileteron_3=icon_java_ext;
                                     fileion_3=icon_java_ext;
                                     break;
                                   }
                                 tempboolfile3=true;
                                 BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                                 filebftemp3.write(filecontenttemp);
                                 filebftemp3.flush();
                                 filebftemp3.close();
                                 file3isnew=false;
                            }
                        }
                            if(fcheck.exists()==true&tempboolfile3==false&(fcheck.getName().equals(file3.getText()))){
                                tempboolfile3=true;
                                filetemp3=fcheck;
                            filenametemp3=filetemp3.getName();
                            filepathtemp3=filetemp3.getAbsolutePath();
                           String filecontenttemp3=codetarea.getText();
                           file3.setText(filenametemp3);
                           file3.setIcon(null);
                           file3.removeMouseListener(new Temp4());
                           file3.addMouseListener(new Temp5());
                          try{
                                BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                               filebftemp3.write(filecontenttemp3);
                               filebftemp3.flush();
                               filebftemp3.close();
                          }
                          catch(IOException exc){
            
                          }
                            }
                            try{
                                String s_3[]=new String[5];
                               BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                               for(int i=0;i<2;i++){
                                   s_3[i]=filebfrtempmeta3.readLine();
                               }
                               String x= filebfrtempmeta3.readLine();
                               if(x==null){
                                BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                                filebftempmeta3.write(filepathtemp3);
                                filebftempmeta3.newLine();
                                filebftempmeta3.flush();
                                filebftempmeta3.close();
                               }
                               if(x!=null){
                                for(int i=3;i<5;i++){
                                    s_3[i]=filebfrtempmeta3.readLine();
                                }
                                filebfrtempmeta3.close();
                                BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                                filebftempmeta3.write("");
                                filebftempmeta3.flush();
                                filebftempmeta3.close();
                                BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                                if(s_3[0]!=null){
                                    filebfwtempmeta3.write(s_3[0]);
                                    filebfwtempmeta3.newLine();
                                }
                                if(s_3[1]!=null){
                                    filebfwtempmeta3.write(s_3[1]);
                                    filebfwtempmeta3.newLine();
                                }
                                filebfwtempmeta3.write(filepathtemp3);
                                filebfwtempmeta3.newLine();
                                if(s_3[3]!=null){
                                    filebfwtempmeta3.write(s_3[3]);
                                    filebfwtempmeta3.newLine();
                                }
                                if(s_3[4]!=null){
                                    filebfwtempmeta3.write(s_3[4]);
                                    filebfwtempmeta3.newLine();
                                }
                                filebfwtempmeta3.flush();
                                filebfwtempmeta3.close();
                               }
                            }
                            catch(IOException exc){
            
                            }
                            file3save=true;
                            break;
                            case 4:
                            Boolean tempboolfile4=false;
                            file4.removeMouseListener(new Temp4());
                            file4.addMouseListener(new Temp5());
                            fcheck=new File(s[3]);
                            filetemp4=fcheck;
                                filepathtemp4=filetemp4.getAbsolutePath();
                               filenametemp4=filetemp4.getName();
                            if((fcheck.exists()==false||file4isnew==true)&tempboolfile4==false){
                               JFileChooser savedialog=new JFileChooser();
                               int tempsave=savedialog.showSaveDialog(null);
                              if(tempsave==JFileChooser.APPROVE_OPTION){
                                 filetemp4=savedialog.getSelectedFile();
                                  filepathtemp4=filetemp4.getAbsolutePath();
                                 filenametemp4=filetemp4.getName();
                                 file4.setText(filenametemp4);
                                 file4.setIcon(null);
                                 File f4_ext=filetemp4;
                                 String name_for_ext_4=f4_ext.getName();
                                 String ext_4="";
                                 int dot_4=name_for_ext_4.lastIndexOf(".");
                                 if(dot_4>0&dot_4<name_for_ext_4.length()-1){
                                     ext_4=name_for_ext_4.substring(dot_4+1);
                                 }
                                 switch(ext_4){
                                     case "orb":
                                     fileteron_4=orb_exton;
                                     fileion_4=orb_exton;
                                      break;
                                     case "java":
                                     fileteron_4=icon_java_ext;
                                     fileion_4=icon_java_ext;
                                     break;
                                   }
                                 tempboolfile4=true;
                                 BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                                 filebftemp4.write(filecontenttemp);
                                 filebftemp4.flush();
                                 filebftemp4.close();
                                 file4isnew=false;
                            }
                        }
                            if(fcheck.exists()==true&tempboolfile4==false&(fcheck.getName().equals(file4.getText()))){
                                tempboolfile4=true;
                                filetemp4=fcheck;
                                filepathtemp4=filetemp4.getAbsolutePath();
                               filenametemp4=filetemp4.getName();
                         String filecontenttemp4=codetarea.getText();
                         file4.setText(filenametemp4);
                         file4.setIcon(null);
                         file4.removeMouseListener(new Temp4());
                         file4.addMouseListener(new Temp5());
                        try{
                              BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                             filebftemp4.write(filecontenttemp4);
                             filebftemp4.flush();
                             filebftemp4.close();
                        }
                        catch(IOException exc){
            
                        }
                            }
                            try{
                                String s_4[]=new String[5];
                                BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                                for(int i=0;i<3;i++){
                                    s_4[i]=filebfrtempmeta4.readLine();
                                }
                                String x= filebfrtempmeta4.readLine();
                                if(x==null){
                                 BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                                 filebftempmeta4.write(filepathtemp4);
                                 filebftempmeta4.newLine();
                                 filebftempmeta4.flush();
                                 filebftempmeta4.close();
                                }
                                if(x!=null){
                                 for(int i=4;i<5;i++){
                                     s_4[i]=filebfrtempmeta4.readLine();
                                 }
                                 filebfrtempmeta4.close();
                                 BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                                 filebftempmeta4.write("");
                                 filebftempmeta4.flush();
                                 filebftempmeta4.close();
                                 BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                                 if(s_4[0]!=null){
                                     filebfwtempmeta4.write(s_4[0]);
                                     filebfwtempmeta4.newLine();
                                 }
                                 if(s_4[1]!=null){
                                     filebfwtempmeta4.write(s_4[1]);
                                     filebfwtempmeta4.newLine();
                                 }
                                 if(s_4[2]!=null){
                                     filebfwtempmeta4.write(s_4[2]);
                                     filebfwtempmeta4.newLine();
                                 }
                                 filebfwtempmeta4.write(filepathtemp4);
                                 filebfwtempmeta4.newLine();
                                 if(s_4[4]!=null){
                                     filebfwtempmeta4.write(s_4[4]);
                                     filebfwtempmeta4.newLine();
                                 }
                                 filebfwtempmeta4.flush();
                                 filebfwtempmeta4.close();
                             }
                            }
                            catch(IOException exc){
            
                            }
                            file4save=true;
                            break;
                            case 5:
                            Boolean tempboolfile5=false;
                            file5.removeMouseListener(new Temp4());
                            file5.addMouseListener(new Temp5());
                            fcheck=new File(s[4]);
                            filetemp5=fcheck;
                            filepathtemp5=filetemp5.getAbsolutePath();
                           filenametemp5=filetemp5.getName();
                            if((fcheck.exists()==false||file5isnew==true)&tempboolfile5==false){
                               JFileChooser savedialog=new JFileChooser();
                               int tempsave=savedialog.showSaveDialog(null);
                              if(tempsave==JFileChooser.APPROVE_OPTION){
                                 filetemp5=savedialog.getSelectedFile();
                                  filepathtemp5=filetemp5.getAbsolutePath();
                                 filenametemp5=filetemp5.getName();
                                 file5.setText(filenametemp5);
                                 file5.setIcon(null);
                                 File f5_ext=filetemp5;
                                 String name_for_ext_5=f5_ext.getName();
                                 String ext_5="";
                                 int dot_5=name_for_ext_5.lastIndexOf(".");
                                 if(dot_5>0&dot_5<name_for_ext_5.length()-1){
                                     ext_5=name_for_ext_5.substring(dot_5+1);
                                 }
                                 switch(ext_5){
                                     case "orb":
                                     fileteron_5=orb_exton;
                                     fileion_5=orb_exton;
                                      break;
                                     case "java":
                                     fileteron_5=icon_java_ext;
                                     fileion_5=icon_java_ext;
                                     break;
                                   }
                                 tempboolfile5=true;
                                 BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                                 filebftemp5.write(filecontenttemp);
                                 filebftemp5.flush();
                                 filebftemp5.close();
                                 file5isnew=false;
                            }
                        }
                            if(fcheck.exists()==true&tempboolfile5==false&(fcheck.getName().equals(file5.getText()))){
                                tempboolfile5=true;
                                filetemp5=fcheck;
                                filepathtemp5=filetemp5.getAbsolutePath();
                               filenametemp5=filetemp5.getName();
                                String filecontenttemp5=codetarea.getText();
                                file5.setText(filenametemp5);
                                file5.setIcon(null);
                                file5.removeMouseListener(new Temp4());
                                file5.addMouseListener(new Temp5());
                               try{
                                     BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                                    filebftemp5.write(filecontenttemp5);
                                    filebftemp5.flush();
                                    filebftemp5.close();
                                 }
                               catch(IOException exc){
             
                               }
                            }
                            try{
                                String s_5[]=new String[5];
                                        BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                                        for(int i=0;i<4;i++){
                                            s_5[i]=filebfrtempmeta5.readLine();
                                        }
                                        String x= filebfrtempmeta5.readLine();
                                        filebfrtempmeta5.close();
                                        if(x==null){
                                         BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                                         filebftempmeta5.write(filepathtemp5);
                                         filebftempmeta5.newLine();
                                         filebftempmeta5.flush();
                                         filebftempmeta5.close();
                                        }
                                        if(x!=null){
                                         BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                                         filebftempmeta5.write("");
                                         filebftempmeta5.flush();
                                         filebftempmeta5.close();
                                         BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                                         if(s_5[0]!=null){
                                             filebfwtempmeta5.write(s_5[0]);
                                             filebfwtempmeta5.newLine();
                                         }
                                         if(s_5[1]!=null){
                                             filebfwtempmeta5.write(s_5[1]);
                                             filebfwtempmeta5.newLine();
                                         }
                                         if(s_5[2]!=null){
                                             filebfwtempmeta5.write(s_5[2]);
                                             filebfwtempmeta5.newLine();
                                         }
                                         if(s_5[3]!=null){
                                             filebfwtempmeta5.write(s_5[3]);
                                             filebfwtempmeta5.newLine();
                                         }
                                         filebfwtempmeta5.write(filepathtemp5);
                                         filebfwtempmeta5.newLine();
                                         filebfwtempmeta5.flush();
                                         filebfwtempmeta5.close();
                                     }
                            }
                            catch(IOException exc){
            
                            }
                            file5save=true;
                            break;
                            }
                         }
                       catch(IOException exc){
            
                       }
                       try{
                        BufferedWriter filesavemeta=new BufferedWriter(new FileWriter(filesavepathmeta));
                                String filesavetemp1=String.valueOf(file1save);
                                String filesavetemp2=String.valueOf(file2save);
                                String filesavetemp3=String.valueOf(file3save);
                                String filesavetemp4=String.valueOf(file4save);
                                String filesavetemp5=String.valueOf(file5save);
                                filesavemeta.write(filesavetemp1);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp2);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp3);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp4);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp5);
                                filesavemeta.flush();
                                filesavemeta.close();
                    }
                    catch(IOException exc){
            
                    }
                   }
                if(key1==15){//for ctrl+o open file
                    file_1_count=file_1_count-1;
                        file_2_count=file_2_count-1;
                        file_3_count=file_3_count-1;
                        file_4_count=file_4_count-1;
                         JFileChooser opendialog=new JFileChooser();
                            int tempopen=opendialog.showOpenDialog(null);
                           if(tempopen==JFileChooser.APPROVE_OPTION){
                            fileopen=opendialog.getSelectedFile();
                            fileopenpath=fileopen.getAbsolutePath();
                           fileopenname=fileopen.getName();
                           if(fc<=5){
                            fc++;
                        }
                        File f_ext=fileopen;
                        String name_for_ext=f_ext.getName();
                        String ext="";
                        int dot=name_for_ext.lastIndexOf(".");
                        if(dot>0&dot<name_for_ext.length()-1){
                            ext=name_for_ext.substring(dot+1);
                        }
                        if(temp_new<=5){
                            temp_new++;
                        }
                        if(temp_new>5){
                            ImageIcon openerr = new ImageIcon("./image/warning_1.png");
                            Image openerro=openerr.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
                            ImageIcon openerron=new ImageIcon(openerro);
                            JLabel cmbox_l=new JLabel("Sorry for your inconvenience, but the current version of Orb permits only five files to be displayed concurrently. Please remove one or more files before opening or creating a new file.");
                            Toolkit tdir=Toolkit.getDefaultToolkit();
                            Dimension sizedir=tdir.getScreenSize();
                            cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
                            cmbox_l.setBackground(Color.BLACK);
                            cmbox_l.setForeground(Color.CYAN);
                            JOptionPane.showMessageDialog(null,cmbox_l,"Open Error"
                            ,JOptionPane.INFORMATION_MESSAGE,openerron);
                        }
                     switch(temp_new){
                        case 2:
                        switch(ext){
                            case "orb":
                            fileteron_2=orb_exton;
                            fileion_2=orb_exton;
                             break;
                            case "java":
                            fileteron_2=icon_java_ext;
                            fileion_2=icon_java_ext;
                            break;
                          }
                        file2.setVisible(true);
                        file1butt.setVisible(false);
                        file2butt.setVisible(true);
                        file3butt.setVisible(false);
                        file4butt.setVisible(false);
                        file5butt.setVisible(false);
                        file1.setBorder(null);
                        file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                        file3.setBorder(null);
                        file4.setBorder(null);
                        file5.setBorder(null);
                        fileselect=2;
                        file2isnew=true;
                         break;
                        case 3:
                        switch(ext){
                            case "orb":
                            fileteron_3=orb_exton;
                            fileion_3=orb_exton;
                             break;
                            case "java":
                            fileteron_3=icon_java_ext;
                            fileion_3=icon_java_ext;
                            break;
                          }
                        file3.setVisible(true);
                        file1butt.setVisible(false);
                        file2butt.setVisible(false);
                        file3butt.setVisible(true);
                        file4butt.setVisible(false);
                        file5butt.setVisible(false);
                        file1.setBorder(null);
                        file2.setBorder(null);
                        file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                        file4.setBorder(null);
                        file5.setBorder(null);
                        fileselect=3;
                         file3isnew=true;
                         break;
                        case 4:
                        switch(ext){
                            case "orb":
                            fileteron_4=orb_exton;
                            fileion_4=orb_exton;
                             break;
                            case "java":
                            fileteron_4=icon_java_ext;
                            fileion_4=icon_java_ext;
                            break;
                          }
                        file4.setVisible(true);
                        file1butt.setVisible(false);
                        file2butt.setVisible(false);
                        file3butt.setVisible(false);
                        file4butt.setVisible(true);
                        file5butt.setVisible(false);
                        file1.setBorder(null);
                        file2.setBorder(null);
                        file3.setBorder(null);
                        file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                        file5.setBorder(null);
                        fileselect=4;
                        file4isnew=true;
                         break;
                        case 5:
                        switch(ext){
                            case "orb":
                            fileteron_5=orb_exton;
                            fileion_5=orb_exton;
                             break;
                            case "java":
                            fileteron_5=icon_java_ext;
                            fileion_5=icon_java_ext;
                            break;
                          }
                         file5.setVisible(true);
                         file1butt.setVisible(false);
                         file2butt.setVisible(false);
                         file3butt.setVisible(false);
                         file4butt.setVisible(false);
                         file5butt.setVisible(true);
                         file1.setBorder(null);
                         file2.setBorder(null);
                         file3.setBorder(null);
                         file4.setBorder(null);
                         file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                         fileselect=5;
                         file5isnew=true;
                          break;
                     }
                     if(temp_new<=5){
                    try{
                        File f_file=fileopen;
                            BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                            String f_temp_file,f_temp_console_file="";
                            while((f_temp_file=meta_3_file.readLine())!=null){
                                f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                            }
                            meta_3_file.close();
                          if(f_file.exists()){
                              index.setText(null);
                              index.setText(" 1  ");
                              codetarea.setText(f_temp_console_file);
                              if(fileselect==1){
                                  file1.setText(f_file.getName());
                              }
                              if(fileselect==2){
                                file2.setText(f_file.getName());
                            }
                            if(fileselect==3){
                                file3.setText(f_file.getName());
                            }
                            if(fileselect==4){
                                file4.setText(f_file.getName());
                            }
                            if(fileselect==5){
                                file5.setText(f_file.getName());
                            }
                              for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                      index.append("\n "+f_con_file+" ");
                               }
                          }
                    }
                    catch(IOException exc){
          
                    }
                }
                  try{
                      String fc_s=Integer.toString(temp_new);
                      if(temp_new<=5){
                          BufferedWriter filefctemp1=new BufferedWriter(new FileWriter(filefcpathmeta));
                                           filefctemp1.write(fc_s);
                                           filefctemp1.flush();
                                           filefctemp1.close();
                     }
                  }
                  catch(IOException exc){
          
                  }
                           }
                }
                if(key1==23){//ctrl+w
                    codetarea.setLineWrap(true);
                    codetarea.setWrapStyleWord(true);
                }
                if(key1==9){//ctrl+i
                    codetarea.setFont(codetarea.getFont().deriveFont(codetarea.getFont().getSize2D()+2f));
                    index.setFont(index.getFont().deriveFont(index.getFont().getSize2D()+2f));
                }
                if(key1==4){//ctrl+d
                    codetarea.setFont(codetarea.getFont().deriveFont(codetarea.getFont().getSize2D()-2f));
                    index.setFont(index.getFont().deriveFont(index.getFont().getSize2D()-2f));
                }
                if(key1==24){//ctrl+x
                    int prevind=index.getLineCount();
                    int codelen=codetarea.getLineCount();
                    if(prevind>codelen){
                        try{
                            int start=index.getLineStartOffset(codelen-1);//line codelen-2
                            int end=index.getLineEndOffset(prevind-1);
                            index.replaceRange("", start, end);
                            index.append(" "+index.getLineCount()+"   ");
                        }
                        catch(Exception exc){
                            System.out.println(exc.getMessage());
                        }
                    }
                }
                if(key1==8){//backspace
                    int prevind=index.getLineCount();
                    int codelen=codetarea.getLineCount();
                    if(prevind>codelen){
                        try{
                            int start=index.getLineStartOffset(codelen-1);//line codelen-2
                            int end=index.getLineEndOffset(prevind-1);
                            index.replaceRange("", start, end);
                            index.append(" "+index.getLineCount()+"   ");
                        }
                        catch(Exception exc){
                            System.out.println(exc.getMessage());
                        }
                    }
                }
                if(key1==10){//enter
                    index.append("\n "+codetarea.getLineCount()+"   ");
                }
                if(key1==22){//ctrl+v
                    int prevind=index.getLineCount();
                    int codelen=codetarea.getLineCount();
                    if(prevind>codelen){
                        try{
                            int start=index.getLineStartOffset(codelen);//line codelen-1
                            int end=index.getLineEndOffset(prevind-1);
                            index.replaceRange("", start, end);
                        }
                        catch(Exception exc){
                            System.out.println(exc.getMessage());
                        }
                    }
                    if(prevind<=codelen){
                        while(prevind!=codelen){
                                  index.append("\n "+(prevind+1)+"   ");
                            prevind++;
                        }
                    }
                }
                if(key1==12){//ctrl+l
                    codesp.setSize(new Dimension(codesp.getWidth(),codesp.getHeight()+10));
                    codesp.getViewport().setSize(new Dimension(codesp.getWidth(),codesp.getHeight()+10));
                    codesp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                    codepanel.setSize(new Dimension(codepanel.getWidth(),codepanel.getHeight()+10));
                    codepanel_child.setSize(new Dimension(codepanel_child.getWidth(),codepanel_child.getHeight()+10));
                    terminalsp.setSize(new Dimension(terminalsp.getWidth(),terminalsp.getHeight()-10));
                    terminalsp.getViewport().setSize(new Dimension(terminalsp.getWidth(),terminalsp.getHeight()-10));
                    terminalsp.setLocation(terminalsp.getX(),terminalsp.getY()+10);
                    terminalsp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                }
                if(key1==21){//ctrl+u
                    codesp.setSize(new Dimension(codesp.getWidth(),codesp.getHeight()-10));
                    codesp.getViewport().setSize(new Dimension(codesp.getWidth(),codesp.getHeight()-10));
                    codesp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                    codepanel.setSize(new Dimension(codepanel.getWidth(),codepanel.getHeight()-10));
                    codepanel_child.setSize(new Dimension(codepanel_child.getWidth(),codepanel_child.getHeight()-10));
                    terminalsp.setSize(new Dimension(terminalsp.getWidth(),terminalsp.getHeight()+10));
                    terminalsp.getViewport().setSize(new Dimension(terminalsp.getWidth(),terminalsp.getHeight()+10));
                    terminalsp.setLocation(terminalsp.getX(),terminalsp.getY()-10);
                    terminalsp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                }
            }
            public void keyPressed(KeyEvent e){
            
            }
        });
        codetarea.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e){
                String sel_text=codetarea.getSelectedText();
                if(sel_text==null){
                Highlighter h=codetarea.getHighlighter();
                 h.removeAllHighlights();
                }
            }
            public void focusLost(FocusEvent e){
                int start=codetarea.getSelectionStart();
                int end=codetarea.getSelectionEnd();
                String sel_text=codetarea.getSelectedText();
                Highlighter h=codetarea.getHighlighter();
                if(sel_text!=null){
                    Highlighter.HighlightPainter p=new DefaultHighlighter.DefaultHighlightPainter(Color.DARK_GRAY);
                    try{
                        h.removeAllHighlights();
                        h.addHighlight(start, end, p);
                    }
                    catch(BadLocationException exc){

                    }
                }
                else{
                    h.removeAllHighlights();
                }
                tempf.requestFocus();
            }
        });
        codepanel_child.setLayout(new BorderLayout());
         codepanel_child.add(index,BorderLayout.WEST);
        codepanel_child.add(codetarea,BorderLayout.CENTER);
        codepanel.setLayout(new BoxLayout(codepanel, BoxLayout.Y_AXIS));
        codepanel.add(codepanel_child);
        codesp.getViewport().add(codepanel);
        codesp.setCorner(codesp.LOWER_RIGHT_CORNER, cotecorner);
        codetarea.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                if(e.getY()>=codetarea.getHeight()-5){
                   f=e.getY();
                   g_resize=codesp.getHeight();
                   h_resize=codepanel.getHeight();
                   k_resize=codepanel_child.getHeight();
                   l_resize=terminalsp.getHeight();
                   m_resize=terminalsp.getY();
               }
               else{f=0;}
            }
        });
        codetarea.addKeyListener(new KeyListener(){
                public void keyTyped(KeyEvent e){
                    int modifier=e.getModifiersEx();
                    int x=(int)e.getKeyChar();
            if((modifier & KeyEvent.CTRL_DOWN_MASK)!=0||(modifier & KeyEvent.ALT_DOWN_MASK)!=0||x==9){
                e.consume();
            }
            else{
                switch(fileselect){
                    case 1:
                    file1.setIcon(fileteron);
                    file1.setHorizontalTextPosition(SwingConstants.RIGHT);
                   file1.removeMouseListener(new Temp5());
                    file1.addMouseListener(new Temp4());
                    break;
                    case 2:
                    file2.setIcon(fileteron);
                    file2.setHorizontalTextPosition(SwingConstants.RIGHT);
                    file2.removeMouseListener(new Temp5());
                    file2.addMouseListener(new Temp4());
                    break;
                    case 3:
                    file3.setIcon(fileteron);
                    file3.setHorizontalTextPosition(SwingConstants.RIGHT);
                    file3.removeMouseListener(new Temp5());
                    file3.addMouseListener(new Temp4());
                    break;
                    case 4:
                    file4.setIcon(fileteron);
                    file4.setHorizontalTextPosition(SwingConstants.RIGHT);
                    file4.removeMouseListener(new Temp5());
                    file4.addMouseListener(new Temp4());
                    break;
                    case 5:
                    file5.setIcon(fileteron);
                    file5.setHorizontalTextPosition(SwingConstants.RIGHT);
                    file5.removeMouseListener(new Temp5());
                    file5.addMouseListener(new Temp4());
                    break;
                }
            }
                }
                public void keyPressed(KeyEvent e){

                }
                public void keyReleased(KeyEvent e){

                }
        });
        codetarea.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent e){
            Cursor c1=new Cursor(Cursor.TEXT_CURSOR);
            Cursor c=new Cursor(Cursor.N_RESIZE_CURSOR);
               if(e.getY()>=codetarea.getHeight()-5){
                codetarea.setCursor(c);
               }
               if(e.getY()<codetarea.getHeight()-5){
                codetarea.setCursor(c1);
               }
            }
            public void mouseDragged(MouseEvent e){
                if(f!=0){
                    codesp.setSize(new Dimension(codesp.getWidth(),g_resize+(e.getY()-f)/2));
                    codesp.getViewport().setSize(new Dimension(codesp.getWidth(),g_resize+(e.getY()-f)/2));
                    codesp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                    codepanel.setSize(new Dimension(codepanel.getWidth(),h_resize+(e.getY()-f)/2));
                    codepanel_child.setSize(new Dimension(codepanel_child.getWidth(),k_resize+(e.getY()-f)/2));
                    terminalsp.setSize(new Dimension(terminalsp.getWidth(),l_resize-(e.getY()-f)/2));
                    terminalsp.getViewport().setSize(new Dimension(terminalsp.getWidth(),l_resize-(e.getY()-f)/2));
                    terminalsp.setLocation(terminalsp.getX(),m_resize+(e.getY()-f)/2);
                    terminalsp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                }
            }
        });

        terminaltarea=new JTextArea("//  Welcome To Terminal");
        terminaltarea.setFont(font);
        terminaltarea.setForeground(Color.CYAN);
        terminaltarea.setBackground(Color.BLACK);
        terminaltarea.setFocusable(false);
        terminaltarea.setName("terminaldir");
        terminaltarea.addMouseListener(new Temp3());
        terminaltarea.setSelectedTextColor(new Color(3, 252, 7));
        terminaltarea.setSelectionColor(Color.DARK_GRAY);
        terminaltarea.setCaretColor(Color.CYAN);
        terminaltarea.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                int key1=(int)e.getKeyChar();
                if(key1==23){
                    terminaltarea.setLineWrap(true);
                    terminaltarea.setWrapStyleWord(true);
                }
                if(key1==9){
                    terminaltarea.setFont(terminaltarea.getFont().deriveFont(terminaltarea.getFont().getSize2D()+2f));
                }
                if(key1==4){
                    terminaltarea.setFont(terminaltarea.getFont().deriveFont(terminaltarea.getFont().getSize2D()-2f));
                }
                if(key1==12){//ctrl+l
                    terminalsp.setSize(new Dimension(terminalsp.getWidth(),terminalsp.getHeight()-10));
                    terminalsp.getViewport().setSize(new Dimension(terminalsp.getWidth(),terminalsp.getHeight()-10));
                    terminalsp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                    terminalsp.setLocation(terminalsp.getX(),terminalsp.getY()+10);
                    codesp.setSize(new Dimension(codesp.getWidth(),codesp.getHeight()+10));
                    codesp.getViewport().setSize(new Dimension(codesp.getWidth(),codesp.getHeight()+10));
                   codesp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                    codepanel.setSize(new Dimension(codepanel.getWidth(),codepanel.getHeight()+10));
                    codepanel_child.setSize(new Dimension(codepanel_child.getWidth(),codepanel_child.getHeight()+10));
                }
                if(key1==21){//ctrl+u
                    terminalsp.setSize(new Dimension(terminalsp.getWidth(),terminalsp.getHeight()+10));
                    terminalsp.getViewport().setSize(new Dimension(terminalsp.getWidth(),terminalsp.getHeight()+10));
                    terminalsp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                    terminalsp.setLocation(terminalsp.getX(),terminalsp.getY()-10);
                    codesp.setSize(new Dimension(codesp.getWidth(),codesp.getHeight()-10));
                    codesp.getViewport().setSize(new Dimension(codesp.getWidth(),codesp.getHeight()-10));
                    codesp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                    codepanel.setSize(new Dimension(codepanel.getWidth(),codepanel.getHeight()-10));
                    codepanel_child.setSize(new Dimension(codepanel_child.getWidth(),codepanel_child.getHeight()-10));
                }
            }
            public void keyPressed(KeyEvent e){
           }
        });
        terminaltarea.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e){
            }
            public void focusLost(FocusEvent e){
                tempf.requestFocus();
            }
        });
         terminalsp=new JScrollPane();
        terminalsp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,(this.getHeight()-this.getHeight()/20)/2));
        terminalsp.setBackground(Color.BLACK);
        terminalsp.getViewport().setBackground(Color.BLACK);
        terminalsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        terminalsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        JScrollBar terminalsvbar=terminalsp.getVerticalScrollBar();
        terminalsvbar.setBackground(new Color(54, 53, 53));
        terminalsvbar.setCursor(c);
        terminalsvbar.setPreferredSize(new Dimension(10,10));
        JScrollBar terminalshbar=terminalsp.getHorizontalScrollBar();
        terminalshbar.setBackground(new Color(54, 53, 53));
        terminalshbar.setCursor(c);
        terminalshbar.setPreferredSize(new Dimension(10,10));
        terminalsvbar.setUI(new CoTeBar());
        terminalshbar.setUI(new CoTeBar());
        terminalsp.getViewport().add(terminaltarea);
        terminalsp.setCorner(terminalsp.LOWER_RIGHT_CORNER, cotecorner);
        terminaltarea.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                if(e.getY()<=5){
                   ft=e.getY();
                   gt_resize=codesp.getHeight();
                   ht_resize=codepanel.getHeight();
                   kt_resize=codepanel_child.getHeight();
                   lt_resize=terminalsp.getHeight();
                   mt_resize=terminalsp.getY();
               }
               else{
                   ft=0;
               }
            }
        });
        terminaltarea.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent e){
            Cursor c1=new Cursor(Cursor.TEXT_CURSOR);
            Cursor c=new Cursor(Cursor.N_RESIZE_CURSOR);
               if(e.getY()<=5){
                terminaltarea.setCursor(c);
               }
               if(e.getY()>5){
                terminaltarea.setCursor(c1);
               }
            }
            public void mouseDragged(MouseEvent e){
                if(ft!=0){
                terminalsp.setSize(new Dimension(terminalsp.getWidth(),lt_resize-(e.getY()-ft)/2));
                    terminalsp.getViewport().setSize(new Dimension(terminalsp.getWidth(),lt_resize-(e.getY()-ft)/2));
                    terminalsp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                    codesp.setSize(new Dimension(codesp.getWidth(),gt_resize+(e.getY()-ft)/2));
                    codesp.getViewport().setSize(new Dimension(codesp.getWidth(),gt_resize+(e.getY()-ft)/2));
                    codesp.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.MAGENTA));
                    codepanel.setSize(new Dimension(codepanel.getWidth(),ht_resize+(e.getY()-ft)/2));
                    codepanel_child.setSize(new Dimension(codepanel_child.getWidth(),kt_resize+(e.getY()-ft)/2));
                    terminalsp.setLocation(terminalsp.getX(),mt_resize+(e.getY()-ft)/2);
                }
            }
        });
        tertool.add(terfile,BorderLayout.WEST);
        terminal.add(tertool,BorderLayout.NORTH);
        terminal.add(codesp,BorderLayout.CENTER);
        terminal.add(terminalsp,BorderLayout.SOUTH);
        display.add(explorer,BorderLayout.WEST);
        display.add(terminal,BorderLayout.EAST);
        saveas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    BufferedReader filesavermeta=new BufferedReader(new FileReader(filesavepathmeta));
                file1save=Boolean.valueOf(filesavermeta.readLine());
                file2save=Boolean.valueOf(filesavermeta.readLine());
                file3save=Boolean.valueOf(filesavermeta.readLine());
                file4save=Boolean.valueOf(filesavermeta.readLine());
                file5save=Boolean.valueOf(filesavermeta.readLine());
                filesavermeta.close();
                }
                catch(IOException exc){
   
                }
                JFileChooser savedialog=new JFileChooser();
                int tempsaveas=savedialog.showSaveDialog(null);
                if(tempsaveas==JFileChooser.APPROVE_OPTION){
                    switch(fileselect){
                        case 1:
                        filetemp1=savedialog.getSelectedFile();
                        filenametemp1=filetemp1.getName();
                        filepathtemp1=filetemp1.getAbsolutePath();
                       String filecontenttemp1=codetarea.getText();
                       file1.setText(filenametemp1);
                       file1.setIcon(null);
                       file1.removeMouseListener(new Temp4());
                       file1.addMouseListener(new Temp5());
                       File f1_ext=filetemp1;
                       String name_for_ext_1=f1_ext.getName();
                       String ext_1="";
                       int dot_1=name_for_ext_1.lastIndexOf(".");
                       if(dot_1>0&dot_1<name_for_ext_1.length()-1){
                           ext_1=name_for_ext_1.substring(dot_1+1);
                       }
                       switch(ext_1){
                           case "orb":
                           fileteron_1=orb_exton;
                           fileion_1=orb_exton;
                            break;
                           case "java":
                           fileteron_1=icon_java_ext;
                           fileion_1=icon_java_ext;
                           break;
                         }
                      try{
                          if(!filetemp1.exists()){
                                  filetemp1.createNewFile();
                          }
                            BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                           filebftemp1.write(filecontenttemp1);
                           filebftemp1.close();
                           String s[]=new String[5];
                           BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                           String x= filebfrtempmeta1.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta1.write(filepathtemp1);
                            filebftempmeta1.newLine();
                            filebftempmeta1.flush();
                            filebftempmeta1.close();
                           }
                           if(x!=null){
                            for(int i=1;i<5;i++){
                                s[i]=filebfrtempmeta1.readLine();
                            }
                            filebfrtempmeta1.close();
                            BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta1.write("");
                            filebftempmeta1.flush();
                            filebftempmeta1.close();
                            BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebfwtempmeta1.write(filepathtemp1);
                            filebfwtempmeta1.newLine();
                            if(s[1]!=null){
                                filebfwtempmeta1.write(s[1]);
                                filebfwtempmeta1.newLine();
                            }
                            if(s[2]!=null){
                                filebfwtempmeta1.write(s[2]);
                                filebfwtempmeta1.newLine();
                            }
                            if(s[3]!=null){
                                filebfwtempmeta1.write(s[3]);
                                filebfwtempmeta1.newLine();
                            }
                            if(s[4]!=null){
                                filebfwtempmeta1.write(s[4]);
                                filebfwtempmeta1.newLine();
                            }
                            filebfwtempmeta1.flush();
                            filebfwtempmeta1.close();
                        }
                    }
                      catch(IOException exc){
   
                      }
                      file1save=true;
                      break;
                        case 2:
                        filetemp2=savedialog.getSelectedFile();
                        filenametemp2=filetemp2.getName();
                        filepathtemp2=filetemp2.getAbsolutePath();
                       String filecontenttemp2=codetarea.getText();
                       file2.setText(filenametemp2);
                       file2.setIcon(null);
                       file2.removeMouseListener(new Temp4());
                       file2.addMouseListener(new Temp5());
                       File f2_ext=filetemp2;
                       String name_for_ext_2=f2_ext.getName();
                       String ext_2="";
                       int dot_2=name_for_ext_2.lastIndexOf(".");
                       if(dot_2>0&dot_2<name_for_ext_2.length()-1){
                           ext_2=name_for_ext_2.substring(dot_2+1);
                       }
                       switch(ext_2){
                           case "orb":
                           fileteron_2=orb_exton;
                           fileion_2=orb_exton;
                            break;
                           case "java":
                           fileteron_2=icon_java_ext;
                           fileion_2=icon_java_ext;
                           break;
                         }
                      try{
                          if(!filetemp2.exists()){
                                  filetemp2.createNewFile();
                          }
                            BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                           filebftemp2.write(filecontenttemp2);
                           filebftemp2.flush();
                           filebftemp2.close();
                           String s[]=new String[5];
                           BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<1;i++){
                               s[i]=filebfrtempmeta2.readLine();
                           }
                           String x= filebfrtempmeta2.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta2.write(filepathtemp2);
                            filebftempmeta2.newLine();
                            filebftempmeta2.flush();
                            filebftempmeta2.close();
                           }
                           if(x!=null){
                            for(int i=2;i<5;i++){
                                s[i]=filebfrtempmeta2.readLine();
                            }
                            filebfrtempmeta2.close();
                            BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta2.write("");
                            filebftempmeta2.flush();
                            filebftempmeta2.close();
                            BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s[0]!=null){
                                filebfwtempmeta2.write(s[0]);
                                filebfwtempmeta2.newLine();
                            }
                            filebfwtempmeta2.write(filepathtemp2);
                            filebfwtempmeta2.newLine();
                            if(s[2]!=null){
                                filebfwtempmeta2.write(s[2]);
                                filebfwtempmeta2.newLine();
                            }
                            if(s[3]!=null){
                                filebfwtempmeta2.write(s[3]);
                                filebfwtempmeta2.newLine();
                            }
                            if(s[4]!=null){
                                filebfwtempmeta2.write(s[4]);
                                filebfwtempmeta2.newLine();
                            }
                            filebfwtempmeta2.flush();
                            filebfwtempmeta2.close();
                           }
                        }
                        catch(IOException exc){
   
                        }
                        file2save=true;
                      break;
                      case 3:
                        filetemp3=savedialog.getSelectedFile();
                        filenametemp3=filetemp3.getName();
                        filepathtemp3=filetemp3.getAbsolutePath();
                       String filecontenttemp3=codetarea.getText();
                       file3.setText(filenametemp3);
                       file3.setIcon(null);
                       file3.removeMouseListener(new Temp4());
                       file3.addMouseListener(new Temp5());
                       File f3_ext=filetemp3;
                       String name_for_ext_3=f3_ext.getName();
                       String ext_3="";
                       int dot_3=name_for_ext_3.lastIndexOf(".");
                       if(dot_3>0&dot_3<name_for_ext_3.length()-1){
                           ext_3=name_for_ext_3.substring(dot_3+1);
                       }
                       switch(ext_3){
                           case "orb":
                           fileteron_3=orb_exton;
                           fileion_3=orb_exton;
                            break;
                           case "java":
                           fileteron_3=icon_java_ext;
                           fileion_3=icon_java_ext;
                           break;
                         }
                      try{
                          if(!filetemp3.exists()){
                                  filetemp3.createNewFile();
                          }
                            BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                           filebftemp3.write(filecontenttemp3);
                           filebftemp3.flush();
                           filebftemp3.close();
                        String s[]=new String[5];
                           BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<2;i++){
                               s[i]=filebfrtempmeta3.readLine();
                           }
                           String x= filebfrtempmeta3.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta3.write(filepathtemp3);
                            filebftempmeta3.newLine();
                            filebftempmeta3.flush();
                            filebftempmeta3.close();
                           }
                           if(x!=null){
                            for(int i=3;i<5;i++){
                                s[i]=filebfrtempmeta3.readLine();
                            }
                            filebfrtempmeta3.close();
                            BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta3.write("");
                            filebftempmeta3.flush();
                            filebftempmeta3.close();
                            BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s[0]!=null){
                                filebfwtempmeta3.write(s[0]);
                                filebfwtempmeta3.newLine();
                            }
                            if(s[1]!=null){
                                filebfwtempmeta3.write(s[1]);
                                filebfwtempmeta3.newLine();
                            }
                            filebfwtempmeta3.write(filepathtemp3);
                            filebfwtempmeta3.newLine();
                            if(s[3]!=null){
                                filebfwtempmeta3.write(s[3]);
                                filebfwtempmeta3.newLine();
                            }
                            if(s[4]!=null){
                                filebfwtempmeta3.write(s[4]);
                                filebfwtempmeta3.newLine();
                            }
                            filebfwtempmeta3.flush();
                            filebfwtempmeta3.close();
                           }
                      }
                      catch(IOException exc){
   
                      }
                      file3save=true;
                      break;
                      case 4:
                      filetemp4=savedialog.getSelectedFile();
                      filenametemp4=filetemp4.getName();
                      filepathtemp4=filetemp4.getAbsolutePath();
                     String filecontenttemp4=codetarea.getText();
                     file4.setText(filenametemp4);
                     file4.setIcon(null);
                     file4.removeMouseListener(new Temp4());
                     file4.addMouseListener(new Temp5());
                     File f4_ext=filetemp4;
                     String name_for_ext_4=f4_ext.getName();
                     String ext_4="";
                     int dot_4=name_for_ext_4.lastIndexOf(".");
                     if(dot_4>0&dot_4<name_for_ext_4.length()-1){
                         ext_4=name_for_ext_4.substring(dot_4+1);
                     }
                     switch(ext_4){
                         case "orb":
                         fileteron_4=orb_exton;
                         fileion_4=orb_exton;
                          break;
                         case "java":
                         fileteron_4=icon_java_ext;
                         fileion_4=icon_java_ext;
                         break;
                       }
                    try{
                        if(!filetemp4.exists()){
                                filetemp4.createNewFile();
                        }
                          BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                         filebftemp4.write(filecontenttemp4);
                         filebftemp4.flush();
                         filebftemp4.close();
                         String s[]=new String[5];
                           BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<3;i++){
                               s[i]=filebfrtempmeta4.readLine();
                           }
                           String x= filebfrtempmeta4.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta4.write(filepathtemp4);
                            filebftempmeta4.newLine();
                            filebftempmeta4.flush();
                            filebftempmeta4.close();
                           }
                           if(x!=null){
                            for(int i=4;i<5;i++){
                                s[i]=filebfrtempmeta4.readLine();
                            }
                            filebfrtempmeta4.close();
                            BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta4.write("");
                            filebftempmeta4.flush();
                            filebftempmeta4.close();
                            BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s[0]!=null){
                                filebfwtempmeta4.write(s[0]);
                                filebfwtempmeta4.newLine();
                            }
                            if(s[1]!=null){
                                filebfwtempmeta4.write(s[1]);
                                filebfwtempmeta4.newLine();
                            }
                            if(s[2]!=null){
                                filebfwtempmeta4.write(s[2]);
                                filebfwtempmeta4.newLine();
                            }
                            filebfwtempmeta4.write(filepathtemp4);
                            filebfwtempmeta4.newLine();
                            if(s[4]!=null){
                                filebfwtempmeta4.write(s[4]);
                                filebfwtempmeta4.newLine();
                            }
                            filebfwtempmeta4.flush();
                            filebfwtempmeta4.close();
                        }
                    }
                    catch(IOException exc){
 
                    }
                    file4save=true;
                    break;
                    case 5:
                    filetemp5=savedialog.getSelectedFile();
                    filenametemp5=filetemp5.getName();
                    filepathtemp5=filetemp5.getAbsolutePath();
                   String filecontenttemp5=codetarea.getText();
                   file5.setText(filenametemp5);
                   file5.setIcon(null);
                   file5.removeMouseListener(new Temp4());
                   file5.addMouseListener(new Temp5());
                   File f5_ext=filetemp5;
                       String name_for_ext_5=f5_ext.getName();
                       String ext_5="";
                       int dot_5=name_for_ext_5.lastIndexOf(".");
                       if(dot_5>0&dot_5<name_for_ext_5.length()-1){
                           ext_5=name_for_ext_5.substring(dot_5+1);
                       }
                       switch(ext_5){
                           case "orb":
                           fileteron_5=orb_exton;
                           fileion_5=orb_exton;
                            break;
                           case "java":
                           fileteron_5=icon_java_ext;
                           fileion_5=icon_java_ext;
                           break;
                         }
                  try{
                      if(!filetemp5.exists()){
                              filetemp5.createNewFile();
                      }
                        BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                       filebftemp5.write(filecontenttemp5);
                       filebftemp5.flush();
                       filebftemp5.close();
                       String s[]=new String[5];
                           BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<4;i++){
                               s[i]=filebfrtempmeta5.readLine();
                           }
                           String x= filebfrtempmeta5.readLine();
                           filebfrtempmeta5.close();
                           if(x==null){
                            BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta5.write(filepathtemp5);
                            filebftempmeta5.newLine();
                            filebftempmeta5.flush();
                            filebftempmeta5.close();
                           }
                           if(x!=null){
                            BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta5.write("");
                            filebftempmeta5.flush();
                            filebftempmeta5.close();
                            BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s[0]!=null){
                                filebfwtempmeta5.write(s[0]);
                                filebfwtempmeta5.newLine();
                            }
                            if(s[1]!=null){
                                filebfwtempmeta5.write(s[1]);
                                filebfwtempmeta5.newLine();
                            }
                            if(s[2]!=null){
                                filebfwtempmeta5.write(s[2]);
                                filebfwtempmeta5.newLine();
                            }
                            if(s[3]!=null){
                                filebfwtempmeta5.write(s[3]);
                                filebfwtempmeta5.newLine();
                            }
                            filebfwtempmeta5.write(filepathtemp5);
                            filebfwtempmeta5.newLine();
                            filebfwtempmeta5.flush();
                            filebfwtempmeta5.close();
                        }
                    }
                  catch(IOException exc){

                  }
                  file5save=true;
                  break;
                    }
                    try{
                        BufferedWriter filesavemeta=new BufferedWriter(new FileWriter(filesavepathmeta));
                                String filesavetemp1=String.valueOf(file1save);
                                String filesavetemp2=String.valueOf(file2save);
                                String filesavetemp3=String.valueOf(file3save);
                                String filesavetemp4=String.valueOf(file4save);
                                String filesavetemp5=String.valueOf(file5save);
                                filesavemeta.write(filesavetemp1);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp2);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp3);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp4);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp5);
                                filesavemeta.flush();
                                filesavemeta.close();
                    }
                    catch(IOException exc){

                    }
                }
            }
        });
        arrsaveas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    BufferedReader filesavermeta=new BufferedReader(new FileReader(filesavepathmeta));
                file1save=Boolean.valueOf(filesavermeta.readLine());
                file2save=Boolean.valueOf(filesavermeta.readLine());
                file3save=Boolean.valueOf(filesavermeta.readLine());
                file4save=Boolean.valueOf(filesavermeta.readLine());
                file5save=Boolean.valueOf(filesavermeta.readLine());
                filesavermeta.close();
                }
                catch(IOException exc){
   
                }
                JFileChooser savedialog=new JFileChooser();
                int tempsaveas=savedialog.showSaveDialog(null);
                if(tempsaveas==JFileChooser.APPROVE_OPTION){
                    switch(fileselect){
                        case 1:
                        filetemp1=savedialog.getSelectedFile();
                        filenametemp1=filetemp1.getName();
                        filepathtemp1=filetemp1.getAbsolutePath();
                       String filecontenttemp1=codetarea.getText();
                       file1.setText(filenametemp1);
                       file1.setIcon(null);
                       file1.removeMouseListener(new Temp4());
                       file1.addMouseListener(new Temp5());
                       File f1_ext=filetemp1;
                       String name_for_ext_1=f1_ext.getName();
                       String ext_1="";
                       int dot_1=name_for_ext_1.lastIndexOf(".");
                       if(dot_1>0&dot_1<name_for_ext_1.length()-1){
                           ext_1=name_for_ext_1.substring(dot_1+1);
                       }
                       switch(ext_1){
                           case "orb":
                           fileteron_1=orb_exton;
                           fileion_1=orb_exton;
                            break;
                           case "java":
                           fileteron_1=icon_java_ext;
                           fileion_1=icon_java_ext;
                           break;
                         }
                      try{
                          if(!filetemp1.exists()){
                                  filetemp1.createNewFile();
                          }
                            BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                           filebftemp1.write(filecontenttemp1);
                           filebftemp1.close();
                           String s[]=new String[5];
                           BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                           String x= filebfrtempmeta1.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta1.write(filepathtemp1);
                            filebftempmeta1.newLine();
                            filebftempmeta1.flush();
                            filebftempmeta1.close();
                           }
                           if(x!=null){
                            for(int i=1;i<5;i++){
                                s[i]=filebfrtempmeta1.readLine();
                            }
                            filebfrtempmeta1.close();
                            BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta1.write("");
                            filebftempmeta1.flush();
                            filebftempmeta1.close();
                            BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebfwtempmeta1.write(filepathtemp1);
                            filebfwtempmeta1.newLine();
                            if(s[1]!=null){
                                filebfwtempmeta1.write(s[1]);
                                filebfwtempmeta1.newLine();
                            }
                            if(s[2]!=null){
                                filebfwtempmeta1.write(s[2]);
                                filebfwtempmeta1.newLine();
                            }
                            if(s[3]!=null){
                                filebfwtempmeta1.write(s[3]);
                                filebfwtempmeta1.newLine();
                            }
                            if(s[4]!=null){
                                filebfwtempmeta1.write(s[4]);
                                filebfwtempmeta1.newLine();
                            }
                            filebfwtempmeta1.flush();
                            filebfwtempmeta1.close();
                        }
                    }
                      catch(IOException exc){
   
                      }
                      file1save=true;
                      break;
                        case 2:
                        filetemp2=savedialog.getSelectedFile();
                        filenametemp2=filetemp2.getName();
                        filepathtemp2=filetemp2.getAbsolutePath();
                       String filecontenttemp2=codetarea.getText();
                       file2.setText(filenametemp2);
                       file2.setIcon(null);
                       file2.removeMouseListener(new Temp4());
                       file2.addMouseListener(new Temp5());
                       File f2_ext=filetemp2;
                       String name_for_ext_2=f2_ext.getName();
                       String ext_2="";
                       int dot_2=name_for_ext_2.lastIndexOf(".");
                       if(dot_2>0&dot_2<name_for_ext_2.length()-1){
                           ext_2=name_for_ext_2.substring(dot_2+1);
                       }
                       switch(ext_2){
                           case "orb":
                           fileteron_2=orb_exton;
                           fileion_2=orb_exton;
                            break;
                           case "java":
                           fileteron_2=icon_java_ext;
                           fileion_2=icon_java_ext;
                           break;
                         }
                      try{
                          if(!filetemp2.exists()){
                                  filetemp2.createNewFile();
                          }
                            BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                           filebftemp2.write(filecontenttemp2);
                           filebftemp2.flush();
                           filebftemp2.close();
                           String s[]=new String[5];
                           BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<1;i++){
                               s[i]=filebfrtempmeta2.readLine();
                           }
                           String x= filebfrtempmeta2.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta2.write(filepathtemp2);
                            filebftempmeta2.newLine();
                            filebftempmeta2.flush();
                            filebftempmeta2.close();
                           }
                           if(x!=null){
                            for(int i=2;i<5;i++){
                                s[i]=filebfrtempmeta2.readLine();
                            }
                            filebfrtempmeta2.close();
                            BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta2.write("");
                            filebftempmeta2.flush();
                            filebftempmeta2.close();
                            BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s[0]!=null){
                                filebfwtempmeta2.write(s[0]);
                                filebfwtempmeta2.newLine();
                            }
                            filebfwtempmeta2.write(filepathtemp2);
                            filebfwtempmeta2.newLine();
                            if(s[2]!=null){
                                filebfwtempmeta2.write(s[2]);
                                filebfwtempmeta2.newLine();
                            }
                            if(s[3]!=null){
                                filebfwtempmeta2.write(s[3]);
                                filebfwtempmeta2.newLine();
                            }
                            if(s[4]!=null){
                                filebfwtempmeta2.write(s[4]);
                                filebfwtempmeta2.newLine();
                            }
                            filebfwtempmeta2.flush();
                            filebfwtempmeta2.close();
                           }
                        }
                        catch(IOException exc){
   
                        }
                        file2save=true;
                      break;
                      case 3:
                        filetemp3=savedialog.getSelectedFile();
                        filenametemp3=filetemp3.getName();
                        filepathtemp3=filetemp3.getAbsolutePath();
                       String filecontenttemp3=codetarea.getText();
                       file3.setText(filenametemp3);
                       file3.setIcon(null);
                       file3.removeMouseListener(new Temp4());
                       file3.addMouseListener(new Temp5());
                       File f3_ext=filetemp3;
                       String name_for_ext_3=f3_ext.getName();
                       String ext_3="";
                       int dot_3=name_for_ext_3.lastIndexOf(".");
                       if(dot_3>0&dot_3<name_for_ext_3.length()-1){
                           ext_3=name_for_ext_3.substring(dot_3+1);
                       }
                       switch(ext_3){
                           case "orb":
                           fileteron_3=orb_exton;
                           fileion_3=orb_exton;
                            break;
                           case "java":
                           fileteron_3=icon_java_ext;
                           fileion_3=icon_java_ext;
                           break;
                         }
                      try{
                          if(!filetemp3.exists()){
                                  filetemp3.createNewFile();
                          }
                            BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                           filebftemp3.write(filecontenttemp3);
                           filebftemp3.flush();
                           filebftemp3.close();
                        String s[]=new String[5];
                           BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<2;i++){
                               s[i]=filebfrtempmeta3.readLine();
                           }
                           String x= filebfrtempmeta3.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta3.write(filepathtemp3);
                            filebftempmeta3.newLine();
                            filebftempmeta3.flush();
                            filebftempmeta3.close();
                           }
                           if(x!=null){
                            for(int i=3;i<5;i++){
                                s[i]=filebfrtempmeta3.readLine();
                            }
                            filebfrtempmeta3.close();
                            BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta3.write("");
                            filebftempmeta3.flush();
                            filebftempmeta3.close();
                            BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s[0]!=null){
                                filebfwtempmeta3.write(s[0]);
                                filebfwtempmeta3.newLine();
                            }
                            if(s[1]!=null){
                                filebfwtempmeta3.write(s[1]);
                                filebfwtempmeta3.newLine();
                            }
                            filebfwtempmeta3.write(filepathtemp3);
                            filebfwtempmeta3.newLine();
                            if(s[3]!=null){
                                filebfwtempmeta3.write(s[3]);
                                filebfwtempmeta3.newLine();
                            }
                            if(s[4]!=null){
                                filebfwtempmeta3.write(s[4]);
                                filebfwtempmeta3.newLine();
                            }
                            filebfwtempmeta3.flush();
                            filebfwtempmeta3.close();
                           }
                      }
                      catch(IOException exc){
   
                      }
                      file3save=true;
                      break;
                      case 4:
                      filetemp4=savedialog.getSelectedFile();
                      filenametemp4=filetemp4.getName();
                      filepathtemp4=filetemp4.getAbsolutePath();
                     String filecontenttemp4=codetarea.getText();
                     file4.setText(filenametemp4);
                     file4.setIcon(null);
                     file4.removeMouseListener(new Temp4());
                     file4.addMouseListener(new Temp5());
                     File f4_ext=filetemp4;
                     String name_for_ext_4=f4_ext.getName();
                     String ext_4="";
                     int dot_4=name_for_ext_4.lastIndexOf(".");
                     if(dot_4>0&dot_4<name_for_ext_4.length()-1){
                         ext_4=name_for_ext_4.substring(dot_4+1);
                     }
                     switch(ext_4){
                         case "orb":
                         fileteron_4=orb_exton;
                         fileion_4=orb_exton;
                          break;
                         case "java":
                         fileteron_4=icon_java_ext;
                         fileion_4=icon_java_ext;
                         break;
                       }
                    try{
                        if(!filetemp4.exists()){
                                filetemp4.createNewFile();
                        }
                          BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                         filebftemp4.write(filecontenttemp4);
                         filebftemp4.flush();
                         filebftemp4.close();
                         String s[]=new String[5];
                           BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<3;i++){
                               s[i]=filebfrtempmeta4.readLine();
                           }
                           String x= filebfrtempmeta4.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta4.write(filepathtemp4);
                            filebftempmeta4.newLine();
                            filebftempmeta4.flush();
                            filebftempmeta4.close();
                           }
                           if(x!=null){
                            for(int i=4;i<5;i++){
                                s[i]=filebfrtempmeta4.readLine();
                            }
                            filebfrtempmeta4.close();
                            BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta4.write("");
                            filebftempmeta4.flush();
                            filebftempmeta4.close();
                            BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s[0]!=null){
                                filebfwtempmeta4.write(s[0]);
                                filebfwtempmeta4.newLine();
                            }
                            if(s[1]!=null){
                                filebfwtempmeta4.write(s[1]);
                                filebfwtempmeta4.newLine();
                            }
                            if(s[2]!=null){
                                filebfwtempmeta4.write(s[2]);
                                filebfwtempmeta4.newLine();
                            }
                            filebfwtempmeta4.write(filepathtemp4);
                            filebfwtempmeta4.newLine();
                            if(s[4]!=null){
                                filebfwtempmeta4.write(s[4]);
                                filebfwtempmeta4.newLine();
                            }
                            filebfwtempmeta4.flush();
                            filebfwtempmeta4.close();
                        }
                    }
                    catch(IOException exc){
 
                    }
                    file4save=true;
                    break;
                    case 5:
                    filetemp5=savedialog.getSelectedFile();
                    filenametemp5=filetemp5.getName();
                    filepathtemp5=filetemp5.getAbsolutePath();
                   String filecontenttemp5=codetarea.getText();
                   file5.setText(filenametemp5);
                   file5.setIcon(null);
                   file5.removeMouseListener(new Temp4());
                   file5.addMouseListener(new Temp5());
                   File f5_ext=filetemp5;
                       String name_for_ext_5=f5_ext.getName();
                       String ext_5="";
                       int dot_5=name_for_ext_5.lastIndexOf(".");
                       if(dot_5>0&dot_5<name_for_ext_5.length()-1){
                           ext_5=name_for_ext_5.substring(dot_5+1);
                       }
                       switch(ext_5){
                           case "orb":
                           fileteron_5=orb_exton;
                           fileion_5=orb_exton;
                            break;
                           case "java":
                           fileteron_5=icon_java_ext;
                           fileion_5=icon_java_ext;
                           break;
                         }
                  try{
                      if(!filetemp5.exists()){
                              filetemp5.createNewFile();
                      }
                        BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                       filebftemp5.write(filecontenttemp5);
                       filebftemp5.flush();
                       filebftemp5.close();
                       String s[]=new String[5];
                           BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<4;i++){
                               s[i]=filebfrtempmeta5.readLine();
                           }
                           String x= filebfrtempmeta5.readLine();
                           filebfrtempmeta5.close();
                           if(x==null){
                            BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta5.write(filepathtemp5);
                            filebftempmeta5.newLine();
                            filebftempmeta5.flush();
                            filebftempmeta5.close();
                           }
                           if(x!=null){
                            BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta5.write("");
                            filebftempmeta5.flush();
                            filebftempmeta5.close();
                            BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s[0]!=null){
                                filebfwtempmeta5.write(s[0]);
                                filebfwtempmeta5.newLine();
                            }
                            if(s[1]!=null){
                                filebfwtempmeta5.write(s[1]);
                                filebfwtempmeta5.newLine();
                            }
                            if(s[2]!=null){
                                filebfwtempmeta5.write(s[2]);
                                filebfwtempmeta5.newLine();
                            }
                            if(s[3]!=null){
                                filebfwtempmeta5.write(s[3]);
                                filebfwtempmeta5.newLine();
                            }
                            filebfwtempmeta5.write(filepathtemp5);
                            filebfwtempmeta5.newLine();
                            filebfwtempmeta5.flush();
                            filebfwtempmeta5.close();
                        }
                    }
                  catch(IOException exc){

                  }
                  file5save=true;
                  break;
                    }
                    try{
                        BufferedWriter filesavemeta=new BufferedWriter(new FileWriter(filesavepathmeta));
                                String filesavetemp1=String.valueOf(file1save);
                                String filesavetemp2=String.valueOf(file2save);
                                String filesavetemp3=String.valueOf(file3save);
                                String filesavetemp4=String.valueOf(file4save);
                                String filesavetemp5=String.valueOf(file5save);
                                filesavemeta.write(filesavetemp1);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp2);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp3);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp4);
                                filesavemeta.newLine();
                                filesavemeta.write(filesavetemp5);
                                filesavemeta.flush();
                                filesavemeta.close();
                    }
                    catch(IOException exc){

                    }
                }
            }
        });
        save.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    BufferedReader filesavermeta=new BufferedReader(new FileReader(filesavepathmeta));
                file1save=Boolean.valueOf(filesavermeta.readLine());
                file2save=Boolean.valueOf(filesavermeta.readLine());
                file3save=Boolean.valueOf(filesavermeta.readLine());
                file4save=Boolean.valueOf(filesavermeta.readLine());
                file5save=Boolean.valueOf(filesavermeta.readLine());
                filesavermeta.close();
                }
                catch(IOException exc){
   
                }
                    String filecontenttemp=codetarea.getText();
                    try{
                       String s[]=new String[5];
                    BufferedReader meta=new BufferedReader(new FileReader(filepathmeta));
                    for(int i=0;i<5;i++){
                        s[i]=meta.readLine();
                    }
                    meta.close();
                    switch(fileselect){
                        case 1:
                        Boolean tempboolfile1=false;
                        file1.removeMouseListener(new Temp4());
                        file1.addMouseListener(new Temp5());
                        fcheck=new File(s[0]);
                        filetemp1=fcheck;
                        filepathtemp1=filetemp1.getAbsolutePath();
                       filenametemp1=filetemp1.getName();
                        if(fcheck.exists()==false&tempboolfile1==false){
                           JFileChooser savedialog=new JFileChooser();
                           int tempsave=savedialog.showSaveDialog(null);
                          if(tempsave==JFileChooser.APPROVE_OPTION){
                             filetemp1=savedialog.getSelectedFile();
                              filepathtemp1=filetemp1.getAbsolutePath();
                             filenametemp1=filetemp1.getName();
                             file1.setText(filenametemp1);
                             file1.setIcon(null);
                             File f1_ext=filetemp1;
                             String name_for_ext_1=f1_ext.getName();
                             String ext_1="";
                             int dot_1=name_for_ext_1.lastIndexOf(".");
                             if(dot_1>0&dot_1<name_for_ext_1.length()-1){
                                 ext_1=name_for_ext_1.substring(dot_1+1);
                             }
                             switch(ext_1){
                                 case "orb":
                                 fileteron_1=orb_exton;
                                 fileion_1=orb_exton;
                                  break;
                                 case "java":
                                 fileteron_1=icon_java_ext;
                                 fileion_1=icon_java_ext;
                                 break;
                               }
                             tempboolfile1=true;
                             BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                             filebftemp1.write(filecontenttemp);
                             filebftemp1.flush();
                             filebftemp1.close();
                        }
                    }
                        if(fcheck.exists()==true&tempboolfile1==false&(fcheck.getName().equals(file1.getText()))){
                            tempboolfile1=true;
                            filetemp1=fcheck;
                            filepathtemp1=filetemp1.getAbsolutePath();
                           filenametemp1=filetemp1.getName();
                           String filecontenttemp1=codetarea.getText();
                           file1.setText(filenametemp1);
                           file1.setIcon(null);
                           file1.removeMouseListener(new Temp4());
                           file1.addMouseListener(new Temp5());
                          try{
                                BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                               filebftemp1.write(filecontenttemp1);
                               filebftemp1.flush();
                               filebftemp1.close();
                        }
                          catch(IOException exc){
       
                          }
                        }
                        try{
                            String s_1[]=new String[5];
                            BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                            String x= filebfrtempmeta1.readLine();
                            if(x==null){
                             BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                             filebftempmeta1.write(filepathtemp1);
                             filebftempmeta1.newLine();
                             filebftempmeta1.flush();
                             filebftempmeta1.close();
                            }
                            if(x!=null){
                             for(int i=1;i<5;i++){
                                 s_1[i]=filebfrtempmeta1.readLine();
                             }
                             filebfrtempmeta1.close();
                             BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                             filebftempmeta1.write("");
                             filebftempmeta1.flush();
                             filebftempmeta1.close();
                             BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                             filebfwtempmeta1.write(filepathtemp1);
                             filebfwtempmeta1.newLine();
                             if(s_1[1]!=null){
                                 filebfwtempmeta1.write(s_1[1]);
                                 filebfwtempmeta1.newLine();
                             }
                             if(s_1[2]!=null){
                                 filebfwtempmeta1.write(s_1[2]);
                                 filebfwtempmeta1.newLine();
                             }
                             if(s_1[3]!=null){
                                 filebfwtempmeta1.write(s_1[3]);
                                 filebfwtempmeta1.newLine();
                             }
                             if(s_1[4]!=null){
                                 filebfwtempmeta1.write(s_1[4]);
                                 filebfwtempmeta1.newLine();
                             }
                             filebfwtempmeta1.flush();
                             filebfwtempmeta1.close();
                         }
                        }
                        catch(IOException exc){
       
                        }
                        file1save=true;
                        break;
                     case 2:
                     Boolean tempboolfile2=false;
                     file2.removeMouseListener(new Temp4());
                      file2.addMouseListener(new Temp5());
                     fcheck=new File(s[1]);
                     filetemp2=fcheck;
                        filepathtemp2=filetemp2.getAbsolutePath();
                       filenametemp2=filetemp2.getName();
                     if((fcheck.exists()==false||file2isnew==true)&tempboolfile2==false){
                        JFileChooser savedialog=new JFileChooser();
                        int tempsave=savedialog.showSaveDialog(null);
                       if(tempsave==JFileChooser.APPROVE_OPTION){
                          filetemp2=savedialog.getSelectedFile();
                           filepathtemp2=filetemp2.getAbsolutePath();
                          filenametemp2=filetemp2.getName();
                          file2.setText(filenametemp2);
                          file2.setIcon(null);
                          File f2_ext=filetemp2;
                          String name_for_ext_2=f2_ext.getName();
                          String ext_2="";
                          int dot_2=name_for_ext_2.lastIndexOf(".");
                          if(dot_2>0&dot_2<name_for_ext_2.length()-1){
                              ext_2=name_for_ext_2.substring(dot_2+1);
                          }
                          switch(ext_2){
                              case "orb":
                              fileteron_2=orb_exton;
                              fileion_2=orb_exton;
                               break;
                              case "java":
                              fileteron_2=icon_java_ext;
                              fileion_2=icon_java_ext;
                              break;
                            }
                          tempboolfile2=true;
                          BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                          filebftemp2.write(filecontenttemp);
                          filebftemp2.flush();
                          filebftemp2.close();
                          file2isnew=false;
                     }
                 }
                     if(fcheck.exists()==true&tempboolfile2==false&(fcheck.getName().equals(file2.getText()))){
                        tempboolfile2=true;
                        filetemp2=fcheck;
                        filepathtemp2=filetemp2.getAbsolutePath();
                       filenametemp2=filetemp2.getName();
                        String filecontenttemp2=codetarea.getText();
                        file2.setText(filenametemp2);
                        file2.setIcon(null);
                        file2.removeMouseListener(new Temp4());
                         file2.addMouseListener(new Temp5());
                       try{
                             BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                            filebftemp2.write(filecontenttemp2);
                            filebftemp2.flush();
                            filebftemp2.close();
                         }
                         catch(IOException exc){
    
                         }
                     }
                     try{
                        String s_2[]=new String[5];
                        BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                        for(int i=0;i<1;i++){
                            s_2[i]=filebfrtempmeta2.readLine();
                        }
                        String x= filebfrtempmeta2.readLine();
                        if(x==null){
                         BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                         filebftempmeta2.write(filepathtemp2);
                         filebftempmeta2.newLine();
                         filebftempmeta2.flush();
                         filebftempmeta2.close();
                        }
                        if(x!=null){
                         for(int i=2;i<5;i++){
                             s_2[i]=filebfrtempmeta2.readLine();
                         } 
                          filebfrtempmeta2.close();
                         BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                         filebftempmeta2.write("");
                         filebftempmeta2.flush();
                         filebftempmeta2.close();
                         BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                         if(s_2[0]!=null){
                             filebfwtempmeta2.write(s_2[0]);
                             filebfwtempmeta2.newLine();
                         }
                         filebfwtempmeta2.write(filepathtemp2);
                         filebfwtempmeta2.newLine();
                         if(s_2[2]!=null){
                             filebfwtempmeta2.write(s_2[2]);
                             filebfwtempmeta2.newLine();
                         }
                         if(s_2[3]!=null){
                             filebfwtempmeta2.write(s_2[3]);
                             filebfwtempmeta2.newLine();
                         }
                         if(s_2[4]!=null){
                             filebfwtempmeta2.write(s_2[4]);
                             filebfwtempmeta2.newLine();
                         }
                         filebfwtempmeta2.flush();
                         filebfwtempmeta2.close();
                        }
                     }
                     catch(IOException exc){
    
                    }
                    file2save=true;
                     break;
                     case 3:
                      Boolean tempboolfile3=false;
                      file3.removeMouseListener(new Temp4());
                    file3.addMouseListener(new Temp5());
                     fcheck=new File(s[2]);
                     filetemp3=fcheck;
                     filenametemp3=filetemp3.getName();
                     filepathtemp3=filetemp3.getAbsolutePath();
                        if((fcheck.exists()==false||file3isnew==true)&tempboolfile3==false){
                           JFileChooser savedialog=new JFileChooser();
                           int tempsave=savedialog.showSaveDialog(null);
                          if(tempsave==JFileChooser.APPROVE_OPTION){
                             filetemp3=savedialog.getSelectedFile();
                              filepathtemp3=filetemp3.getAbsolutePath();
                             filenametemp3=filetemp3.getName();
                             file3.setText(filenametemp3);
                             file3.setIcon(null);
                             File f3_ext=filetemp3;
                             String name_for_ext_3=f3_ext.getName();
                             String ext_3="";
                             int dot_3=name_for_ext_3.lastIndexOf(".");
                             if(dot_3>0&dot_3<name_for_ext_3.length()-1){
                                 ext_3=name_for_ext_3.substring(dot_3+1);
                             }
                             switch(ext_3){
                                 case "orb":
                                 fileteron_3=orb_exton;
                                 fileion_3=orb_exton;
                                  break;
                                 case "java":
                                 fileteron_3=icon_java_ext;
                                 fileion_3=icon_java_ext;
                                 break;
                               }
                             tempboolfile3=true;
                             BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                             filebftemp3.write(filecontenttemp);
                             filebftemp3.flush();
                             filebftemp3.close();
                             file3isnew=false;
                        }
                    }
                        if(fcheck.exists()==true&tempboolfile3==false&(fcheck.getName().equals(file3.getText()))){
                            tempboolfile3=true;
                            filetemp3=fcheck;
                        filenametemp3=filetemp3.getName();
                        filepathtemp3=filetemp3.getAbsolutePath();
                       String filecontenttemp3=codetarea.getText();
                       file3.setText(filenametemp3);
                       file3.setIcon(null);
                       file3.removeMouseListener(new Temp4());
                       file3.addMouseListener(new Temp5());
                      try{
                            BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                           filebftemp3.write(filecontenttemp3);
                           filebftemp3.flush();
                           filebftemp3.close();
                      }
                      catch(IOException exc){
   
                      }
                        }
                        try{
                            String s_3[]=new String[5];
                           BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<2;i++){
                               s_3[i]=filebfrtempmeta3.readLine();
                           }
                           String x= filebfrtempmeta3.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta3.write(filepathtemp3);
                            filebftempmeta3.newLine();
                            filebftempmeta3.flush();
                            filebftempmeta3.close();
                           }
                           if(x!=null){
                            for(int i=3;i<5;i++){
                                s_3[i]=filebfrtempmeta3.readLine();
                            }
                            filebfrtempmeta3.close();
                            BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta3.write("");
                            filebftempmeta3.flush();
                            filebftempmeta3.close();
                            BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s_3[0]!=null){
                                filebfwtempmeta3.write(s_3[0]);
                                filebfwtempmeta3.newLine();
                            }
                            if(s_3[1]!=null){
                                filebfwtempmeta3.write(s_3[1]);
                                filebfwtempmeta3.newLine();
                            }
                            filebfwtempmeta3.write(filepathtemp3);
                            filebfwtempmeta3.newLine();
                            if(s_3[3]!=null){
                                filebfwtempmeta3.write(s_3[3]);
                                filebfwtempmeta3.newLine();
                            }
                            if(s_3[4]!=null){
                                filebfwtempmeta3.write(s_3[4]);
                                filebfwtempmeta3.newLine();
                            }
                            filebfwtempmeta3.flush();
                            filebfwtempmeta3.close();
                           }
                        }
                        catch(IOException exc){
   
                        }
                        file3save=true;
                        break;
                        case 4:
                        Boolean tempboolfile4=false;
                        file4.removeMouseListener(new Temp4());
                        file4.addMouseListener(new Temp5());
                        fcheck=new File(s[3]);
                        filetemp4=fcheck;
                            filepathtemp4=filetemp4.getAbsolutePath();
                           filenametemp4=filetemp4.getName();
                        if((fcheck.exists()==false||file4isnew==true)&tempboolfile4==false){
                           JFileChooser savedialog=new JFileChooser();
                           int tempsave=savedialog.showSaveDialog(null);
                          if(tempsave==JFileChooser.APPROVE_OPTION){
                             filetemp4=savedialog.getSelectedFile();
                              filepathtemp4=filetemp4.getAbsolutePath();
                             filenametemp4=filetemp4.getName();
                             file4.setText(filenametemp4);
                             file4.setIcon(null);
                             File f4_ext=filetemp4;
                             String name_for_ext_4=f4_ext.getName();
                             String ext_4="";
                             int dot_4=name_for_ext_4.lastIndexOf(".");
                             if(dot_4>0&dot_4<name_for_ext_4.length()-1){
                                 ext_4=name_for_ext_4.substring(dot_4+1);
                             }
                             switch(ext_4){
                                 case "orb":
                                 fileteron_4=orb_exton;
                                 fileion_4=orb_exton;
                                  break;
                                 case "java":
                                 fileteron_4=icon_java_ext;
                                 fileion_4=icon_java_ext;
                                 break;
                               }
                             tempboolfile4=true;
                             BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                             filebftemp4.write(filecontenttemp);
                             filebftemp4.flush();
                             filebftemp4.close();
                             file4isnew=false;
                        }
                    }
                        if(fcheck.exists()==true&tempboolfile4==false&(fcheck.getName().equals(file4.getText()))){
                            tempboolfile4=true;
                            filetemp4=fcheck;
                            filepathtemp4=filetemp4.getAbsolutePath();
                           filenametemp4=filetemp4.getName();
                     String filecontenttemp4=codetarea.getText();
                     file4.setText(filenametemp4);
                     file4.setIcon(null);
                     file4.removeMouseListener(new Temp4());
                     file4.addMouseListener(new Temp5());
                    try{
                          BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                         filebftemp4.write(filecontenttemp4);
                         filebftemp4.flush();
                         filebftemp4.close();
                    }
                    catch(IOException exc){
 
                    }
                        }
                        try{
                            String s_4[]=new String[5];
                            BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                            for(int i=0;i<3;i++){
                                s_4[i]=filebfrtempmeta4.readLine();
                            }
                            String x= filebfrtempmeta4.readLine();
                            if(x==null){
                             BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                             filebftempmeta4.write(filepathtemp4);
                             filebftempmeta4.newLine();
                             filebftempmeta4.flush();
                             filebftempmeta4.close();
                            }
                            if(x!=null){
                             for(int i=4;i<5;i++){
                                 s_4[i]=filebfrtempmeta4.readLine();
                             }
                             filebfrtempmeta4.close();
                             BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                             filebftempmeta4.write("");
                             filebftempmeta4.flush();
                             filebftempmeta4.close();
                             BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                             if(s_4[0]!=null){
                                 filebfwtempmeta4.write(s_4[0]);
                                 filebfwtempmeta4.newLine();
                             }
                             if(s_4[1]!=null){
                                 filebfwtempmeta4.write(s_4[1]);
                                 filebfwtempmeta4.newLine();
                             }
                             if(s_4[2]!=null){
                                 filebfwtempmeta4.write(s_4[2]);
                                 filebfwtempmeta4.newLine();
                             }
                             filebfwtempmeta4.write(filepathtemp4);
                             filebfwtempmeta4.newLine();
                             if(s_4[4]!=null){
                                 filebfwtempmeta4.write(s_4[4]);
                                 filebfwtempmeta4.newLine();
                             }
                             filebfwtempmeta4.flush();
                             filebfwtempmeta4.close();
                         }
                        }
                        catch(IOException exc){
 
                        }
                        file4save=true;
                        break;
                        case 5:
                        Boolean tempboolfile5=false;
                        file5.removeMouseListener(new Temp4());
                        file5.addMouseListener(new Temp5());
                        fcheck=new File(s[4]);
                        filetemp5=fcheck;
                        filepathtemp5=filetemp5.getAbsolutePath();
                       filenametemp5=filetemp5.getName();
                        if((fcheck.exists()==false||file5isnew==true)&tempboolfile5==false){
                           JFileChooser savedialog=new JFileChooser();
                           int tempsave=savedialog.showSaveDialog(null);
                          if(tempsave==JFileChooser.APPROVE_OPTION){
                             filetemp5=savedialog.getSelectedFile();
                              filepathtemp5=filetemp5.getAbsolutePath();
                             filenametemp5=filetemp5.getName();
                             file5.setText(filenametemp5);
                             file5.setIcon(null);
                             File f5_ext=filetemp5;
                             String name_for_ext_5=f5_ext.getName();
                             String ext_5="";
                             int dot_5=name_for_ext_5.lastIndexOf(".");
                             if(dot_5>0&dot_5<name_for_ext_5.length()-1){
                                 ext_5=name_for_ext_5.substring(dot_5+1);
                             }
                             switch(ext_5){
                                 case "orb":
                                 fileteron_5=orb_exton;
                                 fileion_5=orb_exton;
                                  break;
                                 case "java":
                                 fileteron_5=icon_java_ext;
                                 fileion_5=icon_java_ext;
                                 break;
                               }
                             tempboolfile5=true;
                             BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                             filebftemp5.write(filecontenttemp);
                             filebftemp5.flush();
                             filebftemp5.close();
                             file5isnew=false;
                        }
                    }
                        if(fcheck.exists()==true&tempboolfile5==false&(fcheck.getName().equals(file5.getText()))){
                            tempboolfile5=true;
                            filetemp5=fcheck;
                            filepathtemp5=filetemp5.getAbsolutePath();
                           filenametemp5=filetemp5.getName();
                            String filecontenttemp5=codetarea.getText();
                            file5.setText(filenametemp5);
                            file5.setIcon(null);
                            file5.removeMouseListener(new Temp4());
                            file5.addMouseListener(new Temp5());
                           try{
                                 BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                                filebftemp5.write(filecontenttemp5);
                                filebftemp5.flush();
                                filebftemp5.close();
                             }
                           catch(IOException exc){
         
                           }
                        }
                        try{
                            String s_5[]=new String[5];
                                    BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                                    for(int i=0;i<4;i++){
                                        s_5[i]=filebfrtempmeta5.readLine();
                                    }
                                    String x= filebfrtempmeta5.readLine();
                                    filebfrtempmeta5.close();
                                    if(x==null){
                                     BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                                     filebftempmeta5.write(filepathtemp5);
                                     filebftempmeta5.newLine();
                                     filebftempmeta5.flush();
                                     filebftempmeta5.close();
                                    }
                                    if(x!=null){
                                     BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                                     filebftempmeta5.write("");
                                     filebftempmeta5.flush();
                                     filebftempmeta5.close();
                                     BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                                     if(s_5[0]!=null){
                                         filebfwtempmeta5.write(s_5[0]);
                                         filebfwtempmeta5.newLine();
                                     }
                                     if(s_5[1]!=null){
                                         filebfwtempmeta5.write(s_5[1]);
                                         filebfwtempmeta5.newLine();
                                     }
                                     if(s_5[2]!=null){
                                         filebfwtempmeta5.write(s_5[2]);
                                         filebfwtempmeta5.newLine();
                                     }
                                     if(s_5[3]!=null){
                                         filebfwtempmeta5.write(s_5[3]);
                                         filebfwtempmeta5.newLine();
                                     }
                                     filebfwtempmeta5.write(filepathtemp5);
                                     filebfwtempmeta5.newLine();
                                     filebfwtempmeta5.flush();
                                     filebfwtempmeta5.close();
                                 }
                        }
                        catch(IOException exc){

                        }
                        file5save=true;
                        break;
                        }
                     }
                   catch(IOException exc){

                   }
                   try{
                    BufferedWriter filesavemeta=new BufferedWriter(new FileWriter(filesavepathmeta));
                            String filesavetemp1=String.valueOf(file1save);
                            String filesavetemp2=String.valueOf(file2save);
                            String filesavetemp3=String.valueOf(file3save);
                            String filesavetemp4=String.valueOf(file4save);
                            String filesavetemp5=String.valueOf(file5save);
                            filesavemeta.write(filesavetemp1);
                            filesavemeta.newLine();
                            filesavemeta.write(filesavetemp2);
                            filesavemeta.newLine();
                            filesavemeta.write(filesavetemp3);
                            filesavemeta.newLine();
                            filesavemeta.write(filesavetemp4);
                            filesavemeta.newLine();
                            filesavemeta.write(filesavetemp5);
                            filesavemeta.flush();
                            filesavemeta.close();
                }
                catch(IOException exc){

                }
            }
        });
        arrsave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    BufferedReader filesavermeta=new BufferedReader(new FileReader(filesavepathmeta));
                file1save=Boolean.valueOf(filesavermeta.readLine());
                file2save=Boolean.valueOf(filesavermeta.readLine());
                file3save=Boolean.valueOf(filesavermeta.readLine());
                file4save=Boolean.valueOf(filesavermeta.readLine());
                file5save=Boolean.valueOf(filesavermeta.readLine());
                filesavermeta.close();
                }
                catch(IOException exc){
   
                }
                    String filecontenttemp=codetarea.getText();
                    try{
                       String s[]=new String[5];
                    BufferedReader meta=new BufferedReader(new FileReader(filepathmeta));
                    for(int i=0;i<5;i++){
                        s[i]=meta.readLine();
                    }
                    meta.close();
                    switch(fileselect){
                        case 1:
                        Boolean tempboolfile1=false;
                        file1.removeMouseListener(new Temp4());
                        file1.addMouseListener(new Temp5());
                        fcheck=new File(s[0]);
                        filetemp1=fcheck;
                        filepathtemp1=filetemp1.getAbsolutePath();
                       filenametemp1=filetemp1.getName();
                        if(fcheck.exists()==false&tempboolfile1==false){
                           JFileChooser savedialog=new JFileChooser();
                           int tempsave=savedialog.showSaveDialog(null);
                          if(tempsave==JFileChooser.APPROVE_OPTION){
                             filetemp1=savedialog.getSelectedFile();
                              filepathtemp1=filetemp1.getAbsolutePath();
                             filenametemp1=filetemp1.getName();
                             file1.setText(filenametemp1);
                             file1.setIcon(null);
                             File f1_ext=filetemp1;
                             String name_for_ext_1=f1_ext.getName();
                             String ext_1="";
                             int dot_1=name_for_ext_1.lastIndexOf(".");
                             if(dot_1>0&dot_1<name_for_ext_1.length()-1){
                                 ext_1=name_for_ext_1.substring(dot_1+1);
                             }
                             switch(ext_1){
                                 case "orb":
                                 fileteron_1=orb_exton;
                                 fileion_1=orb_exton;
                                  break;
                                 case "java":
                                 fileteron_1=icon_java_ext;
                                 fileion_1=icon_java_ext;
                                 break;
                               }
                             tempboolfile1=true;
                             BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                             filebftemp1.write(filecontenttemp);
                             filebftemp1.flush();
                             filebftemp1.close();
                        }
                    }
                        if(fcheck.exists()==true&tempboolfile1==false&(fcheck.getName().equals(file1.getText()))){
                            tempboolfile1=true;
                            filetemp1=fcheck;
                            filepathtemp1=filetemp1.getAbsolutePath();
                           filenametemp1=filetemp1.getName();
                           String filecontenttemp1=codetarea.getText();
                           file1.setText(filenametemp1);
                           file1.setIcon(null);
                           file1.removeMouseListener(new Temp4());
                           file1.addMouseListener(new Temp5());
                          try{
                                BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                               filebftemp1.write(filecontenttemp1);
                               filebftemp1.flush();
                               filebftemp1.close();
                        }
                          catch(IOException exc){
       
                          }
                        }
                        try{
                            String s_1[]=new String[5];
                            BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                            String x= filebfrtempmeta1.readLine();
                            if(x==null){
                             BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                             filebftempmeta1.write(filepathtemp1);
                             filebftempmeta1.newLine();
                             filebftempmeta1.flush();
                             filebftempmeta1.close();
                            }
                            if(x!=null){
                             for(int i=1;i<5;i++){
                                 s_1[i]=filebfrtempmeta1.readLine();
                             }
                             filebfrtempmeta1.close();
                             BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                             filebftempmeta1.write("");
                             filebftempmeta1.flush();
                             filebftempmeta1.close();
                             BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                             filebfwtempmeta1.write(filepathtemp1);
                             filebfwtempmeta1.newLine();
                             if(s_1[1]!=null){
                                 filebfwtempmeta1.write(s_1[1]);
                                 filebfwtempmeta1.newLine();
                             }
                             if(s_1[2]!=null){
                                 filebfwtempmeta1.write(s_1[2]);
                                 filebfwtempmeta1.newLine();
                             }
                             if(s_1[3]!=null){
                                 filebfwtempmeta1.write(s_1[3]);
                                 filebfwtempmeta1.newLine();
                             }
                             if(s_1[4]!=null){
                                 filebfwtempmeta1.write(s_1[4]);
                                 filebfwtempmeta1.newLine();
                             }
                             filebfwtempmeta1.flush();
                             filebfwtempmeta1.close();
                         }
                        }
                        catch(IOException exc){
       
                        }
                        file1save=true;
                        break;
                     case 2:
                     Boolean tempboolfile2=false;
                     file2.removeMouseListener(new Temp4());
                      file2.addMouseListener(new Temp5());
                     fcheck=new File(s[1]);
                     filetemp2=fcheck;
                        filepathtemp2=filetemp2.getAbsolutePath();
                       filenametemp2=filetemp2.getName();
                     if((fcheck.exists()==false||file2isnew==true)&tempboolfile2==false){
                        JFileChooser savedialog=new JFileChooser();
                        int tempsave=savedialog.showSaveDialog(null);
                       if(tempsave==JFileChooser.APPROVE_OPTION){
                          filetemp2=savedialog.getSelectedFile();
                           filepathtemp2=filetemp2.getAbsolutePath();
                          filenametemp2=filetemp2.getName();
                          file2.setText(filenametemp2);
                          file2.setIcon(null);
                          File f2_ext=filetemp2;
                          String name_for_ext_2=f2_ext.getName();
                          String ext_2="";
                          int dot_2=name_for_ext_2.lastIndexOf(".");
                          if(dot_2>0&dot_2<name_for_ext_2.length()-1){
                              ext_2=name_for_ext_2.substring(dot_2+1);
                          }
                          switch(ext_2){
                              case "orb":
                              fileteron_2=orb_exton;
                              fileion_2=orb_exton;
                               break;
                              case "java":
                              fileteron_2=icon_java_ext;
                              fileion_2=icon_java_ext;
                              break;
                            }
                          tempboolfile2=true;
                          BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                          filebftemp2.write(filecontenttemp);
                          filebftemp2.flush();
                          filebftemp2.close();
                          file2isnew=false;
                     }
                 }
                     if(fcheck.exists()==true&tempboolfile2==false&(fcheck.getName().equals(file2.getText()))){
                        tempboolfile2=true;
                        filetemp2=fcheck;
                        filepathtemp2=filetemp2.getAbsolutePath();
                       filenametemp2=filetemp2.getName();
                        String filecontenttemp2=codetarea.getText();
                        file2.setText(filenametemp2);
                        file2.setIcon(null);
                        file2.removeMouseListener(new Temp4());
                         file2.addMouseListener(new Temp5());
                       try{
                             BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                            filebftemp2.write(filecontenttemp2);
                            filebftemp2.flush();
                            filebftemp2.close();
                         }
                         catch(IOException exc){
    
                         }
                     }
                     try{
                        String s_2[]=new String[5];
                        BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                        for(int i=0;i<1;i++){
                            s_2[i]=filebfrtempmeta2.readLine();
                        }
                        String x= filebfrtempmeta2.readLine();
                        if(x==null){
                         BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                         filebftempmeta2.write(filepathtemp2);
                         filebftempmeta2.newLine();
                         filebftempmeta2.flush();
                         filebftempmeta2.close();
                        }
                        if(x!=null){
                         for(int i=2;i<5;i++){
                             s_2[i]=filebfrtempmeta2.readLine();
                         } 
                          filebfrtempmeta2.close();
                         BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                         filebftempmeta2.write("");
                         filebftempmeta2.flush();
                         filebftempmeta2.close();
                         BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                         if(s_2[0]!=null){
                             filebfwtempmeta2.write(s_2[0]);
                             filebfwtempmeta2.newLine();
                         }
                         filebfwtempmeta2.write(filepathtemp2);
                         filebfwtempmeta2.newLine();
                         if(s_2[2]!=null){
                             filebfwtempmeta2.write(s_2[2]);
                             filebfwtempmeta2.newLine();
                         }
                         if(s_2[3]!=null){
                             filebfwtempmeta2.write(s_2[3]);
                             filebfwtempmeta2.newLine();
                         }
                         if(s_2[4]!=null){
                             filebfwtempmeta2.write(s_2[4]);
                             filebfwtempmeta2.newLine();
                         }
                         filebfwtempmeta2.flush();
                         filebfwtempmeta2.close();
                        }
                     }
                     catch(IOException exc){
    
                    }
                    file2save=true;
                     break;
                     case 3:
                      Boolean tempboolfile3=false;
                      file3.removeMouseListener(new Temp4());
                    file3.addMouseListener(new Temp5());
                     fcheck=new File(s[2]);
                     filetemp3=fcheck;
                     filenametemp3=filetemp3.getName();
                     filepathtemp3=filetemp3.getAbsolutePath();
                        if((fcheck.exists()==false||file3isnew==true)&tempboolfile3==false){
                           JFileChooser savedialog=new JFileChooser();
                           int tempsave=savedialog.showSaveDialog(null);
                          if(tempsave==JFileChooser.APPROVE_OPTION){
                             filetemp3=savedialog.getSelectedFile();
                              filepathtemp3=filetemp3.getAbsolutePath();
                             filenametemp3=filetemp3.getName();
                             file3.setText(filenametemp3);
                             file3.setIcon(null);
                             File f3_ext=filetemp3;
                             String name_for_ext_3=f3_ext.getName();
                             String ext_3="";
                             int dot_3=name_for_ext_3.lastIndexOf(".");
                             if(dot_3>0&dot_3<name_for_ext_3.length()-1){
                                 ext_3=name_for_ext_3.substring(dot_3+1);
                             }
                             switch(ext_3){
                                 case "orb":
                                 fileteron_3=orb_exton;
                                 fileion_3=orb_exton;
                                  break;
                                 case "java":
                                 fileteron_3=icon_java_ext;
                                 fileion_3=icon_java_ext;
                                 break;
                               }
                             tempboolfile3=true;
                             BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                             filebftemp3.write(filecontenttemp);
                             filebftemp3.flush();
                             filebftemp3.close();
                             file3isnew=false;
                        }
                    }
                        if(fcheck.exists()==true&tempboolfile3==false&(fcheck.getName().equals(file3.getText()))){
                            tempboolfile3=true;
                            filetemp3=fcheck;
                        filenametemp3=filetemp3.getName();
                        filepathtemp3=filetemp3.getAbsolutePath();
                       String filecontenttemp3=codetarea.getText();
                       file3.setText(filenametemp3);
                       file3.setIcon(null);
                       file3.removeMouseListener(new Temp4());
                       file3.addMouseListener(new Temp5());
                      try{
                            BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                           filebftemp3.write(filecontenttemp3);
                           filebftemp3.flush();
                           filebftemp3.close();
                      }
                      catch(IOException exc){
   
                      }
                        }
                        try{
                            String s_3[]=new String[5];
                           BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                           for(int i=0;i<2;i++){
                               s_3[i]=filebfrtempmeta3.readLine();
                           }
                           String x= filebfrtempmeta3.readLine();
                           if(x==null){
                            BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                            filebftempmeta3.write(filepathtemp3);
                            filebftempmeta3.newLine();
                            filebftempmeta3.flush();
                            filebftempmeta3.close();
                           }
                           if(x!=null){
                            for(int i=3;i<5;i++){
                                s_3[i]=filebfrtempmeta3.readLine();
                            }
                            filebfrtempmeta3.close();
                            BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                            filebftempmeta3.write("");
                            filebftempmeta3.flush();
                            filebftempmeta3.close();
                            BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                            if(s_3[0]!=null){
                                filebfwtempmeta3.write(s_3[0]);
                                filebfwtempmeta3.newLine();
                            }
                            if(s_3[1]!=null){
                                filebfwtempmeta3.write(s_3[1]);
                                filebfwtempmeta3.newLine();
                            }
                            filebfwtempmeta3.write(filepathtemp3);
                            filebfwtempmeta3.newLine();
                            if(s_3[3]!=null){
                                filebfwtempmeta3.write(s_3[3]);
                                filebfwtempmeta3.newLine();
                            }
                            if(s_3[4]!=null){
                                filebfwtempmeta3.write(s_3[4]);
                                filebfwtempmeta3.newLine();
                            }
                            filebfwtempmeta3.flush();
                            filebfwtempmeta3.close();
                           }
                        }
                        catch(IOException exc){
   
                        }
                        file3save=true;
                        break;
                        case 4:
                        Boolean tempboolfile4=false;
                        file4.removeMouseListener(new Temp4());
                        file4.addMouseListener(new Temp5());
                        fcheck=new File(s[3]);
                        filetemp4=fcheck;
                            filepathtemp4=filetemp4.getAbsolutePath();
                           filenametemp4=filetemp4.getName();
                        if((fcheck.exists()==false||file4isnew==true)&tempboolfile4==false){
                           JFileChooser savedialog=new JFileChooser();
                           int tempsave=savedialog.showSaveDialog(null);
                          if(tempsave==JFileChooser.APPROVE_OPTION){
                             filetemp4=savedialog.getSelectedFile();
                              filepathtemp4=filetemp4.getAbsolutePath();
                             filenametemp4=filetemp4.getName();
                             file4.setText(filenametemp4);
                             file4.setIcon(null);
                             File f4_ext=filetemp4;
                             String name_for_ext_4=f4_ext.getName();
                             String ext_4="";
                             int dot_4=name_for_ext_4.lastIndexOf(".");
                             if(dot_4>0&dot_4<name_for_ext_4.length()-1){
                                 ext_4=name_for_ext_4.substring(dot_4+1);
                             }
                             switch(ext_4){
                                 case "orb":
                                 fileteron_4=orb_exton;
                                 fileion_4=orb_exton;
                                  break;
                                 case "java":
                                 fileteron_4=icon_java_ext;
                                 fileion_4=icon_java_ext;
                                 break;
                               }
                             tempboolfile4=true;
                             BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                             filebftemp4.write(filecontenttemp);
                             filebftemp4.flush();
                             filebftemp4.close();
                             file4isnew=false;
                        }
                    }
                        if(fcheck.exists()==true&tempboolfile4==false&(fcheck.getName().equals(file4.getText()))){
                            tempboolfile4=true;
                            filetemp4=fcheck;
                            filepathtemp4=filetemp4.getAbsolutePath();
                           filenametemp4=filetemp4.getName();
                     String filecontenttemp4=codetarea.getText();
                     file4.setText(filenametemp4);
                     file4.setIcon(null);
                     file4.removeMouseListener(new Temp4());
                     file4.addMouseListener(new Temp5());
                    try{
                          BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                         filebftemp4.write(filecontenttemp4);
                         filebftemp4.flush();
                         filebftemp4.close();
                    }
                    catch(IOException exc){
 
                    }
                        }
                        try{
                            String s_4[]=new String[5];
                            BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                            for(int i=0;i<3;i++){
                                s_4[i]=filebfrtempmeta4.readLine();
                            }
                            String x= filebfrtempmeta4.readLine();
                            if(x==null){
                             BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                             filebftempmeta4.write(filepathtemp4);
                             filebftempmeta4.newLine();
                             filebftempmeta4.flush();
                             filebftempmeta4.close();
                            }
                            if(x!=null){
                             for(int i=4;i<5;i++){
                                 s_4[i]=filebfrtempmeta4.readLine();
                             }
                             filebfrtempmeta4.close();
                             BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                             filebftempmeta4.write("");
                             filebftempmeta4.flush();
                             filebftempmeta4.close();
                             BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                             if(s_4[0]!=null){
                                 filebfwtempmeta4.write(s_4[0]);
                                 filebfwtempmeta4.newLine();
                             }
                             if(s_4[1]!=null){
                                 filebfwtempmeta4.write(s_4[1]);
                                 filebfwtempmeta4.newLine();
                             }
                             if(s_4[2]!=null){
                                 filebfwtempmeta4.write(s_4[2]);
                                 filebfwtempmeta4.newLine();
                             }
                             filebfwtempmeta4.write(filepathtemp4);
                             filebfwtempmeta4.newLine();
                             if(s_4[4]!=null){
                                 filebfwtempmeta4.write(s_4[4]);
                                 filebfwtempmeta4.newLine();
                             }
                             filebfwtempmeta4.flush();
                             filebfwtempmeta4.close();
                         }
                        }
                        catch(IOException exc){
 
                        }
                        file4save=true;
                        break;
                        case 5:
                        Boolean tempboolfile5=false;
                        file5.removeMouseListener(new Temp4());
                        file5.addMouseListener(new Temp5());
                        fcheck=new File(s[4]);
                        filetemp5=fcheck;
                        filepathtemp5=filetemp5.getAbsolutePath();
                       filenametemp5=filetemp5.getName();
                        if((fcheck.exists()==false||file5isnew==true)&tempboolfile5==false){
                           JFileChooser savedialog=new JFileChooser();
                           int tempsave=savedialog.showSaveDialog(null);
                          if(tempsave==JFileChooser.APPROVE_OPTION){
                             filetemp5=savedialog.getSelectedFile();
                              filepathtemp5=filetemp5.getAbsolutePath();
                             filenametemp5=filetemp5.getName();
                             file5.setText(filenametemp5);
                             file5.setIcon(null);
                             File f5_ext=filetemp5;
                             String name_for_ext_5=f5_ext.getName();
                             String ext_5="";
                             int dot_5=name_for_ext_5.lastIndexOf(".");
                             if(dot_5>0&dot_5<name_for_ext_5.length()-1){
                                 ext_5=name_for_ext_5.substring(dot_5+1);
                             }
                             switch(ext_5){
                                 case "orb":
                                 fileteron_5=orb_exton;
                                 fileion_5=orb_exton;
                                  break;
                                 case "java":
                                 fileteron_5=icon_java_ext;
                                 fileion_5=icon_java_ext;
                                 break;
                               }
                             tempboolfile5=true;
                             BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                             filebftemp5.write(filecontenttemp);
                             filebftemp5.flush();
                             filebftemp5.close();
                             file5isnew=false;
                        }
                    }
                        if(fcheck.exists()==true&tempboolfile5==false&(fcheck.getName().equals(file5.getText()))){
                            tempboolfile5=true;
                            filetemp5=fcheck;
                            filepathtemp5=filetemp5.getAbsolutePath();
                           filenametemp5=filetemp5.getName();
                            String filecontenttemp5=codetarea.getText();
                            file5.setText(filenametemp5);
                            file5.setIcon(null);
                            file5.removeMouseListener(new Temp4());
                            file5.addMouseListener(new Temp5());
                           try{
                                 BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                                filebftemp5.write(filecontenttemp5);
                                filebftemp5.flush();
                                filebftemp5.close();
                             }
                           catch(IOException exc){
         
                           }
                        }
                        try{
                            String s_5[]=new String[5];
                                    BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                                    for(int i=0;i<4;i++){
                                        s_5[i]=filebfrtempmeta5.readLine();
                                    }
                                    String x= filebfrtempmeta5.readLine();
                                    filebfrtempmeta5.close();
                                    if(x==null){
                                     BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                                     filebftempmeta5.write(filepathtemp5);
                                     filebftempmeta5.newLine();
                                     filebftempmeta5.flush();
                                     filebftempmeta5.close();
                                    }
                                    if(x!=null){
                                     BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                                     filebftempmeta5.write("");
                                     filebftempmeta5.flush();
                                     filebftempmeta5.close();
                                     BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                                     if(s_5[0]!=null){
                                         filebfwtempmeta5.write(s_5[0]);
                                         filebfwtempmeta5.newLine();
                                     }
                                     if(s_5[1]!=null){
                                         filebfwtempmeta5.write(s_5[1]);
                                         filebfwtempmeta5.newLine();
                                     }
                                     if(s_5[2]!=null){
                                         filebfwtempmeta5.write(s_5[2]);
                                         filebfwtempmeta5.newLine();
                                     }
                                     if(s_5[3]!=null){
                                         filebfwtempmeta5.write(s_5[3]);
                                         filebfwtempmeta5.newLine();
                                     }
                                     filebfwtempmeta5.write(filepathtemp5);
                                     filebfwtempmeta5.newLine();
                                     filebfwtempmeta5.flush();
                                     filebfwtempmeta5.close();
                                 }
                        }
                        catch(IOException exc){

                        }
                        file5save=true;
                        break;
                        }
                     }
                   catch(IOException exc){

                   }
                   try{
                    BufferedWriter filesavemeta=new BufferedWriter(new FileWriter(filesavepathmeta));
                            String filesavetemp1=String.valueOf(file1save);
                            String filesavetemp2=String.valueOf(file2save);
                            String filesavetemp3=String.valueOf(file3save);
                            String filesavetemp4=String.valueOf(file4save);
                            String filesavetemp5=String.valueOf(file5save);
                            filesavemeta.write(filesavetemp1);
                            filesavemeta.newLine();
                            filesavemeta.write(filesavetemp2);
                            filesavemeta.newLine();
                            filesavemeta.write(filesavetemp3);
                            filesavemeta.newLine();
                            filesavemeta.write(filesavetemp4);
                            filesavemeta.newLine();
                            filesavemeta.write(filesavetemp5);
                            filesavemeta.flush();
                            filesavemeta.close();
                }
                catch(IOException exc){

                }
          }
        });
        fnew.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent n){
                file_1_count=file_1_count-1;
                file_2_count=file_2_count-1;
                file_3_count=file_3_count-1;
                file_4_count=file_4_count-1;
                if(fc<=5){
                    fc++;
                }
                if(temp_new<=5){
                    temp_new++;
                }
                if(temp_new>5){
                    ImageIcon fnewerr = new ImageIcon("./image/warning_1.png");
        Image fnewerro=fnewerr.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon fnewerron=new ImageIcon(fnewerro);
        JLabel cmbox_l=new JLabel("Sorry for your inconvenience, but the current version of Orb permits only five files to be displayed concurrently. Please remove one or more files before opening or creating a new file.");
        Toolkit tdir=Toolkit.getDefaultToolkit();
        Dimension sizedir=tdir.getScreenSize();
        cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
        cmbox_l.setBackground(Color.BLACK);
        cmbox_l.setForeground(Color.CYAN);
        JOptionPane.showMessageDialog(null,cmbox_l,"Open Error"
        ,JOptionPane.INFORMATION_MESSAGE,fnewerron);
                }
             switch(temp_new){
                case 2:
                file2.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(true);
                file3butt.setVisible(false);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file3.setBorder(null);
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=2;
                file2isnew=true;
                fileteron_2=orb_exton;
                fileion_2=orb_exton;
                 break;
                case 3:
                file3.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(true);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=3;
                file3isnew=true;
                fileteron_3=orb_exton;
                fileion_3=orb_exton;
                 break;
                case 4:
                file4.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(false);
                file4butt.setVisible(true);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(null);
                file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file5.setBorder(null);
                fileselect=4;
                file4isnew=true;
                fileteron_4=orb_exton;
                fileion_4=orb_exton;
                 break;
                case 5:
                 file5.setVisible(true);
                 file1butt.setVisible(false);
                 file2butt.setVisible(false);
                 file3butt.setVisible(false);
                 file4butt.setVisible(false);
                 file5butt.setVisible(true);
                 file1.setBorder(null);
                 file2.setBorder(null);
                 file3.setBorder(null);
                 file4.setBorder(null);
                 file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 fileselect=5;
                 file5isnew=true;
                 fileteron_5=orb_exton;
                 fileion_5=orb_exton;
                  break;
             }
             if(temp_new<=5){
                 codetarea.setText(null);
                 index.setText(null);
                 codetarea.setText("//  Welcome To Orb");
                 index.setText(" 1  ");
             }
          try{
              String fc_s=Integer.toString(temp_new);
              if(temp_new<=5){
                  BufferedWriter filefctemp1=new BufferedWriter(new FileWriter(filefcpathmeta));
                                   filefctemp1.write(fc_s);
                                   filefctemp1.flush();
                                   filefctemp1.close();
             }
          }
          catch(IOException exc){
  
          }
            }
          });
        farrnew.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent n){
                file_1_count=file_1_count-1;
                file_2_count=file_2_count-1;
                file_3_count=file_3_count-1;
                file_4_count=file_4_count-1;
                if(fc<=5){
                    fc++;
                }
                if(temp_new<=5){
                    temp_new++;
                }
                if(temp_new>5){
                    ImageIcon fnewerr = new ImageIcon("./image/warning_1.png");
        Image fnewerro=fnewerr.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon fnewerron=new ImageIcon(fnewerro);
        JLabel cmbox_l=new JLabel("Sorry for your inconvenience, but the current version of Orb permits only five files to be displayed concurrently. Please remove one or more files before opening or creating a new file.");
        Toolkit tdir=Toolkit.getDefaultToolkit();
        Dimension sizedir=tdir.getScreenSize();
        cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
        cmbox_l.setBackground(Color.BLACK);
        cmbox_l.setForeground(Color.CYAN);
        JOptionPane.showMessageDialog(null,cmbox_l,"Open Error"
        ,JOptionPane.INFORMATION_MESSAGE,fnewerron);
                }
             switch(temp_new){
                case 2:
                file2.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(true);
                file3butt.setVisible(false);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file3.setBorder(null);
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=2;
                file2isnew=true;
                fileteron_2=orb_exton;
                fileion_2=orb_exton;
                 break;
                case 3:
                file3.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(true);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=3;
                file3isnew=true;
                fileteron_3=orb_exton;
                fileion_3=orb_exton;
                 break;
                case 4:
                file4.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(false);
                file4butt.setVisible(true);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(null);
                file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file5.setBorder(null);
                fileselect=4;
                file4isnew=true;
                fileteron_4=orb_exton;
                fileion_4=orb_exton;
                 break;
                case 5:
                 file5.setVisible(true);
                 file1butt.setVisible(false);
                 file2butt.setVisible(false);
                 file3butt.setVisible(false);
                 file4butt.setVisible(false);
                 file5butt.setVisible(true);
                 file1.setBorder(null);
                 file2.setBorder(null);
                 file3.setBorder(null);
                 file4.setBorder(null);
                 file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 fileselect=5;
                 file5isnew=true;
                 fileteron_5=orb_exton;
                 fileion_5=orb_exton;
                  break;
             }
             if(temp_new<=5){
                 codetarea.setText(null);
                 index.setText(null);
                 codetarea.setText("//  Welcome To Orb");
                 index.setText(" 1  ");
             }
          try{
              String fc_s=Integer.toString(temp_new);
              if(temp_new<=5){
                  BufferedWriter filefctemp1=new BufferedWriter(new FileWriter(filefcpathmeta));
                                   filefctemp1.write(fc_s);
                                   filefctemp1.flush();
                                   filefctemp1.close();
             }
          }
          catch(IOException exc){
  
          }
            }
          });
          open.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
                file_1_count=file_1_count-1;
                file_2_count=file_2_count-1;
                file_3_count=file_3_count-1;
                file_4_count=file_4_count-1;
                 JFileChooser opendialog=new JFileChooser();
                    int tempopen=opendialog.showOpenDialog(null);
                   if(tempopen==JFileChooser.APPROVE_OPTION){
                    fileopen=opendialog.getSelectedFile();
                    fileopenpath=fileopen.getAbsolutePath();
                   fileopenname=fileopen.getName();
                   if(fc<=5){
                    fc++;
                }
                File f_ext=fileopen;
                String name_for_ext=f_ext.getName();
                String ext="";
                int dot=name_for_ext.lastIndexOf(".");
                if(dot>0&dot<name_for_ext.length()-1){
                    ext=name_for_ext.substring(dot+1);
                }
                if(temp_new<=5){
                    temp_new++;
                }
                if(temp_new>5){
                    ImageIcon openerr = new ImageIcon("./image/warning_1.png");
                    Image openerro=openerr.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
                    ImageIcon openerron=new ImageIcon(openerro);
                    JLabel cmbox_l=new JLabel("Sorry for your inconvenience, but the current version of Orb permits only five files to be displayed concurrently. Please remove one or more files before opening or creating a new file.");
                    Toolkit tdir=Toolkit.getDefaultToolkit();
                    Dimension sizedir=tdir.getScreenSize();
                    cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
                    cmbox_l.setBackground(Color.BLACK);
                    cmbox_l.setForeground(Color.CYAN);
                    JOptionPane.showMessageDialog(null,cmbox_l,"Open Error"
                    ,JOptionPane.INFORMATION_MESSAGE,openerron);
                }
             switch(temp_new){
                case 2:
                switch(ext){
                    case "orb":
                    fileteron_2=orb_exton;
                    fileion_2=orb_exton;
                     break;
                    case "java":
                    fileteron_2=icon_java_ext;
                    fileion_2=icon_java_ext;
                    break;
                  }
                file2.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(true);
                file3butt.setVisible(false);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file3.setBorder(null);
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=2;
                file2isnew=true;
                 break;
                case 3:
                switch(ext){
                    case "orb":
                    fileteron_3=orb_exton;
                    fileion_3=orb_exton;
                     break;
                    case "java":
                    fileteron_3=icon_java_ext;
                    fileion_3=icon_java_ext;
                    break;
                  }
                file3.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(true);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=3;
                 file3isnew=true;
                 break;
                case 4:
                switch(ext){
                    case "orb":
                    fileteron_4=orb_exton;
                    fileion_4=orb_exton;
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
                    fileion_4=icon_java_ext;
                    break;
                  }
                file4.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(false);
                file4butt.setVisible(true);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(null);
                file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file5.setBorder(null);
                fileselect=4;
                file4isnew=true;
                 break;
                case 5:
                switch(ext){
                    case "orb":
                    fileteron_5=orb_exton;
                    fileion_5=orb_exton;
                     break;
                    case "java":
                    fileteron_5=icon_java_ext;
                    fileion_5=icon_java_ext;
                    break;
                  }
                 file5.setVisible(true);
                 file1butt.setVisible(false);
                 file2butt.setVisible(false);
                 file3butt.setVisible(false);
                 file4butt.setVisible(false);
                 file5butt.setVisible(true);
                 file1.setBorder(null);
                 file2.setBorder(null);
                 file3.setBorder(null);
                 file4.setBorder(null);
                 file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 fileselect=5;
                 file5isnew=true;
                  break;
             }
             if(temp_new<=5){
            try{
                File f_file=fileopen;
                    BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                    String f_temp_file,f_temp_console_file="";
                    while((f_temp_file=meta_3_file.readLine())!=null){
                        f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                    }
                    meta_3_file.close();
                  if(f_file.exists()){
                      index.setText(null);
                      index.setText(" 1  ");
                      codetarea.setText(f_temp_console_file);
                      if(fileselect==1){
                          file1.setText(f_file.getName());
                      }
                      if(fileselect==2){
                        file2.setText(f_file.getName());
                    }
                    if(fileselect==3){
                        file3.setText(f_file.getName());
                    }
                    if(fileselect==4){
                        file4.setText(f_file.getName());
                    }
                    if(fileselect==5){
                        file5.setText(f_file.getName());
                    }
                      for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                              index.append("\n "+f_con_file+" ");
                       }
                  }
            }
            catch(IOException exc){
  
            }
        }
          try{
              String fc_s=Integer.toString(temp_new);
              if(temp_new<=5){
                  BufferedWriter filefctemp1=new BufferedWriter(new FileWriter(filefcpathmeta));
                                   filefctemp1.write(fc_s);
                                   filefctemp1.flush();
                                   filefctemp1.close();
             }
          }
          catch(IOException exc){
  
          }
                   }
             }
          });
          arropen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                file_1_count=file_1_count-1;
                file_2_count=file_2_count-1;
                file_3_count=file_3_count-1;
                file_4_count=file_4_count-1;
                 JFileChooser opendialog=new JFileChooser();
                    int tempopen=opendialog.showOpenDialog(null);
                   if(tempopen==JFileChooser.APPROVE_OPTION){
                    fileopen=opendialog.getSelectedFile();
                    fileopenpath=fileopen.getAbsolutePath();
                   fileopenname=fileopen.getName();
                   if(fc<=5){
                    fc++;
                }
                File f_ext=fileopen;
                String name_for_ext=f_ext.getName();
                String ext="";
                int dot=name_for_ext.lastIndexOf(".");
                if(dot>0&dot<name_for_ext.length()-1){
                    ext=name_for_ext.substring(dot+1);
                }
                if(temp_new<=5){
                    temp_new++;
                }
                if(temp_new>5){
                    ImageIcon openerr = new ImageIcon("./image/warning_1.png");
                    Image openerro=openerr.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
                    ImageIcon openerron=new ImageIcon(openerro);
                    JLabel cmbox_l=new JLabel("Sorry for your inconvenience, but the current version of Orb permits only five files to be displayed concurrently. Please remove one or more files before opening or creating a new file.");
                    Toolkit tdir=Toolkit.getDefaultToolkit();
                    Dimension sizedir=tdir.getScreenSize();
                    cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
                    cmbox_l.setBackground(Color.BLACK);
                    cmbox_l.setForeground(Color.CYAN);
                    JOptionPane.showMessageDialog(null,cmbox_l,"Open Error"
                    ,JOptionPane.INFORMATION_MESSAGE,openerron);
                }
             switch(temp_new){
                case 2:
                switch(ext){
                    case "orb":
                    fileteron_2=orb_exton;
                    fileion_2=orb_exton;
                     break;
                    case "java":
                    fileteron_2=icon_java_ext;
                    fileion_2=icon_java_ext;
                    break;
                  }
                file2.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(true);
                file3butt.setVisible(false);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file3.setBorder(null);
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=2;
                file2isnew=true;
                 break;
                case 3:
                switch(ext){
                    case "orb":
                    fileteron_3=orb_exton;
                    fileion_3=orb_exton;
                     break;
                    case "java":
                    fileteron_3=icon_java_ext;
                    fileion_3=icon_java_ext;
                    break;
                  }
                file3.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(true);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=3;
                 file3isnew=true;
                 break;
                case 4:
                switch(ext){
                    case "orb":
                    fileteron_4=orb_exton;
                    fileion_4=orb_exton;
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
                    fileion_4=icon_java_ext;
                    break;
                  }
                file4.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(false);
                file4butt.setVisible(true);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(null);
                file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file5.setBorder(null);
                fileselect=4;
                file4isnew=true;
                 break;
                case 5:
                switch(ext){
                    case "orb":
                    fileteron_5=orb_exton;
                    fileion_5=orb_exton;
                     break;
                    case "java":
                    fileteron_5=icon_java_ext;
                    fileion_5=icon_java_ext;
                    break;
                  }
                 file5.setVisible(true);
                 file1butt.setVisible(false);
                 file2butt.setVisible(false);
                 file3butt.setVisible(false);
                 file4butt.setVisible(false);
                 file5butt.setVisible(true);
                 file1.setBorder(null);
                 file2.setBorder(null);
                 file3.setBorder(null);
                 file4.setBorder(null);
                 file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 fileselect=5;
                 file5isnew=true;
                  break;
             }
             if(temp_new<=5){
            try{
                File f_file=fileopen;
                    BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                    String f_temp_file,f_temp_console_file="";
                    while((f_temp_file=meta_3_file.readLine())!=null){
                        f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                    }
                    meta_3_file.close();
                  if(f_file.exists()){
                      index.setText(null);
                      index.setText(" 1  ");
                      codetarea.setText(f_temp_console_file);
                      if(fileselect==1){
                          file1.setText(f_file.getName());
                      }
                      if(fileselect==2){
                        file2.setText(f_file.getName());
                    }
                    if(fileselect==3){
                        file3.setText(f_file.getName());
                    }
                    if(fileselect==4){
                        file4.setText(f_file.getName());
                    }
                    if(fileselect==5){
                        file5.setText(f_file.getName());
                    }
                      for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                              index.append("\n "+f_con_file+" ");
                       }
                  }
            }
            catch(IOException exc){
  
            }
        }
          try{
              String fc_s=Integer.toString(temp_new);
              if(temp_new<=5){
                  BufferedWriter filefctemp1=new BufferedWriter(new FileWriter(filefcpathmeta));
                                   filefctemp1.write(fc_s);
                                   filefctemp1.flush();
                                   filefctemp1.close();
             }
          }
          catch(IOException exc){
  
          }
                   }
            }
         });
         rename.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String filecurrpath="";
                Boolean x_rename=false;
                try{
                    BufferedReader filepathrmeta=new BufferedReader(new FileReader(filepathmeta));
                     filecurrpath=filepathrmeta.readLine();
                    for(int iorb=1;iorb<fileselect;iorb++){
                        filecurrpath=filepathrmeta.readLine();
                    }
                    filepathrmeta.close();
                }
                catch(IOException exc){
 
                }
                ImageIcon icon_rename_pop_1= new ImageIcon("./image/renamepop.png");
                Image i_rename_pop_1=icon_rename_pop_1.getImage();
                Image j_rename_pop_1=i_rename_pop_1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                icon_rename_pop_1=new ImageIcon(j_rename_pop_1);
                Object rename=JOptionPane.showInputDialog(null,"Enter file name for rename operation"
                ,"Rename File",JOptionPane.INFORMATION_MESSAGE,icon_rename_pop_1,null,null);
                String filerename="";
                if(rename!=null){
                     filerename=rename.toString();
                }
                File tempfile_1=new File(filecurrpath);
                String filerenamepath=tempfile_1.getParent()+File.separator+filerename;
                File renamefile=new File(filerenamepath);
                   x_rename=tempfile_1.renameTo(renamefile);
                   File f_ext=renamefile;
                   String name_for_ext=f_ext.getName();
                   String ext="";
                   int dot=name_for_ext.lastIndexOf(".");
                   if(dot>0&dot<name_for_ext.length()-1){
                       ext=name_for_ext.substring(dot+1);
                   }
                if(x_rename){
                switch(fileselect){
                    case 1:
                    switch(ext){
                        case "orb":
                        fileteron_1=orb_exton;
                        fileion_1=orb_exton;
                         break;
                        case "java":
                        fileteron_1=icon_java_ext;
                        fileion_1=icon_java_ext;
                        break;
                      }
                    filetemp1=renamefile;
                    filenametemp1=filetemp1.getName();
                    filepathtemp1=filetemp1.getAbsolutePath();
                   String filecontenttemp1=codetarea.getText();
                   file1.setText(filenametemp1);
                   file1.setIcon(null);
                   file1.removeMouseListener(new Temp4());
                   file1.addMouseListener(new Temp5());
                  try{
                       String s[]=new String[5];
                       BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                       String x= filebfrtempmeta1.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta1.write(filepathtemp1);
                        filebftempmeta1.newLine();
                        filebftempmeta1.flush();
                        filebftempmeta1.close();
                       }
                       if(x!=null){
                        for(int i=1;i<5;i++){
                            s[i]=filebfrtempmeta1.readLine();
                        }
                        filebfrtempmeta1.close();
                        BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta1.write("");
                        filebftempmeta1.flush();
                        filebftempmeta1.close();
                        BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebfwtempmeta1.write(filepathtemp1);
                        filebfwtempmeta1.newLine();
                        if(s[1]!=null){
                            filebfwtempmeta1.write(s[1]);
                            filebfwtempmeta1.newLine();
                        }
                        if(s[2]!=null){
                            filebfwtempmeta1.write(s[2]);
                            filebfwtempmeta1.newLine();
                        }
                        if(s[3]!=null){
                            filebfwtempmeta1.write(s[3]);
                            filebfwtempmeta1.newLine();
                        }
                        if(s[4]!=null){
                            filebfwtempmeta1.write(s[4]);
                            filebfwtempmeta1.newLine();
                        }
                        filebfwtempmeta1.flush();
                        filebfwtempmeta1.close();
                    }
                }
                  catch(IOException exc){

                  }
                  break;
                    case 2:
                    switch(ext){
                        case "orb":
                        fileteron_2=orb_exton;
                        fileion_2=orb_exton;
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
                        fileion_2=icon_java_ext;
                        break;
                      }
                    filetemp2=renamefile;
                    filenametemp2=filetemp2.getName();
                    filepathtemp2=filetemp2.getAbsolutePath();
                   String filecontenttemp2=codetarea.getText();
                   file2.setText(filenametemp2);
                   file2.setIcon(null);
                   file2.removeMouseListener(new Temp4());
                   file2.addMouseListener(new Temp5());
                  try{
                       String s[]=new String[5];
                       BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<1;i++){
                           s[i]=filebfrtempmeta2.readLine();
                       }
                       String x= filebfrtempmeta2.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta2.write(filepathtemp2);
                        filebftempmeta2.newLine();
                        filebftempmeta2.flush();
                        filebftempmeta2.close();
                       }
                       if(x!=null){
                        for(int i=2;i<5;i++){
                            s[i]=filebfrtempmeta2.readLine();
                        }
                        filebfrtempmeta2.close();
                        BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta2.write("");
                        filebftempmeta2.flush();
                        filebftempmeta2.close();
                        BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta2.write(s[0]);
                            filebfwtempmeta2.newLine();
                        }
                        filebfwtempmeta2.write(filepathtemp2);
                        filebfwtempmeta2.newLine();
                        if(s[2]!=null){
                            filebfwtempmeta2.write(s[2]);
                            filebfwtempmeta2.newLine();
                        }
                        if(s[3]!=null){
                            filebfwtempmeta2.write(s[3]);
                            filebfwtempmeta2.newLine();
                        }
                        if(s[4]!=null){
                            filebfwtempmeta2.write(s[4]);
                            filebfwtempmeta2.newLine();
                        }
                        filebfwtempmeta2.flush();
                        filebfwtempmeta2.close();
                       }
                    }
                    catch(IOException exc){

                    }
                  break;
                    case 3:
                    switch(ext){
                        case "orb":
                        fileteron_3=orb_exton;
                        fileion_3=orb_exton;
                         break;
                        case "java":
                        fileteron_3=icon_java_ext;
                        fileion_3=icon_java_ext;
                        break;
                      }
                    filetemp3=renamefile;
                    filenametemp3=filetemp3.getName();
                    filepathtemp3=filetemp3.getAbsolutePath();
                   String filecontenttemp3=codetarea.getText();
                   file3.setText(filenametemp3);
                   file3.setIcon(null);
                   file3.removeMouseListener(new Temp4());
                   file3.addMouseListener(new Temp5());
                  try{
                    String s[]=new String[5];
                       BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<2;i++){
                           s[i]=filebfrtempmeta3.readLine();
                       }
                       String x= filebfrtempmeta3.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta3.write(filepathtemp3);
                        filebftempmeta3.newLine();
                        filebftempmeta3.flush();
                        filebftempmeta3.close();
                       }
                       if(x!=null){
                        for(int i=3;i<5;i++){
                            s[i]=filebfrtempmeta3.readLine();
                        }
                        filebfrtempmeta3.close();
                        BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta3.write("");
                        filebftempmeta3.flush();
                        filebftempmeta3.close();
                        BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta3.write(s[0]);
                            filebfwtempmeta3.newLine();
                        }
                        if(s[1]!=null){
                            filebfwtempmeta3.write(s[1]);
                            filebfwtempmeta3.newLine();
                        }
                        filebfwtempmeta3.write(filepathtemp3);
                        filebfwtempmeta3.newLine();
                        if(s[3]!=null){
                            filebfwtempmeta3.write(s[3]);
                            filebfwtempmeta3.newLine();
                        }
                        if(s[4]!=null){
                            filebfwtempmeta3.write(s[4]);
                            filebfwtempmeta3.newLine();
                        }
                        filebfwtempmeta3.flush();
                        filebfwtempmeta3.close();
                       }
                  }
                  catch(IOException exc){
                    
                  }
                  break;
                  case 4:
                  switch(ext){
                    case "orb":
                    fileteron_4=orb_exton;
                    fileion_4=orb_exton;
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
                    fileion_4=icon_java_ext;
                    break;
                  }
                  filetemp4=renamefile;
                  filenametemp4=filetemp4.getName();
                  filepathtemp4=filetemp4.getAbsolutePath();
                 String filecontenttemp4=codetarea.getText();
                 file4.setText(filenametemp4);
                 file4.setIcon(null);
                 file4.removeMouseListener(new Temp4());
                 file4.addMouseListener(new Temp5());
                try{
                     String s[]=new String[5];
                       BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<3;i++){
                           s[i]=filebfrtempmeta4.readLine();
                       }
                       String x= filebfrtempmeta4.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta4.write(filepathtemp4);
                        filebftempmeta4.newLine();
                        filebftempmeta4.flush();
                        filebftempmeta4.close();
                       }
                       if(x!=null){
                        for(int i=4;i<5;i++){
                            s[i]=filebfrtempmeta4.readLine();
                        }
                        filebfrtempmeta4.close();
                        BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta4.write("");
                        filebftempmeta4.flush();
                        filebftempmeta4.close();
                        BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta4.write(s[0]);
                            filebfwtempmeta4.newLine();
                        }
                        if(s[1]!=null){
                            filebfwtempmeta4.write(s[1]);
                            filebfwtempmeta4.newLine();
                        }
                        if(s[2]!=null){
                            filebfwtempmeta4.write(s[2]);
                            filebfwtempmeta4.newLine();
                        }
                        filebfwtempmeta4.write(filepathtemp4);
                        filebfwtempmeta4.newLine();
                        if(s[4]!=null){
                            filebfwtempmeta4.write(s[4]);
                            filebfwtempmeta4.newLine();
                        }
                        filebfwtempmeta4.flush();
                        filebfwtempmeta4.close();
                    }
                }
                catch(IOException exc){

                }
                break;
                case 5:
                switch(ext){
                    case "orb":
                    fileteron_5=orb_exton;
                    fileion_5=orb_exton;
                     break;
                    case "java":
                    fileteron_5=icon_java_ext;
                    fileion_5=icon_java_ext;
                    break;
                  }
                filetemp5=renamefile;
                filenametemp5=filetemp5.getName();
                filepathtemp5=filetemp5.getAbsolutePath();
               String filecontenttemp5=codetarea.getText();
               file5.setText(filenametemp5);
               file5.setIcon(null);
               file5.removeMouseListener(new Temp4());
               file5.addMouseListener(new Temp5());
              try{
                   String s[]=new String[5];
                       BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<4;i++){
                           s[i]=filebfrtempmeta5.readLine();
                       }
                       String x= filebfrtempmeta5.readLine();
                       filebfrtempmeta5.close();
                       if(x==null){
                        BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta5.write(filepathtemp5);
                        filebftempmeta5.newLine();
                        filebftempmeta5.flush();
                        filebftempmeta5.close();
                       }
                       if(x!=null){
                        BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta5.write("");
                        filebftempmeta5.flush();
                        filebftempmeta5.close();
                        BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta5.write(s[0]);
                            filebfwtempmeta5.newLine();
                        }
                        if(s[1]!=null){
                            filebfwtempmeta5.write(s[1]);
                            filebfwtempmeta5.newLine();
                        }
                        if(s[2]!=null){
                            filebfwtempmeta5.write(s[2]);
                            filebfwtempmeta5.newLine();
                        }
                        if(s[3]!=null){
                            filebfwtempmeta5.write(s[3]);
                            filebfwtempmeta5.newLine();
                        }
                        filebfwtempmeta5.write(filepathtemp5);
                        filebfwtempmeta5.newLine();
                        filebfwtempmeta5.flush();
                        filebfwtempmeta5.close();
                    }
                }
              catch(IOException exc){

              }
              break;
                }
              }
              if(!x_rename){
                ImageIcon icon_rename_pop = new ImageIcon("./image/warning.png");
                Image i_rename_pop=icon_rename_pop.getImage();
                Image j_rename_pop=i_rename_pop.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
               icon_rename_pop=new ImageIcon(j_rename_pop);
               JLabel cmbox_l=new JLabel("The rename operation has been denied because the given current folder contains a file with the same name.");
               Toolkit tdir=Toolkit.getDefaultToolkit();
               Dimension sizedir=tdir.getScreenSize();
               cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
               cmbox_l.setBackground(Color.BLACK);
               cmbox_l.setForeground(Color.CYAN);
               JOptionPane.showMessageDialog(null,cmbox_l,"Rename Error"
               ,JOptionPane.INFORMATION_MESSAGE,icon_rename_pop);
              }
            }
         });
         arrrename.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String filecurrpath="";
                Boolean x_rename=false;
                try{
                    BufferedReader filepathrmeta=new BufferedReader(new FileReader(filepathmeta));
                     filecurrpath=filepathrmeta.readLine();
                    for(int iorb=1;iorb<fileselect;iorb++){
                        filecurrpath=filepathrmeta.readLine();
                    }
                    filepathrmeta.close();
                }
                catch(IOException exc){
 
                }
                ImageIcon icon_rename_pop_1= new ImageIcon("./image/renamepop.png");
                Image i_rename_pop_1=icon_rename_pop_1.getImage();
                Image j_rename_pop_1=i_rename_pop_1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                icon_rename_pop_1=new ImageIcon(j_rename_pop_1);
                Object rename=JOptionPane.showInputDialog(null,"Enter file name for rename operation"
                ,"Rename File",JOptionPane.INFORMATION_MESSAGE,icon_rename_pop_1,null,null);
                String filerename="";
                if(rename!=null){
                     filerename=rename.toString();
                }
                File tempfile_1=new File(filecurrpath);
                String filerenamepath=tempfile_1.getParent()+File.separator+filerename;
                File renamefile=new File(filerenamepath);
                   x_rename=tempfile_1.renameTo(renamefile);
                   File f_ext=renamefile;
                   String name_for_ext=f_ext.getName();
                   String ext="";
                   int dot=name_for_ext.lastIndexOf(".");
                   if(dot>0&dot<name_for_ext.length()-1){
                       ext=name_for_ext.substring(dot+1);
                   }
                if(x_rename){
                switch(fileselect){
                    case 1:
                    switch(ext){
                        case "orb":
                        fileteron_1=orb_exton;
                        fileion_1=orb_exton;
                         break;
                        case "java":
                        fileteron_1=icon_java_ext;
                        fileion_1=icon_java_ext;
                        break;
                      }
                    filetemp1=renamefile;
                    filenametemp1=filetemp1.getName();
                    filepathtemp1=filetemp1.getAbsolutePath();
                   String filecontenttemp1=codetarea.getText();
                   file1.setText(filenametemp1);
                   file1.setIcon(null);
                   file1.removeMouseListener(new Temp4());
                   file1.addMouseListener(new Temp5());
                  try{
                       String s[]=new String[5];
                       BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                       String x= filebfrtempmeta1.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta1.write(filepathtemp1);
                        filebftempmeta1.newLine();
                        filebftempmeta1.flush();
                        filebftempmeta1.close();
                       }
                       if(x!=null){
                        for(int i=1;i<5;i++){
                            s[i]=filebfrtempmeta1.readLine();
                        }
                        filebfrtempmeta1.close();
                        BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta1.write("");
                        filebftempmeta1.flush();
                        filebftempmeta1.close();
                        BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebfwtempmeta1.write(filepathtemp1);
                        filebfwtempmeta1.newLine();
                        if(s[1]!=null){
                            filebfwtempmeta1.write(s[1]);
                            filebfwtempmeta1.newLine();
                        }
                        if(s[2]!=null){
                            filebfwtempmeta1.write(s[2]);
                            filebfwtempmeta1.newLine();
                        }
                        if(s[3]!=null){
                            filebfwtempmeta1.write(s[3]);
                            filebfwtempmeta1.newLine();
                        }
                        if(s[4]!=null){
                            filebfwtempmeta1.write(s[4]);
                            filebfwtempmeta1.newLine();
                        }
                        filebfwtempmeta1.flush();
                        filebfwtempmeta1.close();
                    }
                }
                  catch(IOException exc){

                  }
                  break;
                    case 2:
                    switch(ext){
                        case "orb":
                        fileteron_2=orb_exton;
                        fileion_2=orb_exton;
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
                        fileion_2=icon_java_ext;
                        break;
                      }
                    filetemp2=renamefile;
                    filenametemp2=filetemp2.getName();
                    filepathtemp2=filetemp2.getAbsolutePath();
                   String filecontenttemp2=codetarea.getText();
                   file2.setText(filenametemp2);
                   file2.setIcon(null);
                   file2.removeMouseListener(new Temp4());
                   file2.addMouseListener(new Temp5());
                  try{
                       String s[]=new String[5];
                       BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<1;i++){
                           s[i]=filebfrtempmeta2.readLine();
                       }
                       String x= filebfrtempmeta2.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta2.write(filepathtemp2);
                        filebftempmeta2.newLine();
                        filebftempmeta2.flush();
                        filebftempmeta2.close();
                       }
                       if(x!=null){
                        for(int i=2;i<5;i++){
                            s[i]=filebfrtempmeta2.readLine();
                        }
                        filebfrtempmeta2.close();
                        BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta2.write("");
                        filebftempmeta2.flush();
                        filebftempmeta2.close();
                        BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta2.write(s[0]);
                            filebfwtempmeta2.newLine();
                        }
                        filebfwtempmeta2.write(filepathtemp2);
                        filebfwtempmeta2.newLine();
                        if(s[2]!=null){
                            filebfwtempmeta2.write(s[2]);
                            filebfwtempmeta2.newLine();
                        }
                        if(s[3]!=null){
                            filebfwtempmeta2.write(s[3]);
                            filebfwtempmeta2.newLine();
                        }
                        if(s[4]!=null){
                            filebfwtempmeta2.write(s[4]);
                            filebfwtempmeta2.newLine();
                        }
                        filebfwtempmeta2.flush();
                        filebfwtempmeta2.close();
                       }
                    }
                    catch(IOException exc){

                    }
                  break;
                    case 3:
                    switch(ext){
                        case "orb":
                        fileteron_3=orb_exton;
                        fileion_3=orb_exton;
                         break;
                        case "java":
                        fileteron_3=icon_java_ext;
                        fileion_3=icon_java_ext;
                        break;
                      }
                    filetemp3=renamefile;
                    filenametemp3=filetemp3.getName();
                    filepathtemp3=filetemp3.getAbsolutePath();
                   String filecontenttemp3=codetarea.getText();
                   file3.setText(filenametemp3);
                   file3.setIcon(null);
                   file3.removeMouseListener(new Temp4());
                   file3.addMouseListener(new Temp5());
                  try{
                    String s[]=new String[5];
                       BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<2;i++){
                           s[i]=filebfrtempmeta3.readLine();
                       }
                       String x= filebfrtempmeta3.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta3.write(filepathtemp3);
                        filebftempmeta3.newLine();
                        filebftempmeta3.flush();
                        filebftempmeta3.close();
                       }
                       if(x!=null){
                        for(int i=3;i<5;i++){
                            s[i]=filebfrtempmeta3.readLine();
                        }
                        filebfrtempmeta3.close();
                        BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta3.write("");
                        filebftempmeta3.flush();
                        filebftempmeta3.close();
                        BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta3.write(s[0]);
                            filebfwtempmeta3.newLine();
                        }
                        if(s[1]!=null){
                            filebfwtempmeta3.write(s[1]);
                            filebfwtempmeta3.newLine();
                        }
                        filebfwtempmeta3.write(filepathtemp3);
                        filebfwtempmeta3.newLine();
                        if(s[3]!=null){
                            filebfwtempmeta3.write(s[3]);
                            filebfwtempmeta3.newLine();
                        }
                        if(s[4]!=null){
                            filebfwtempmeta3.write(s[4]);
                            filebfwtempmeta3.newLine();
                        }
                        filebfwtempmeta3.flush();
                        filebfwtempmeta3.close();
                       }
                  }
                  catch(IOException exc){
                    
                  }
                  break;
                  case 4:
                  switch(ext){
                    case "orb":
                    fileteron_4=orb_exton;
                    fileion_4=orb_exton;
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
                    fileion_4=icon_java_ext;
                    break;
                  }
                  filetemp4=renamefile;
                  filenametemp4=filetemp4.getName();
                  filepathtemp4=filetemp4.getAbsolutePath();
                 String filecontenttemp4=codetarea.getText();
                 file4.setText(filenametemp4);
                 file4.setIcon(null);
                 file4.removeMouseListener(new Temp4());
                 file4.addMouseListener(new Temp5());
                try{
                     String s[]=new String[5];
                       BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<3;i++){
                           s[i]=filebfrtempmeta4.readLine();
                       }
                       String x= filebfrtempmeta4.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta4.write(filepathtemp4);
                        filebftempmeta4.newLine();
                        filebftempmeta4.flush();
                        filebftempmeta4.close();
                       }
                       if(x!=null){
                        for(int i=4;i<5;i++){
                            s[i]=filebfrtempmeta4.readLine();
                        }
                        filebfrtempmeta4.close();
                        BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta4.write("");
                        filebftempmeta4.flush();
                        filebftempmeta4.close();
                        BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta4.write(s[0]);
                            filebfwtempmeta4.newLine();
                        }
                        if(s[1]!=null){
                            filebfwtempmeta4.write(s[1]);
                            filebfwtempmeta4.newLine();
                        }
                        if(s[2]!=null){
                            filebfwtempmeta4.write(s[2]);
                            filebfwtempmeta4.newLine();
                        }
                        filebfwtempmeta4.write(filepathtemp4);
                        filebfwtempmeta4.newLine();
                        if(s[4]!=null){
                            filebfwtempmeta4.write(s[4]);
                            filebfwtempmeta4.newLine();
                        }
                        filebfwtempmeta4.flush();
                        filebfwtempmeta4.close();
                    }
                }
                catch(IOException exc){

                }
                break;
                case 5:
                switch(ext){
                    case "orb":
                    fileteron_5=orb_exton;
                    fileion_5=orb_exton;
                     break;
                    case "java":
                    fileteron_5=icon_java_ext;
                    fileion_5=icon_java_ext;
                    break;
                  }
                filetemp5=renamefile;
                filenametemp5=filetemp5.getName();
                filepathtemp5=filetemp5.getAbsolutePath();
               String filecontenttemp5=codetarea.getText();
               file5.setText(filenametemp5);
               file5.setIcon(null);
               file5.removeMouseListener(new Temp4());
               file5.addMouseListener(new Temp5());
              try{
                   String s[]=new String[5];
                       BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<4;i++){
                           s[i]=filebfrtempmeta5.readLine();
                       }
                       String x= filebfrtempmeta5.readLine();
                       filebfrtempmeta5.close();
                       if(x==null){
                        BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta5.write(filepathtemp5);
                        filebftempmeta5.newLine();
                        filebftempmeta5.flush();
                        filebftempmeta5.close();
                       }
                       if(x!=null){
                        BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta5.write("");
                        filebftempmeta5.flush();
                        filebftempmeta5.close();
                        BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta5.write(s[0]);
                            filebfwtempmeta5.newLine();
                        }
                        if(s[1]!=null){
                            filebfwtempmeta5.write(s[1]);
                            filebfwtempmeta5.newLine();
                        }
                        if(s[2]!=null){
                            filebfwtempmeta5.write(s[2]);
                            filebfwtempmeta5.newLine();
                        }
                        if(s[3]!=null){
                            filebfwtempmeta5.write(s[3]);
                            filebfwtempmeta5.newLine();
                        }
                        filebfwtempmeta5.write(filepathtemp5);
                        filebfwtempmeta5.newLine();
                        filebfwtempmeta5.flush();
                        filebfwtempmeta5.close();
                    }
                }
              catch(IOException exc){

              }
              break;
                }
              }
              if(!x_rename){
                ImageIcon icon_rename_pop = new ImageIcon("./image/warning.png");
                Image i_rename_pop=icon_rename_pop.getImage();
                Image j_rename_pop=i_rename_pop.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
               icon_rename_pop=new ImageIcon(j_rename_pop);
               JLabel cmbox_l=new JLabel("The rename operation has been denied because the given current folder contains a file with the same name.");
               Toolkit tdir=Toolkit.getDefaultToolkit();
               Dimension sizedir=tdir.getScreenSize();
               cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
               cmbox_l.setBackground(Color.BLACK);
               cmbox_l.setForeground(Color.CYAN);
               JOptionPane.showMessageDialog(null,cmbox_l,"Rename Error"
               ,JOptionPane.INFORMATION_MESSAGE,icon_rename_pop);
              }
            }
         });
         
         JDialog starpop=new JDialog(this);
         
         stardet.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Toolkit tfdpopx=Toolkit.getDefaultToolkit();
                Dimension sizefdpopx=tfdpopx.getScreenSize();
                JPanel starpanel=new JPanel();
                List<Point> starPoints=new  ArrayList<Point>();
                List<Double> magnitude = new ArrayList<Double>();
                starpanel.setLayout(new GridLayout(8,1,0,2));
                starpanel.setBackground(Color.BLACK);
                starpanel.setBackground(Color.BLACK);
                ImageIcon stari = new ImageIcon("./image/star_detection.png");
                     Image stario=stari.getImage().getScaledInstance(27,25,Image.SCALE_SMOOTH);
                      ImageIcon starion=new ImageIcon(stario);
                      ImageIcon star_1i  = new ImageIcon("./image/open_1.png");
                      Image star_1io=star_1i.getImage().getScaledInstance(25,24,Image.SCALE_SMOOTH);
                       ImageIcon star_1ion=new ImageIcon(star_1io);
                      JLabel starloc=new JLabel();
                      JTextField starlocpath=new JTextField();
            starloc.setLayout(new GridLayout(1,3,2,0));
            JLabel starlocicon=new JLabel();
            starlocicon.setIcon(star_1ion);
            starlocicon.setHorizontalTextPosition(JLabel.CENTER);
            starlocicon.setHorizontalAlignment(JLabel.CENTER);
            starlocicon.setCursor(c);
            // String starfileopenpath="";
            starlocicon.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    JFileChooser staropendialog=new JFileChooser();
                    int startempopen=staropendialog.showOpenDialog(null);
                   if(startempopen==JFileChooser.APPROVE_OPTION){
                    File starfileopen=staropendialog.getSelectedFile();
                    String starfileopenpath=starfileopen.getAbsolutePath();
                    // System.out.println(starfileopenpath);
                    starlocpath.setText(starfileopenpath);
                       }
                    }
                });
            JLabel starloclabel=new JLabel("Path : ");
            starloclabel.setFont(new Font("Serif",Font.BOLD,15));
            starloclabel.setForeground(Color.CYAN);
            starloclabel.setHorizontalTextPosition(JLabel.CENTER);
            starloclabel.setHorizontalAlignment(JLabel.CENTER);
           
            MatteBorder starb=new MatteBorder(2,2,2,2,Color.DARK_GRAY);
            starlocpath.setBorder(starb);
            starlocpath.setFont(new Font("Serif",Font.BOLD,15));
            starlocpath.setForeground(Color.CYAN);
            starlocpath.setBackground(Color.BLACK);
            starlocpath.setSelectedTextColor(new Color(3, 252, 7));
            starlocpath.setSelectionColor(Color.DARK_GRAY);
            starlocpath.setCaretColor(Color.CYAN);
            starlocpath.setBorder(null);
            // importlocpath.setText(starfileopenpath);
            starloc.add(starloclabel);
            starloc.add(starlocpath);
            starloc.add(starlocicon);
                           starpanel.add(starloc);
                           JPanel starpreprocess=new JPanel();
                           starpreprocess.setLayout(new GridLayout(1,6,1,0));
          JLabel prolabel_3=new JLabel("    PreProcess :");
          prolabel_3.setForeground(Color.GREEN);
          starpreprocess.setBackground(Color.BLACK);
          JRadioButton b_s=new JRadioButton("Bias_Subtraction");
          JRadioButton df_s=new JRadioButton("DarkFrame_Subtraction");
          JRadioButton ff_c=new JRadioButton("FlatField_Correction");
          JRadioButton n_r=new JRadioButton("DarkFlatField_Correction");
          JRadioButton n_a=new JRadioButton("None");
          b_s.setUI(new BasicRadioButtonUI(){
              protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
              }
          });
          df_s.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         ff_c.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         n_r.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         n_a.setUI(new BasicRadioButtonUI(){
            protected void paintFocus(Graphics g,Rectangle r,Dimension d){

            }
        });
         b_s.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(b_s.isSelected()){
                     b_s.setForeground(Color.ORANGE);
                 }
                 else{
                     b_s.setForeground(Color.GREEN);
                 }
             }
         });
         df_s.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(df_s.isSelected()){
                     df_s.setForeground(Color.ORANGE);
                 }
                 else{
                     df_s.setForeground(Color.GREEN);
                 }
             }
         });
         ff_c.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(ff_c.isSelected()){
                     ff_c.setForeground(Color.ORANGE);
                 }
                 else{
                     ff_c.setForeground(Color.GREEN);
                 }
             }
         });
         n_r.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(n_r.isSelected()){
                     n_r.setForeground(Color.ORANGE);
                 }
                 else{
                    n_r.setForeground(Color.GREEN);
                 }
             }
         });
         n_a.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                if(n_a.isSelected()){
                    n_a.setForeground(Color.ORANGE);
                }
                else{
                    n_a.setForeground(Color.GREEN);
                }
            }
        });
          b_s.setBorderPainted(false);
          df_s.setBorderPainted(false);
          ff_c.setBorderPainted(false);
          n_r.setBorderPainted(false);
          n_a.setBorderPainted(false);
          b_s.setForeground(Color.GREEN);
          df_s.setForeground(Color.GREEN);
          ff_c.setForeground(Color.GREEN);
          n_r.setForeground(Color.GREEN);
          n_a.setForeground(Color.GREEN);
          b_s.setBackground(Color.BLACK);
          df_s.setBackground(Color.BLACK);
          ff_c.setBackground(Color.BLACK);
          n_r.setBackground(Color.BLACK);
          n_a.setBackground(Color.BLACK);
          df_s.setSelected(true);
        //   ButtonGroup pro_3=new ButtonGroup();
        //   pro_3.add(b_s);
        //   pro_3.add(df_s);
        //   pro_3.add(ff_c);
        //   pro_3.add(n_r);
          starpreprocess.add(prolabel_3);
          starpreprocess.add(b_s);
          starpreprocess.add(df_s);
          starpreprocess.add(ff_c);
          starpreprocess.add(n_r);
          starpreprocess.add(n_a);
                           starpanel.add(starpreprocess);
                           JPanel starthresold=new JPanel();
                           starthresold.setLayout(new GridLayout(1,4,1,0));
          JLabel prolabel_4=new JLabel("    Thresolding :");
          prolabel_4.setForeground(Color.GREEN);
          starthresold.setBackground(Color.BLACK);
          JRadioButton g_t=new JRadioButton("Global Thresolding");
          JRadioButton a_t=new JRadioButton("Adaptive Thresolding");
          JRadioButton n_t=new JRadioButton("None");
            ButtonGroup pro_4=new ButtonGroup();
          pro_4.add(g_t);
          pro_4.add(a_t);
          pro_4.add(n_t);
          g_t.setUI(new BasicRadioButtonUI(){
              protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
              }
          });
          a_t.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         n_t.setUI(new BasicRadioButtonUI(){
            protected void paintFocus(Graphics g,Rectangle r,Dimension d){

            }
        });
         g_t.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(g_t.isSelected()){
                     g_t.setForeground(Color.ORANGE);
                 }
                 else{
                     g_t.setForeground(Color.GREEN);
                 }
             }
         });
         a_t.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(a_t.isSelected()){
                     a_t.setForeground(Color.ORANGE);
                 }
                 else{
                     a_t.setForeground(Color.GREEN);
                 }
             }
         });
         n_t.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(n_t.isSelected()){
                     n_t.setForeground(Color.ORANGE);
                 }
                 else{
                     n_t.setForeground(Color.GREEN);
                 }
             }
         });
          g_t.setBorderPainted(false);
          a_t.setBorderPainted(false);
          n_t.setBorderPainted(false);
          g_t.setForeground(Color.GREEN);
          a_t.setForeground(Color.GREEN);
          n_t.setForeground(Color.GREEN);
          g_t.setBackground(Color.BLACK);
          a_t.setBackground(Color.BLACK);
          n_t.setBackground(Color.BLACK);
          g_t.setSelected(true);
          starthresold.add(prolabel_4);
          starthresold.add(g_t);
          starthresold.add(a_t);
          starthresold.add(n_t);
                           starpanel.add(starthresold);
                           JPanel starblob=new JPanel();
                           starblob.setLayout(new GridLayout(1,4,1,0));
          JLabel prolabel_5=new JLabel("    Blob Detection :");
          prolabel_5.setForeground(Color.GREEN);
          starblob.setBackground(Color.BLACK);
          JRadioButton log=new JRadioButton("Laplacian of Gaussians");
          JRadioButton dog=new JRadioButton("Difference of Gaussians");
          JRadioButton nog=new JRadioButton("None");
          ButtonGroup pro_5=new ButtonGroup();
          pro_5.add(log);
          pro_5.add(dog);
          pro_5.add(nog);
          log.setUI(new BasicRadioButtonUI(){
              protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
              }
          });
          dog.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         nog.setUI(new BasicRadioButtonUI(){
            protected void paintFocus(Graphics g,Rectangle r,Dimension d){

            }
        });
         log.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(log.isSelected()){
                     log.setForeground(Color.ORANGE);
                 }
                 else{
                     log.setForeground(Color.GREEN);
                 }
             }
         });
         dog.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(dog.isSelected()){
                     dog.setForeground(Color.ORANGE);
                 }
                 else{
                     dog.setForeground(Color.GREEN);
                 }
             }
         });
         nog.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                if(nog.isSelected()){
                    nog.setForeground(Color.ORANGE);
                }
                else{
                    nog.setForeground(Color.GREEN);
                }
            }
        });
          log.setBorderPainted(false);
          dog.setBorderPainted(false);
          nog.setBorderPainted(false);
          log.setForeground(Color.GREEN);
          dog.setForeground(Color.GREEN);
          nog.setForeground(Color.GREEN);
          log.setBackground(Color.BLACK);
          dog.setBackground(Color.BLACK);
          nog.setBackground(Color.BLACK);
          log.setSelected(true);
          starblob.add(prolabel_5);
          starblob.add(dog);
          starblob.add(log);
          starblob.add(nog);
                           starpanel.add(starblob);
                           JPanel starfilter=new JPanel();
                           starfilter.setLayout(new GridLayout(1,4,1,0));
          JLabel prolabel_6=new JLabel("    Star Filtering :");
          prolabel_6.setForeground(Color.GREEN);
          starfilter.setBackground(Color.BLACK);
          JRadioButton mag=new JRadioButton("Magnitude");
          JRadioButton size=new JRadioButton("Size");
          JRadioButton na=new JRadioButton("None");
          ButtonGroup pro_6=new ButtonGroup();
          pro_6.add(mag);
          pro_6.add(size);
          pro_6.add(na);
          mag.setUI(new BasicRadioButtonUI(){
              protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
              }
          });
          size.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         na.setUI(new BasicRadioButtonUI(){
            protected void paintFocus(Graphics g,Rectangle r,Dimension d){

            }
        });
         mag.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(mag.isSelected()){
                     mag.setForeground(Color.ORANGE);
                 }
                 else{
                     mag.setForeground(Color.GREEN);
                 }
             }
         });
         size.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(size.isSelected()){
                     size.setForeground(Color.ORANGE);
                 }
                 else{
                     size.setForeground(Color.GREEN);
                 }
             }
         });
         na.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                if(na.isSelected()){
                    na.setForeground(Color.ORANGE);
                }
                else{
                    na.setForeground(Color.GREEN);
                }
            }
        });
          mag.setBorderPainted(false);
          size.setBorderPainted(false);
          na.setBorderPainted(false);
          mag.setForeground(Color.GREEN);
          size.setForeground(Color.GREEN);
          na.setForeground(Color.GREEN);
          mag.setBackground(Color.BLACK);
          size.setBackground(Color.BLACK);
          na.setBackground(Color.BLACK);
          mag.setSelected(true);
          starfilter.add(prolabel_6);
          starfilter.add(mag);
          starfilter.add(size);
          starfilter.add(na);
                           starpanel.add(starfilter);
                           JPanel starpm=new JPanel();
                           starpreprocess.setLayout(new GridLayout(1,6,1,0));
          JLabel prolabel_7=new JLabel("    Aperture Photometry:");
          prolabel_7.setForeground(Color.GREEN);
          starpreprocess.setBackground(Color.BLACK);
          JRadioButton rl=new JRadioButton("Relative");
          JRadioButton abs=new JRadioButton("Absolute");
          JRadioButton diff=new JRadioButton("Differential");
          JRadioButton surf=new JRadioButton("Surface");
          JRadioButton none=new JRadioButton("None");
          rl.setUI(new BasicRadioButtonUI(){
              protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
              }
          });
          abs.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         diff.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         surf.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         none.setUI(new BasicRadioButtonUI(){
            protected void paintFocus(Graphics g,Rectangle r,Dimension d){

            }
        });
         rl.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(rl.isSelected()){
                     rl.setForeground(Color.ORANGE);
                 }
                 else{
                     rl.setForeground(Color.GREEN);
                 }
             }
         });
         abs.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(abs.isSelected()){
                     abs.setForeground(Color.ORANGE);
                 }
                 else{
                     abs.setForeground(Color.GREEN);
                 }
             }
         });
         diff.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(diff.isSelected()){
                     diff.setForeground(Color.ORANGE);
                 }
                 else{
                     diff.setForeground(Color.GREEN);
                 }
             }
         });
         surf.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(surf.isSelected()){
                     surf.setForeground(Color.ORANGE);
                 }
                 else{
                    surf.setForeground(Color.GREEN);
                 }
             }
         });
         none.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                if(none.isSelected()){
                    none.setForeground(Color.ORANGE);
                }
                else{
                    none.setForeground(Color.GREEN);
                }
            }
        });
          rl.setBorderPainted(false);
          abs.setBorderPainted(false);
          diff.setBorderPainted(false);
          surf.setBorderPainted(false);
          none.setBorderPainted(false);
          rl.setForeground(Color.GREEN);
          abs.setForeground(Color.GREEN);
          diff.setForeground(Color.GREEN);
          surf.setForeground(Color.GREEN);
          none.setForeground(Color.GREEN);
          rl.setBackground(Color.BLACK);
          abs.setBackground(Color.BLACK);
          diff.setBackground(Color.BLACK);
          surf.setBackground(Color.BLACK);
          none.setBackground(Color.BLACK);
          abs.setSelected(true);
          ButtonGroup pro_7=new ButtonGroup();
          pro_7.add(rl);
          pro_7.add(abs);
          pro_7.add(diff);
          pro_7.add(surf);
          pro_7.add(none);
          starpm.add(prolabel_7);
          starpm.add(rl);
          starpm.add(abs);
          starpm.add(diff);
          starpm.add(surf);
          starpm.add(none);
                           starpanel.add(starpm);
                           JPanel starmag_anly=new JPanel();
                           starmag_anly.setLayout(new GridLayout(1,3,1,0));
          JLabel prolabel_8=new JLabel("    Analyze based on Magnitude :");
          prolabel_8.setForeground(Color.GREEN);
          starmag_anly.setBackground(Color.BLACK);
          JRadioButton magy=new JRadioButton("Yes");
          JRadioButton magn=new JRadioButton("No");
          ButtonGroup pro_8=new ButtonGroup();
          pro_8.add(magy);
          pro_8.add(magn);
          mag.setUI(new BasicRadioButtonUI(){
              protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
              }
          });
          magn.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         magy.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(magy.isSelected()){
                     magy.setForeground(Color.ORANGE);
                 }
                 else{
                     magy.setForeground(Color.GREEN);
                 }
             }
         });
         magn.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(magn.isSelected()){
                     magn.setForeground(Color.ORANGE);
                 }
                 else{
                     magn.setForeground(Color.GREEN);
                 }
             }
         });
          magy.setBorderPainted(false);
          magn.setBorderPainted(false);
          magy.setForeground(Color.GREEN);
          magn.setForeground(Color.GREEN);
          magy.setBackground(Color.BLACK);
          magn.setBackground(Color.BLACK);
          magy.setSelected(true);
          starmag_anly.add(prolabel_8);
          starmag_anly.add(magy);
          starmag_anly.add(magn);
                           starpanel.add(starmag_anly);
                           JLabel starnext=new JLabel("Process");
                           starnext.setCursor(c);
                           starnext.setFont(new Font("Serif",Font.BOLD,10));
                           starnext.addMouseListener(new MouseAdapter(){
                               public void mouseEntered(MouseEvent e){
                               starnext.setForeground(Color.YELLOW);
                               starnext.setFont(new Font("Serif",Font.BOLD,15));
                             }
                             public void mouseExited(MouseEvent e){
                               starnext.setForeground(Color.CYAN);
                               starnext.setFont(new Font("Serif",Font.BOLD,10));
                             }
                             public void mouseClicked(MouseEvent e){
                                List<Double> m = new ArrayList<Double>();
                                List<Point> starPoints_1=new  ArrayList<Point>();
                                if(b_s.isSelected()){
                                   BiasSubtraction b=new BiasSubtraction();
                                   b.extra(starlocpath.getText());
                                }
                                if(df_s.isSelected()){
                                   DarkFrameSubtraction d=new DarkFrameSubtraction();
                                   d.extra();
                                }
                                if(ff_c.isSelected()){
                                   FlatFieldCorrection f=new FlatFieldCorrection();
                                   f.extra(starlocpath.getText());
                                }
                                if(n_r.isSelected()){
                                   DarkFlatFieldSubtraction d=new DarkFlatFieldSubtraction();
                                   d.extra(starlocpath.getText());
                                }
                                if(n_a.isSelected()){
                                   //none
                                }
                                if(g_t.isSelected()){
                                   //code combine in star detection
                                }
                                if(a_t.isSelected()){
                                    //code combine in star detection
                                }
                                if(n_t.isSelected()){
                                   //none
                                }
                                if(log.isSelected()){
                                   StarDetection s=new StarDetection();
                                   s.extra(starlocpath.getText());
                                }
                                if(dog.isSelected()){
                                   
                                }
                                if(nog.isSelected()){
                                   //none
                                }
                                if(mag.isSelected()){
                                  StarLocalization1 s=new StarLocalization1();                                  
                                  s.extra(starlocpath.getText());
                                }
                                if(size.isSelected()){
                                   
                                }
                                if(na.isSelected()){
                                   //none
                                }
                                if(rl.isSelected()){
                                    RelativePhotometry r=new RelativePhotometry();
                                    r.extra(starlocpath.getText());
                                                                  }
                                if(abs.isSelected()){
                                   AbsolutePhotometry abs1=new AbsolutePhotometry();
                                   abs1.extra1(starlocpath.getText());
                                }
                                if(diff.isSelected()){
                                    DifferentialPhotometry d=new DifferentialPhotometry();
                                    d.extra(starlocpath.getText());
//                                    d.extra(starlocpath.getText(),starPoints_1.get(0),starPoints.get(1));
                                }
                                if(surf.isSelected()){
                                   //none
                                   GalaxyDetection1 g1=new GalaxyDetection1();
                                   g1.extra(starlocpath.getText());
                                }
                                if(none.isSelected()){
                                   //none
                                }
                                if(magy.isSelected()){
                                   CSVRowMatcher c=new CSVRowMatcher();
                                   c.printRecord("D:\\Project\\class_csv.csv",m.get(0).toString());
                                }
                                if(magn.isSelected()){
                                   //none
                                }
                             }
                            });
                           starnext.setHorizontalTextPosition(JLabel.CENTER);
                           starnext.setHorizontalAlignment(JLabel.CENTER);
                           starnext.setForeground(Color.CYAN);
                           starpanel.add(starnext);
                           starpop.add(starpanel);
                           starpop.setIconImage(starion.getImage());
                           starpop.setTitle("Star_Detection");
                           starpop.setSize((sizefdpopx.width/2),(sizefdpopx.height/2));
                           starpanel.setSize((sizefdpopx.width/2),(sizefdpopx.height/2));
                           starpop.setModal(true);
                           starpop.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                           starpop.setLocationRelativeTo(null);
                           starpop.setVisible(true);
            }
        });
         JDialog importpop=new JDialog(this);
         Toolkit tfdpop=Toolkit.getDefaultToolkit();
         Dimension sizefdpop=tfdpop.getScreenSize();
         JPanel importpanel=new JPanel();
         importpanel.setLayout(new GridLayout(4,1,2,0));
         importpanel.setBackground(Color.BLACK);
         ImageIcon importi = new ImageIcon("./image/import.png");
              Image importio=importi.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
               ImageIcon importion=new ImageIcon(importio);
         JPanel importradio=new JPanel();
        //  importradio.setLayout(new BoxLayout(importradio,BoxLayout.Y_AXIS));
        importradio.setLayout(new GridLayout(1,5,1,0));
         JLabel typelabel=new JLabel("     Type :");
         typelabel.setForeground(Color.GREEN);
         importradio.setBackground(Color.BLACK);
         JRadioButton device=new JRadioButton("This Device");
         JRadioButton internet=new JRadioButton("Internet");
         JRadioButton orbcomm=new JRadioButton("Orb Communication");
         JRadioButton intranet=new JRadioButton("Intranet");
         device.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){

             }
         });
         internet.setUI(new BasicRadioButtonUI(){
            protected void paintFocus(Graphics g,Rectangle r,Dimension d){

            }
        });
        orbcomm.setUI(new BasicRadioButtonUI(){
            protected void paintFocus(Graphics g,Rectangle r,Dimension d){

            }
        });
        intranet.setUI(new BasicRadioButtonUI(){
            protected void paintFocus(Graphics g,Rectangle r,Dimension d){

            }
        });
        device.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                if(device.isSelected()){
                    device.setForeground(Color.ORANGE);
                }
                else{
                    device.setForeground(Color.GREEN);
                }
            }
        });
        internet.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                if(internet.isSelected()){
                    internet.setForeground(Color.ORANGE);
                }
                else{
                    internet.setForeground(Color.GREEN);
                }
            }
        });
        orbcomm.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                if(orbcomm.isSelected()){
                    orbcomm.setForeground(Color.ORANGE);
                }
                else{
                    orbcomm.setForeground(Color.GREEN);
                }
            }
        });
        intranet.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                if(intranet.isSelected()){
                    intranet.setForeground(Color.ORANGE);
                }
                else{
                    intranet.setForeground(Color.GREEN);
                }
            }
        });
         device.setBorderPainted(false);
         internet.setBorderPainted(false);
         orbcomm.setBorderPainted(false);
         intranet.setBorderPainted(false);
         device.setForeground(Color.GREEN);
         internet.setForeground(Color.GREEN);
         orbcomm.setForeground(Color.GREEN);
         intranet.setForeground(Color.GREEN);
         device.setBackground(Color.BLACK);
         internet.setBackground(Color.BLACK);
         orbcomm.setBackground(Color.BLACK);
         intranet.setBackground(Color.BLACK);
        //  importradio.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        //  importradio.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        device.setSelected(true);
         ButtonGroup type=new ButtonGroup();
         type.add(device);
         type.add(internet);
         type.add(orbcomm);
         type.add(intranet);
         importradio.add(typelabel);
         importradio.add(device);
         importradio.add(internet);
         importradio.add(orbcomm);
         importradio.add(intranet);

         JPanel importprotocol=new JPanel();
         importprotocol.setBackground(Color.BLACK);
         importprotocol.setLayout(new GridLayout(3,1,1,0));
         JPanel datatransfer=new JPanel();
         datatransfer.setLayout(new GridLayout(1,5,1,0));
          JLabel prolabel_1=new JLabel("     Data Transfer :");
          prolabel_1.setForeground(Color.GREEN);
          datatransfer.setBackground(Color.BLACK);
          JRadioButton tcp=new JRadioButton("TCP");
          JRadioButton udp=new JRadioButton("UDP");
          JRadioButton smtp=new JRadioButton("SMTP");
          JRadioButton http=new JRadioButton("HTTP");
          tcp.setUI(new BasicRadioButtonUI(){
              protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
              }
          });
          udp.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         smtp.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         http.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         tcp.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(tcp.isSelected()){
                     tcp.setForeground(Color.ORANGE);
                 }
                 else{
                     tcp.setForeground(Color.GREEN);
                 }
             }
         });
         udp.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(udp.isSelected()){
                     udp.setForeground(Color.ORANGE);
                 }
                 else{
                     udp.setForeground(Color.GREEN);
                 }
             }
         });
         smtp.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(smtp.isSelected()){
                     smtp.setForeground(Color.ORANGE);
                 }
                 else{
                     smtp.setForeground(Color.GREEN);
                 }
             }
         });
         http.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(http.isSelected()){
                     http.setForeground(Color.ORANGE);
                 }
                 else{
                     http.setForeground(Color.GREEN);
                 }
             }
         });
          tcp.setBorderPainted(false);
          udp.setBorderPainted(false);
          smtp.setBorderPainted(false);
          http.setBorderPainted(false);
          tcp.setForeground(Color.GREEN);
          udp.setForeground(Color.GREEN);
          smtp.setForeground(Color.GREEN);
          http.setForeground(Color.GREEN);
          tcp.setBackground(Color.BLACK);
          udp.setBackground(Color.BLACK);
          smtp.setBackground(Color.BLACK);
          http.setBackground(Color.BLACK);
          udp.setSelected(true);
          ButtonGroup pro_1=new ButtonGroup();
          pro_1.add(tcp);
          pro_1.add(udp);
          pro_1.add(smtp);
          pro_1.add(http);
          datatransfer.add(prolabel_1);
          datatransfer.add(tcp);
          datatransfer.add(udp);
          datatransfer.add(smtp);
          datatransfer.add(http);
         importprotocol.add(datatransfer);
         JPanel secpro=new JPanel();
         secpro.setLayout(new GridLayout(1,5,1,0));
          JLabel prolabel_2=new JLabel("     Security :");
          prolabel_2.setForeground(Color.GREEN);
          secpro.setBackground(Color.BLACK);
          JRadioButton ssh=new JRadioButton("SSH");
          JRadioButton tls=new JRadioButton("TLS");
          JRadioButton ip=new JRadioButton("IP");
          JRadioButton pgp=new JRadioButton("PGP");
          ssh.setUI(new BasicRadioButtonUI(){
              protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
              }
          });
          tls.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         ip.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         pgp.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         ssh.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(ssh.isSelected()){
                     ssh.setForeground(Color.ORANGE);
                 }
                 else{
                     ssh.setForeground(Color.GREEN);
                 }
             }
         });
         tls.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(tls.isSelected()){
                     tls.setForeground(Color.ORANGE);
                 }
                 else{
                     tls.setForeground(Color.GREEN);
                 }
             }
         });
         ip.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(ip.isSelected()){
                     ip.setForeground(Color.ORANGE);
                 }
                 else{
                     ip.setForeground(Color.GREEN);
                 }
             }
         });
         pgp.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(pgp.isSelected()){
                     pgp.setForeground(Color.ORANGE);
                 }
                 else{
                    pgp.setForeground(Color.GREEN);
                 }
             }
         });
          ssh.setBorderPainted(false);
          tls.setBorderPainted(false);
          ip.setBorderPainted(false);
          pgp.setBorderPainted(false);
          ssh.setForeground(Color.GREEN);
          tls.setForeground(Color.GREEN);
          ip.setForeground(Color.GREEN);
          pgp.setForeground(Color.GREEN);
          ssh.setBackground(Color.BLACK);
          tls.setBackground(Color.BLACK);
          ip.setBackground(Color.BLACK);
          pgp.setBackground(Color.BLACK);
          ip.setSelected(true);
          ButtonGroup pro_2=new ButtonGroup();
          pro_2.add(ssh);
          pro_2.add(tls);
          pro_2.add(ip);
          pro_2.add(pgp);
          secpro.add(prolabel_2);
          secpro.add(ssh);
          secpro.add(tls);
          secpro.add(ip);
          secpro.add(pgp);
         importprotocol.add(secpro);
         JPanel compro=new JPanel();
         compro.setLayout(new GridLayout(1,5,1,0));
          JLabel prolabel_3=new JLabel("     Communication :");
          prolabel_3.setForeground(Color.GREEN);
          compro.setBackground(Color.BLACK);
          JRadioButton pop3=new JRadioButton("POP3");
          JRadioButton imap=new JRadioButton("IMAP");
          JRadioButton dns=new JRadioButton("DNS");
          JRadioButton sip=new JRadioButton("SIP");
          pop3.setUI(new BasicRadioButtonUI(){
              protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
              }
          });
          imap.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         dns.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         sip.setUI(new BasicRadioButtonUI(){
             protected void paintFocus(Graphics g,Rectangle r,Dimension d){
 
             }
         });
         pop3.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(pop3.isSelected()){
                     pop3.setForeground(Color.ORANGE);
                 }
                 else{
                     pop3.setForeground(Color.GREEN);
                 }
             }
         });
         imap.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(imap.isSelected()){
                     imap.setForeground(Color.ORANGE);
                 }
                 else{
                     imap.setForeground(Color.GREEN);
                 }
             }
         });
         dns.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(dns.isSelected()){
                     dns.setForeground(Color.ORANGE);
                 }
                 else{
                     dns.setForeground(Color.GREEN);
                 }
             }
         });
         sip.addChangeListener(new ChangeListener(){
             public void stateChanged(ChangeEvent e){
                 if(sip.isSelected()){
                     sip.setForeground(Color.ORANGE);
                 }
                 else{
                    sip.setForeground(Color.GREEN);
                 }
             }
         });
          pop3.setBorderPainted(false);
          imap.setBorderPainted(false);
          dns.setBorderPainted(false);
          sip.setBorderPainted(false);
          pop3.setForeground(Color.GREEN);
          imap.setForeground(Color.GREEN);
          dns.setForeground(Color.GREEN);
          sip.setForeground(Color.GREEN);
          pop3.setBackground(Color.BLACK);
          imap.setBackground(Color.BLACK);
          dns.setBackground(Color.BLACK);
          sip.setBackground(Color.BLACK);
          imap.setSelected(true);
          ButtonGroup pro_3=new ButtonGroup();
          pro_3.add(pop3);
          pro_3.add(imap);
          pro_3.add(dns);
          pro_3.add(sip);
          compro.add(prolabel_3);
          compro.add(pop3);
          compro.add(imap);
          compro.add(dns);
          compro.add(sip);
         importprotocol.add(compro);
         importpanel.add(importradio);
         importpanel.add(importprotocol);
         JRadioButton yes=new JRadioButton("Yes");
            JRadioButton no=new JRadioButton("No");
            yes.setForeground(Color.GREEN);
            yes.setBackground(Color.BLACK);
            yes.setBorderPainted(false);
            yes.setUI(new BasicRadioButtonUI(){
                protected void paintFocus(Graphics g,Rectangle r,Dimension d){
    
                }
            });
            yes.addChangeListener(new ChangeListener(){
                public void stateChanged(ChangeEvent e){
                    if(yes.isSelected()){
                        yes.setForeground(Color.ORANGE);
                    }
                    else{
                        yes.setForeground(Color.GREEN);
                    }
                }
            });
            no.setForeground(Color.GREEN);
            no.setBackground(Color.BLACK);
            no.setBorderPainted(false);
            no.setUI(new BasicRadioButtonUI(){
                protected void paintFocus(Graphics g,Rectangle r,Dimension d){
    
                }
            });
            no.addChangeListener(new ChangeListener(){
                public void stateChanged(ChangeEvent e){
                    if(no.isSelected()){
                        no.setForeground(Color.ORANGE);
                    }
                    else{
                        no.setForeground(Color.GREEN);
                    }
                }
            });
           JRadioButton g1=new JRadioButton("Group 1");
           JRadioButton g2=new JRadioButton("Group 2");
           JRadioButton g3=new JRadioButton("Group 3");//temporarely but we pass actual group name from database
           g1.setForeground(Color.GREEN);
           g1.setBackground(Color.BLACK);
           g1.setBorderPainted(false);
           g1.setUI(new BasicRadioButtonUI(){
               protected void paintFocus(Graphics g,Rectangle r,Dimension d){
   
               }
           });
           g1.addChangeListener(new ChangeListener(){
               public void stateChanged(ChangeEvent e){
                   if(g1.isSelected()){
                       g1.setForeground(Color.ORANGE);
                   }
                   else{
                       g1.setForeground(Color.GREEN);
                   }
               }
           });
           g2.setForeground(Color.GREEN);
           g2.setBackground(Color.BLACK);
           g2.setBorderPainted(false);
           g2.setUI(new BasicRadioButtonUI(){
               protected void paintFocus(Graphics g,Rectangle r,Dimension d){
   
               }
           });
           g2.addChangeListener(new ChangeListener(){
               public void stateChanged(ChangeEvent e){
                   if(g2.isSelected()){
                       g2.setForeground(Color.ORANGE);
                   }
                   else{
                       g2.setForeground(Color.GREEN);
                   }
               }
           });
           g3.setForeground(Color.GREEN);
           g3.setBackground(Color.BLACK);
           g3.setBorderPainted(false);
           g3.setUI(new BasicRadioButtonUI(){
               protected void paintFocus(Graphics g,Rectangle r,Dimension d){
   
               }
           });
           g3.addChangeListener(new ChangeListener(){
               public void stateChanged(ChangeEvent e){
                   if(g3.isSelected()){
                       g3.setForeground(Color.ORANGE);
                   }
                   else{
                       g3.setForeground(Color.GREEN);
                   }
               }
           });
           JDialog devicepop=new JDialog(this);
         JPanel devicepanel=new JPanel();
         devicepanel.setLayout(new GridLayout(11,1,0,2));
         devicepanel.setBackground(Color.BLACK);
         ImageIcon devicei = new ImageIcon("./image/import.png");
              Image deviceio=devicei.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
               ImageIcon deviceion=new ImageIcon(deviceio);
              MatteBorder importb=new MatteBorder(2,2,2,2,Color.DARK_GRAY);
               devicepop.add(devicepanel);
               devicepop.setIconImage(deviceion.getImage());
               devicepop.setTitle("Local Device Connection");
               devicepop.setSize((sizefdpop.width/2),(sizefdpop.height/2));
               devicepanel.setSize((sizefdpop.width/2),(sizefdpop.height/2));
               devicepop.setModal(true);
               devicepop.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
               devicepop.setLocationRelativeTo(null);
            JDialog intranetpop=new JDialog(this);
            JPanel intranetpanel=new JPanel();
            intranetpanel.setLayout(new GridLayout(14,1,3,0));
            intranetpanel.setBackground(Color.BLACK);
            ImageIcon intraneti = new ImageIcon("./image/import.png");
                Image intranetio=intraneti.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
                    ImageIcon intranetion=new ImageIcon(intranetio);
                    intranetpop.add(intranetpanel);
                    intranetpop.setIconImage(intranetion.getImage());
                    intranetpop.setTitle("Intranet Connection");
                    intranetpop.setSize((sizefdpop.width/2),(sizefdpop.height/2));
                    intranetpanel.setSize((sizefdpop.width/2),(sizefdpop.height/2));
                    intranetpop.setModal(true);
                    intranetpop.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    intranetpop.setLocationRelativeTo(null);
            JDialog orbcommpop=new JDialog(this);
            JPanel orbcommpanel=new JPanel();
            orbcommpanel.setLayout(new GridLayout(12,1,2,0));
            orbcommpanel.setBackground(Color.BLACK);
            ImageIcon orbcommi = new ImageIcon("./image/import.png");
                Image orbcommio=orbcommi.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
                ImageIcon orbcommion=new ImageIcon(orbcommio);
                orbcommpop.add(orbcommpanel);
                orbcommpop.setIconImage(orbcommion.getImage());
                orbcommpop.setTitle("Orb Connection");
                orbcommpop.setSize((sizefdpop.width/2),(sizefdpop.height/2));
                orbcommpanel.setSize((sizefdpop.width/2),(sizefdpop.height/2));
                orbcommpop.setModal(true);
                orbcommpop.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                orbcommpop.setLocationRelativeTo(null);
            JDialog internetpop=new JDialog(this);
            JPanel internetpanel=new JPanel();
            internetpanel.setLayout(new GridLayout(10,1,2,0));
            internetpanel.setBackground(Color.BLACK);
            ImageIcon interneti = new ImageIcon("./image/import.png");
                Image internetio=interneti.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
                ImageIcon internetion=new ImageIcon(internetio);
                internetpop.add(internetpanel);
                internetpop.setIconImage(internetion.getImage());
                internetpop.setTitle("Internet Connection");
                internetpop.setSize((sizefdpop.width/2),(sizefdpop.height/2));
                internetpanel.setSize((sizefdpop.width/2),(sizefdpop.height/2));
                internetpop.setModal(true);
                internetpop.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                internetpop.setLocationRelativeTo(null);
         JLabel importnext=new JLabel("Next");
         importnext.setCursor(c);
         importnext.setFont(new Font("Serif",Font.BOLD,15));
         importnext.addMouseListener(new MouseAdapter(){
             public void mouseEntered(MouseEvent e){
             importnext.setForeground(Color.YELLOW);
             importnext.setFont(new Font("Serif",Font.BOLD,20));
           }
           public void mouseExited(MouseEvent e){
             importnext.setForeground(Color.CYAN);
             importnext.setFont(new Font("Serif",Font.BOLD,15));
           }
           public void mouseClicked(MouseEvent e){
            JLabel importloc=new JLabel();
            importloc.setLayout(new GridLayout(1,3,2,0));
            JLabel importlocicon=new JLabel();
            importlocicon.setIcon(deviceion);
            importlocicon.setHorizontalTextPosition(JLabel.CENTER);
            importlocicon.setHorizontalAlignment(JLabel.CENTER);
            importlocicon.setCursor(c);
            JLabel importloclabel=new JLabel("Location : ");
            importloclabel.setFont(new Font("Serif",Font.BOLD,15));
            importloclabel.setForeground(Color.CYAN);
            importloclabel.setHorizontalTextPosition(JLabel.CENTER);
            importloclabel.setHorizontalAlignment(JLabel.CENTER);
            JTextField importlocpath=new JTextField();
            importlocpath.setBorder(importb);
            importlocpath.setFont(new Font("Serif",Font.BOLD,15));
            importlocpath.setForeground(Color.CYAN);
            importlocpath.setBackground(Color.BLACK);
            importlocpath.setSelectedTextColor(new Color(3, 252, 7));
            importlocpath.setSelectionColor(Color.DARK_GRAY);
            importlocpath.setCaretColor(Color.CYAN);
            importlocpath.setBorder(null);
            importloc.add(importloclabel);
            importloc.add(importlocpath);
            importloc.add(importlocicon);
            
            Toolkit tfd=Toolkit.getDefaultToolkit();
                    Dimension sizefd=tfd.getScreenSize();
                    JPanel loginpanel=new JPanel();
                    JLabel usermain=new JLabel();
                    usermain.setLayout(new GridLayout(1,2,2,0));
                    JLabel userlabel=new JLabel("Orb ID : ");
                    userlabel.setFont(new Font("Serif",Font.BOLD,15));
                    userlabel.setForeground(Color.CYAN);
                    userlabel.setHorizontalTextPosition(JLabel.CENTER);
                    userlabel.setHorizontalAlignment(JLabel.CENTER);
                    JTextField username=new JTextField();
                    username.setFont(new Font("Serif",Font.BOLD,15));
                    username.setForeground(Color.CYAN);
                    username.setBackground(Color.BLACK);
                    username.setSelectedTextColor(new Color(3, 252, 7));
                    username.setSelectionColor(Color.DARK_GRAY);
                    username.setCaretColor(Color.CYAN);
                    username.setBorder(null);
                    usermain.add(userlabel);
                    usermain.add(username);
                    JLabel passmain=new JLabel();
                    passmain.setLayout(new GridLayout(1,2,2,0));
                    JLabel passlabel=new JLabel("Orb Password : ");
                    passlabel.setFont(new Font("Serif",Font.BOLD,15));
                    passlabel.setForeground(Color.CYAN);
                    passlabel.setHorizontalTextPosition(JLabel.CENTER);
                    passlabel.setHorizontalAlignment(JLabel.CENTER);
                    JPasswordField passname=new JPasswordField();
                    passname.setFont(new Font("Serif",Font.BOLD,10));
                    passname.setForeground(Color.CYAN);
                    passname.setBackground(Color.BLACK);
                    passname.setSelectedTextColor(new Color(3, 252, 7));
                    passname.setSelectionColor(Color.DARK_GRAY);
                    passname.setCaretColor(Color.CYAN);
                    passname.setBorder(null);
                    passmain.add(passlabel);
                    passmain.add(passname);
        
            JLabel importbro=new JLabel();
            importbro.setLayout(new GridLayout(1,3,2,0));
            JLabel importbroicon=new JLabel();
            importbroicon.setIcon(deviceion);
            importbroicon.setHorizontalTextPosition(JLabel.CENTER);
            importbroicon.setHorizontalAlignment(JLabel.CENTER);
            importbroicon.setCursor(c);
            JLabel importbrolabel=new JLabel("Browse : ");
            importbrolabel.setFont(new Font("Serif",Font.BOLD,15));
            importbrolabel.setForeground(Color.CYAN);
            importbrolabel.setHorizontalTextPosition(JLabel.CENTER);
            importbrolabel.setHorizontalAlignment(JLabel.CENTER);
            importbro.add(importbrolabel);
            importbro.add(Box.createGlue());
            importbro.add(importbroicon);

            JLabel importcomm=new JLabel();
            importcomm.setLayout(new GridLayout(1,3,2,0));
            JLabel importcommicon=new JLabel();
            importcommicon.setIcon(deviceion);
            importcommicon.setHorizontalTextPosition(JLabel.CENTER);
            importcommicon.setHorizontalAlignment(JLabel.CENTER);
            importcommicon.setCursor(c);
            JLabel importcommlabel=new JLabel("Command : ");
            importcommlabel.setFont(new Font("Serif",Font.BOLD,15));
            importcommlabel.setForeground(Color.CYAN);
            importcommlabel.setHorizontalTextPosition(JLabel.CENTER);
            importcommlabel.setHorizontalAlignment(JLabel.CENTER);
            JTextArea importcommpath=new JTextArea();
            importcommpath.setFont(new Font("Serif",Font.BOLD,15));
            importcommpath.setForeground(Color.CYAN);
            importcommpath.setBackground(Color.BLACK);
            importcommpath.setSelectedTextColor(new Color(3, 252, 7));
            importcommpath.setSelectionColor(Color.DARK_GRAY);
            importcommpath.setCaretColor(Color.CYAN);
            importcommpath.setBorder(null);
            JScrollPane importcommsc=new JScrollPane(importcommpath);
            
            importcommsc.setBorder(importb);
            importcommsc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            importcommsc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            JPanel importcotecorner=new JPanel();
            importcotecorner.setBackground(new Color(3, 252, 7));
            importcommsc.setCorner(importcommsc.LOWER_RIGHT_CORNER, cotecorner);
            JScrollBar importcommscvbar=importcommsc.getVerticalScrollBar();
            importcommscvbar.setCursor(c);
            importcommscvbar.setPreferredSize(new Dimension(7,7));
            JScrollBar importcommschbar=importcommsc.getHorizontalScrollBar();
            importcommschbar.setCursor(c);
            importcommschbar.setPreferredSize(new Dimension(7,7));
            importcommscvbar.setUI(new fdpscBar());
            importcommschbar.setUI(new fdpscBar());
            importcomm.add(importcommlabel);
            importcomm.add(importcommsc);
            importcomm.add(importcommicon);

            JLabel importselfile=new JLabel();
            importselfile.setLayout(new GridLayout(1,2,2,0));
            JLabel importsel=new JLabel();
            importsel.setText("Temporary.java");
            importsel.setHorizontalTextPosition(JLabel.CENTER);
            importsel.setHorizontalAlignment(JLabel.CENTER);
            importsel.setFont(new Font("Serif",Font.BOLD,15));
            importsel.setForeground(Color.ORANGE);
            JLabel importsellabel=new JLabel();
            importsellabel.setText("Selected File : ");
            importsellabel.setFont(new Font("Serif",Font.BOLD,15));
            importsellabel.setForeground(Color.ORANGE);
            importsellabel.setHorizontalTextPosition(JLabel.CENTER);
            importsellabel.setHorizontalAlignment(JLabel.CENTER);
            importselfile.add(importsellabel);
            importselfile.add(importsel);

            JLabel fconversion=new JLabel();
            fconversion.setLayout(new GridLayout(1,3,2,0));
            JLabel fconversionlabel=new JLabel();
            fconversionlabel.setText("FileConversion : ");
            fconversionlabel.setHorizontalTextPosition(JLabel.CENTER);
            fconversionlabel.setHorizontalAlignment(JLabel.CENTER);
            fconversionlabel.setFont(new Font("Serif",Font.BOLD,15));
            fconversionlabel.setForeground(Color.CYAN);
            ButtonGroup fconbutt=new ButtonGroup();
            fconbutt.add(yes);
            fconbutt.add(no);
            fconversion.add(fconversionlabel);
            fconversion.add(yes);
            fconversion.add(no);

            JLabel groupradio=new JLabel();
            groupradio.setLayout(new GridLayout(1,3,2,0));
            JLabel groupradiolabel=new JLabel();
            groupradiolabel.setText("Select Group : ");
            groupradiolabel.setHorizontalTextPosition(JLabel.CENTER);
            groupradiolabel.setHorizontalAlignment(JLabel.CENTER);
            groupradiolabel.setFont(new Font("Serif",Font.BOLD,15));
            groupradiolabel.setForeground(Color.CYAN);
            JLabel gradioicon=new JLabel();
            gradioicon.setIcon(deviceion);
            gradioicon.setHorizontalTextPosition(JLabel.CENTER);
            gradioicon.setHorizontalAlignment(JLabel.CENTER);
            gradioicon.setCursor(c);
            ButtonGroup gradiobutt=new ButtonGroup();
            gradiobutt.add(g1);
            gradiobutt.add(g2);
            gradiobutt.add(g3);
            groupradio.add(groupradiolabel);
            groupradio.add(g1);
            groupradio.add(g2);
            groupradio.add(g3);
            groupradio.add(gradioicon);

        JLabel conversion=new JLabel();
        conversion.setLayout(new GridLayout(1,4,2,0));
        String[] types1={"java","orb","png","txt","jpeg"};
        String[] types2={"orb","java","png","txt","jpeg"};
        JComboBox<Object> from=new JComboBox<>(types1);
        from.setBackground(Color.BLACK);
        from.setForeground(Color.ORANGE);
        from.setFont(new Font(Font.SERIF,Font.BOLD,18));
        from.setRenderer(new DefaultListCellRenderer(){
            public Component getListCellRendererComponent(JList<?>list,Object value,
            int index,boolean isSelected,boolean cellHasFocus){
                Component c=super.getListCellRendererComponent(list,value,
                index,isSelected,cellHasFocus);
                if(isSelected){
                    c.setBackground(Color.DARK_GRAY);
                    c.setForeground(Color.WHITE);
                }
                else{
                    c.setBackground(Color.BLACK);
                    c.setForeground(Color.CYAN);
                }
                ((JLabel)c).setHorizontalTextPosition(SwingConstants.CENTER);
                ((JLabel)c).setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        });
        from.addPopupMenuListener(new PopupMenuListener(){
            public void popupMenuWillBecomeVisible(PopupMenuEvent e){
                from.setBackground(Color.BLACK);
                from.setFocusable(true);
            }
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e){
                from.setBackground(Color.BLACK);
                from.setFocusable(false);
                // System.out.println("hi");
            }
            public void popupMenuCanceled(PopupMenuEvent e){
                from.setBackground(Color.BLACK);
                from.setFocusable(false);
            }
        });
        class ComboUI extends BasicComboBoxUI{
            public void ComboUI(){
                from.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
                from.setBackground(Color.BLACK);
            }
            protected JButton createArrowButton(){
                JButton butt=super.createArrowButton();
                butt.setCursor(c);
                butt.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
                butt.setBackground(Color.BLACK);
                butt.setForeground(Color.CYAN);
                return butt;
            }
         }
         
        from.setUI(new ComboUI());
        JLabel tolabel=new JLabel();
        tolabel.setText(" To ");
        tolabel.setHorizontalTextPosition(JLabel.CENTER);
        tolabel.setHorizontalAlignment(JLabel.CENTER);
        tolabel.setFont(new Font("Serif",Font.BOLD,15));
        tolabel.setForeground(Color.CYAN);
        JComboBox<String> to=new JComboBox<>(types2);
        to.setBackground(Color.BLACK);
        to.setForeground(Color.ORANGE);
        to.setFont(new Font(Font.SERIF,Font.BOLD,18));
        to.setRenderer(new DefaultListCellRenderer(){
            public Component getListCellRendererComponent(JList<?>list,Object value,
            int index,boolean isSelected,boolean cellHasFocus){
                Component c=super.getListCellRendererComponent(list,value,
                index,isSelected,cellHasFocus);
                if(isSelected){
                    c.setBackground(Color.DARK_GRAY);
                    c.setForeground(Color.WHITE);
                }
                else{
                    c.setBackground(Color.BLACK);
                    c.setForeground(Color.CYAN);
                }
                ((JLabel)c).setHorizontalTextPosition(SwingConstants.CENTER);
                ((JLabel)c).setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        });
        to.addPopupMenuListener(new PopupMenuListener(){
            public void popupMenuWillBecomeVisible(PopupMenuEvent e){
                to.setBackground(Color.BLACK);
                to.setFocusable(true);
            }
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e){
                to.setBackground(Color.BLACK);
                to.setFocusable(false);
                // System.out.println("hi");
            }
            public void popupMenuCanceled(PopupMenuEvent e){
                to.setBackground(Color.BLACK);
                to.setFocusable(false);
            }
        });
        class ComboUI_1 extends BasicComboBoxUI{
            public void ComboUI_1(){
                to.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
                to.setBackground(Color.BLACK);
            }
            protected JButton createArrowButton(){
                JButton butt=super.createArrowButton();
                butt.setCursor(c);
                butt.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
                butt.setBackground(Color.BLACK);
                butt.setForeground(Color.CYAN);
                return butt;
            }
         }
         to.setUI(new ComboUI_1());
        JLabel convertlabel=new JLabel();
        convertlabel.setText(" Convert ");
        convertlabel.setCursor(c);
        convertlabel.setHorizontalTextPosition(JLabel.CENTER);
        convertlabel.setHorizontalAlignment(JLabel.CENTER);
        convertlabel.setFont(new Font("Serif",Font.BOLD,15));
        convertlabel.setForeground(Color.CYAN);
        conversion.add(from);
        conversion.add(tolabel);
        conversion.add(to);
        conversion.add(convertlabel);

        JLabel importconfile=new JLabel();
        importconfile.setLayout(new GridLayout(1,2,2,0));
        JLabel importcon=new JLabel();
        importcon.setText("Temporary.java");
        importcon.setHorizontalTextPosition(JLabel.CENTER);
        importcon.setHorizontalAlignment(JLabel.CENTER);
        importcon.setFont(new Font("Serif",Font.BOLD,15));
        importcon.setForeground(Color.ORANGE);
        JLabel importconlabel=new JLabel();
        importconlabel.setText("Converted File : ");
        importconlabel.setFont(new Font("Serif",Font.BOLD,15));
        importconlabel.setForeground(Color.ORANGE);
        importconlabel.setHorizontalTextPosition(JLabel.CENTER);
        importconlabel.setHorizontalAlignment(JLabel.CENTER);
        importconfile.add(importconlabel);
        importconfile.add(importcon);

        JLabel importdestloc=new JLabel();
        importdestloc.setLayout(new GridLayout(1,3,2,0));
        JLabel importdestlocicon=new JLabel();
        importdestlocicon.setIcon(deviceion);
        importdestlocicon.setHorizontalTextPosition(JLabel.CENTER);
        importdestlocicon.setHorizontalAlignment(JLabel.CENTER);
        importdestlocicon.setCursor(c);
        JLabel importdestloclabel=new JLabel("Location : ");
        importdestloclabel.setFont(new Font("Serif",Font.BOLD,15));
        importdestloclabel.setForeground(Color.CYAN);
        importdestloclabel.setHorizontalTextPosition(JLabel.CENTER);
        importdestloclabel.setHorizontalAlignment(JLabel.CENTER);
        JTextField importdestlocpath=new JTextField();
        importdestlocpath.setBorder(importb);
        importdestlocpath.setFont(new Font("Serif",Font.BOLD,15));
        importdestlocpath.setForeground(Color.CYAN);
        importdestlocpath.setBackground(Color.BLACK);
        importdestlocpath.setSelectedTextColor(new Color(3, 252, 7));
        importdestlocpath.setSelectionColor(Color.DARK_GRAY);
        importdestlocpath.setCaretColor(Color.CYAN);
        importdestlocpath.setBorder(null);
        importdestloc.add(importdestloclabel);
        importdestloc.add(importdestlocpath);
        importdestloc.add(importdestlocicon);
    
        JLabel importdestbro=new JLabel();
        importdestbro.setLayout(new GridLayout(1,3,2,0));
        JLabel importdestbroicon=new JLabel();
        importdestbroicon.setIcon(deviceion);
        importdestbroicon.setHorizontalTextPosition(JLabel.CENTER);
        importdestbroicon.setHorizontalAlignment(JLabel.CENTER);
        importdestbroicon.setCursor(c);
        JLabel importdestbrolabel=new JLabel("Browse : ");
        importdestbrolabel.setFont(new Font("Serif",Font.BOLD,15));
        importdestbrolabel.setForeground(Color.CYAN);
        importdestbrolabel.setHorizontalTextPosition(JLabel.CENTER);
        importdestbrolabel.setHorizontalAlignment(JLabel.CENTER);
        importdestbro.add(importdestbrolabel);
        importdestbro.add(Box.createGlue());
        importdestbro.add(importdestbroicon);

        JLabel importorberr=new JLabel();
        importorberr.setFont(new Font("Serif",Font.BOLD,13));
        importorberr.setForeground(new Color(255, 133, 77));
        importorberr.setHorizontalTextPosition(JLabel.CENTER);
        importorberr.setHorizontalAlignment(JLabel.CENTER);
        importorberr.setBackground(Color.BLACK);
        // importorberr.setText("This is an error");

        JLabel importok=new JLabel("OK");
        importok.setCursor(c);
        importok.setFont(new Font("Serif",Font.BOLD,15));
        importok.setHorizontalTextPosition(JLabel.CENTER);
        importok.setHorizontalAlignment(JLabel.CENTER);
        importok.setForeground(Color.CYAN);
               if(device.isSelected()){
                devicepanel.add(importloc);
                devicepanel.add(importbro);
                devicepanel.add(importcomm);
                devicepanel.add(importselfile);
                devicepanel.add(fconversion);
                devicepanel.add(conversion);
                devicepanel.add(importconfile);
                devicepanel.add(importdestloc);
                devicepanel.add(importdestbro);
                devicepanel.add(importorberr);
                devicepanel.add(importok);
                 devicepop.setVisible(true);
               }
               if(internet.isSelected()){
                internetpanel.add(importloc);
                internetpanel.add(importcomm);
                internetpanel.add(importselfile);
                internetpanel.add(fconversion);
                internetpanel.add(conversion);
                internetpanel.add(importconfile);
                internetpanel.add(importdestloc);
                internetpanel.add(importdestbro);
                internetpanel.add(importorberr);
                internetpanel.add(importok);
                internetpop.setVisible(true);
              }
              if(orbcomm.isSelected()){
                orbcommpanel.add(usermain);
                orbcommpanel.add(passmain);
                orbcommpanel.add(importloc);
                orbcommpanel.add(importbro);
                orbcommpanel.add(importselfile);
                orbcommpanel.add(fconversion);
                orbcommpanel.add(conversion);
                orbcommpanel.add(importconfile);
                orbcommpanel.add(importdestloc);
                orbcommpanel.add(importdestbro);
                orbcommpanel.add(importorberr);
                orbcommpanel.add(importok);
                orbcommpop.setVisible(true);
              }
               if(intranet.isSelected()){
                   intranetpanel.add(groupradio);
                   intranetpanel.add(usermain);
                   intranetpanel.add(passmain);
                 intranetpanel.add(importloc);
                 intranetpanel.add(importbro);
                 intranetpanel.add(importselfile);
                 intranetpanel.add(fconversion);
                 intranetpanel.add(conversion);
                 intranetpanel.add(importconfile);
                 intranetpanel.add(importdestloc);
                 intranetpanel.add(importdestbro);
                 intranetpanel.add(importorberr);
                 intranetpanel.add(importok);
                 intranetpop.setVisible(true);
               }
           }
         });
         importnext.setHorizontalTextPosition(JLabel.CENTER);
         importnext.setHorizontalAlignment(JLabel.CENTER);
         importnext.setForeground(Color.CYAN);
         importpanel.add(importnext);
         JLabel importerr=new JLabel();
                    importerr.setFont(new Font("Serif",Font.BOLD,13));
                    importerr.setForeground(new Color(255, 133, 77));
                    importerr.setHorizontalTextPosition(JLabel.CENTER);
                    importerr.setHorizontalAlignment(JLabel.CENTER);
                    importerr.setBackground(Color.BLACK);
                    //  importerr.setText("This is an error");
         importpanel.add(importerr);
                    importpop.add(importpanel);
                    importpop.setIconImage(importion.getImage());
                    importpop.setTitle("Import");
                    importpop.setSize((sizefdpop.width/2),(sizefdpop.height/2));
                    importpanel.setSize((sizefdpop.width/2),(sizefdpop.height/2));
                    importpop.setModal(true);
                    importpop.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    importpop.setLocationRelativeTo(null);
         fimport.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
               importpop.setVisible(true);
            }
         });
         JDialog exportpop=new JDialog(this);
         Toolkit tfdpopx=Toolkit.getDefaultToolkit();
         Dimension sizefdpopx=tfdpopx.getScreenSize();
         JPanel exportpanel=new JPanel();
         exportpanel.setBackground(Color.BLACK);
         ImageIcon exporti = new ImageIcon("./image/export.png");
              Image exportio=exporti.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
               ImageIcon exportion=new ImageIcon(exportio);
                    exportpop.add(exportpanel);
                    exportpop.setIconImage(exportion.getImage());
                    exportpop.setTitle("Export");
                    exportpop.setSize((sizefdpopx.width/2),(sizefdpopx.height/2));
                    exportpanel.setSize((sizefdpopx.width/2),(sizefdpopx.height/2));
                    exportpop.setModal(true);
                    exportpop.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    exportpop.setLocationRelativeTo(null);
         fexport.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                        //    System.out.println("hi");
                           exportpop.setVisible(true);
                        }
                     });
         fclose.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
             switch(fileselect){
                 case 1:
                 file1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 file2.setBorder(null);
                         file3.setBorder(null);
                         file4.setBorder(null);
                         file5.setBorder(null);
                         file1butt.setVisible(true);
                         file2butt.setVisible(false);
                         file3butt.setVisible(false);
                         file4butt.setVisible(false);
                         file5butt.setVisible(false);
                         fileselect=1;
                        if(file_1_count<4&((file2.isVisible())||(file3.isVisible())||(file4.isVisible())||(file5.isVisible()))){
                         try{
                             BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                             BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                             int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                             String s_fc_file[]=new String[s_fc_x_file];
                             for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                                 s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                             }
                             meta_1_file.close();
                             meta_2_file.close();
                             File f_file=new File(s_fc_file[1]);
                             BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                             String f_temp_file,f_temp_console_file="";
                             while((f_temp_file=meta_3_file.readLine())!=null){
                                 f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                             }
                             meta_3_file.close();
                           if(f_file.exists()&(file2.getText().equals(f_file.getName()))){
                               index.setText(null);
                               index.setText(" 1  ");
                               codetarea.setText(f_temp_console_file);
                               file2.setText(f_file.getName());
                               for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                       index.append("\n "+f_con_file+" ");
                                }
                           }
                           if((!f_file.exists())||(!(file2.getText().equals(f_file.getName())))){
                             codetarea.setText(null);
                             index.setText(null);
                             codetarea.setText("//  Welcome To Orb");
                             index.setText(" 1  ");
                           }
                         }
                         catch(IOException exc){
               
                     }
                         temp_new=temp_new-1;
                         file1.setText(file2.getText());
                         file2.setText(file3.getText());
                         file3.setText(file4.getText());
                         file4.setText(file5.getText());
                         String file_1_path="";
                         String file_path_after[]=new String[4];
                         try{
                             BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                             for(int i=0;i<1;i++){
                                 file_1_path=file_replace.readLine();
                             }
                             for(int i=0;i<4;i++){
                                 file_path_after[i]=file_replace.readLine();
                             }
                             file_replace.close();
                         }
                         catch(IOException exc){
                           
                         }
                         try{
                             BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                             file_replace.write(file_path_after[0]);
                             file_replace.newLine();
                             file_replace.write(file_path_after[1]);
                             file_replace.newLine();
                             file_replace.write(file_path_after[2]);
                             file_replace.newLine();
                             file_replace.write(file_path_after[3]);
                             file_replace.newLine();
                             file_replace.write(file_1_path);
                             file_replace.flush();
                             file_replace.close();
                         }
                         catch(IOException exc){
                           
                         }
                         if(file2.isVisible()){
                             file_1_count=3;
                         }
                         if(file3.isVisible()){
                             file_1_count=2;
                         }
                         if(file4.isVisible()){
                             file_1_count=1;
                         }
                         if(file5.isVisible()){
                             file_1_count=0;
                         }
                         switch(file_1_count){
                             case 0:
                             file5.setText("File.orb");
                             file5.setVisible(false);
                             break;
                             case 1:
                             file4.setText("File.orb");
                             file4.setVisible(false);
                             break;
                             case 2:
                             file3.setText("File.orb");
                             file3.setVisible(false);
                             break;
                             case 3:
                             file2.setText("File.orb");
                             file2.setVisible(false);
                             break;
                         }
                         file_1_count=file_1_count+1;
                         try{
                                     BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                                     int temp=Integer.parseInt(filebfrtempmeta.readLine());
                                   filebfrtempmeta.close();
                                   temp=temp-1;
                                     String temp_s=Integer.toString(temp);
                                     if(temp<=5){
                                         BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                          filefctemp.write(temp_s);
                                                          filefctemp.flush();
                                                          filefctemp.close();
                                    }
                                 }
                                 catch(IOException exc){
                         
                               }
             }
                 break;
                 case 2:
                 file1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 file2.setBorder(null);
                 file3.setBorder(null);
                 file4.setBorder(null);
                 file5.setBorder(null);
                 file1butt.setVisible(true);
                 file2butt.setVisible(false);
                 file3butt.setVisible(false);
                 file4butt.setVisible(false);
                 file5butt.setVisible(false);
                 fileselect=1;
                 try{
                                 BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                                 BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                                 int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                                 String s_fc_file[]=new String[s_fc_x_file];
                                 for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                                     s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                                 }
                                 meta_1_file.close();
                                 meta_2_file.close();
                                 File f_file=new File(s_fc_file[0]);
                                 BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                                 String f_temp_file,f_temp_console_file="";
                                 while((f_temp_file=meta_3_file.readLine())!=null){
                                     f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                                 }
                                 meta_3_file.close();
                               if(f_file.exists()&(file1.getText().equals(f_file.getName()))){
                                   index.setText(null);
                                   index.setText(" 1  ");
                                   codetarea.setText(f_temp_console_file);
                                   file1.setText(f_file.getName());
                                   for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                           index.append("\n "+f_con_file+" ");
                                    }
                               }
                               if((!f_file.exists())||(!(file1.getText().equals(f_file.getName())))){
                                 codetarea.setText(null);
                                 index.setText(null);
                                 codetarea.setText("//  Welcome To Orb");
                                 index.setText(" 1  ");
                               }
                             }
                             catch(IOException exc){
                   
                           }
                 temp_new=temp_new-1;
                 file2.setText(file3.getText());
                 file3.setText(file4.getText());
                 file4.setText(file5.getText());
                 String file_path_before[]=new String[1];
                 String file_2_path="";
                 String file_path_after[]=new String[3];
                 try{
                     BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                     for(int i=0;i<1;i++){
                         file_path_before[i]=file_replace.readLine();
                     }
                     for(int i=1;i<2;i++){
                         file_2_path=file_replace.readLine();
                     }
                     for(int i=0;i<3;i++){
                         file_path_after[i]=file_replace.readLine();
                     }
                     file_replace.close();
                 }
                 catch(IOException exc){
                   
                 }
                 try{
                     BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                     file_replace.write(file_path_before[0]);
                     file_replace.newLine();
                     file_replace.write(file_path_after[0]);
                     file_replace.newLine();
                     file_replace.write(file_path_after[1]);
                     file_replace.newLine();
                     file_replace.write(file_path_after[2]);
                     file_replace.newLine();
                     file_replace.write(file_2_path);
                     file_replace.flush();
                     file_replace.close();
                 }
                 catch(IOException exc){
                   
                 }
                 if(file2.isVisible()){
                     file_2_count=3;
                 }
                 if(file3.isVisible()){
                     file_2_count=2;
                 }
                 if(file4.isVisible()){
                     file_2_count=1;
                 }
                 if(file5.isVisible()){
                     file_2_count=0;
                 }
                 switch(file_2_count){
                     case 0:
                     file5.setText("File.orb");
                     file5.setVisible(false);
                     break;
                     case 1:
                     file4.setText("File.orb");
                     file4.setVisible(false);
                     break;
                     case 2:
                     file3.setText("File.orb");
                     file3.setVisible(false);
                     break;
                     case 3:
                     file2.setText("File.orb");
                     file2.setVisible(false);
                     break;
                 }
                 file_2_count=file_2_count+1;
                 try{
                             BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                             int temp=Integer.parseInt(filebfrtempmeta.readLine());
                           filebfrtempmeta.close();
                           temp=temp-1;
                             String temp_s=Integer.toString(temp);
                             if(temp<=5){
                                 BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                  filefctemp.write(temp_s);
                                                  filefctemp.flush();
                                                  filefctemp.close();
                            }
                         }
                         catch(IOException exc){
                 
                       }
                 break;
                 case 3:
                 file1.setBorder(null);
                 file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 file3.setBorder(null);
                 file4.setBorder(null);
                 file5.setBorder(null);
                 file1butt.setVisible(false);
                 file2butt.setVisible(true);
                 file3butt.setVisible(false);
                 file4butt.setVisible(false);
                 file5butt.setVisible(false);
                 fileselect=2;
                 try{
                     BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                     BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                     int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                     String s_fc_file[]=new String[s_fc_x_file];
                     for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                         s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                     }
                     meta_1_file.close();
                     meta_2_file.close();
                     File f_file=new File(s_fc_file[1]);
                     BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                     String f_temp_file,f_temp_console_file="";
                     while((f_temp_file=meta_3_file.readLine())!=null){
                         f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                     }
                     meta_3_file.close();
                   if(f_file.exists()&(file2.getText().equals(f_file.getName()))){
                       index.setText(null);
                       index.setText(" 1  ");
                       codetarea.setText(f_temp_console_file);
                       for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                               index.append("\n "+f_con_file+" ");
                        }
                   }
                   if((!f_file.exists())||(!(file2.getText().equals(f_file.getName())))){
                     codetarea.setText(null);
                     index.setText(null);
                     codetarea.setText("//  Welcome To Orb");
                     index.setText(" 1  ");
                   }
                 }
                 catch(IOException exc){
       
               }
                 temp_new=temp_new-1;
                 file3.setText(file4.getText());
                 file4.setText(file5.getText());
                 String file_path_before_3[]=new String[2];
                 String file_3_path="";
                 String file_path_after_3[]=new String[2];
                 try{
                     BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                     for(int i=0;i<2;i++){
                         file_path_before_3[i]=file_replace.readLine();
                     }
                     for(int i=2;i<3;i++){
                         file_3_path=file_replace.readLine();
                     }
                     for(int i=0;i<2;i++){
                         file_path_after_3[i]=file_replace.readLine();
                     }
                     file_replace.close();
                 }
                 catch(IOException exc){
                   
                 }
                 try{
                     BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                     file_replace.write(file_path_before_3[0]);
                     file_replace.newLine();
                     file_replace.write(file_path_before_3[1]);
                     file_replace.newLine();
                     file_replace.write(file_path_after_3[0]);
                     file_replace.newLine();
                     file_replace.write(file_path_after_3[1]);
                     file_replace.newLine();
                     file_replace.write(file_3_path);
                     file_replace.flush();
                     file_replace.close();
                 }
                 catch(IOException exc){
                   
                 }
                 if(file3.isVisible()){
                     file_3_count=2;
                 }
                 if(file4.isVisible()){
                     file_3_count=1;
                 }
                 if(file5.isVisible()){
                     file_3_count=0;
                 }
                 switch(file_3_count){
                     case 0:
                     file5.setText("File.orb");
                     file5.setVisible(false);
                     break;
                     case 1:
                     file4.setText("File.orb");
                     file4.setVisible(false);
                     break;
                     case 2:
                     file3.setText("File.orb");
                     file3.setVisible(false);
                     break;
                 }
                 file_3_count=file_3_count+1;
                 try{
                             BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                             int temp=Integer.parseInt(filebfrtempmeta.readLine());
                           filebfrtempmeta.close();
                           temp=temp-1;
                             String temp_s=Integer.toString(temp);
                             if(temp<=5){
                                 BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                  filefctemp.write(temp_s);
                                                  filefctemp.flush();
                                                  filefctemp.close();
                            }
                         }
                         catch(IOException exc){
                 
                       }
                 break;
                 case 4:
                 file1.setBorder(null);
                 file2.setBorder(null);
                 file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 file4.setBorder(null);
                 file5.setBorder(null);
                 file1butt.setVisible(false);
                 file2butt.setVisible(false);
                 file3butt.setVisible(true);
                 file4butt.setVisible(false);
                 file5butt.setVisible(false);
                 fileselect=3;
                 try{
                     BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                     BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                     int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                     String s_fc_file[]=new String[s_fc_x_file];
                     for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                         s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                     }
                     meta_1_file.close();
                     meta_2_file.close();
                     File f_file=new File(s_fc_file[2]);
                     BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                     String f_temp_file,f_temp_console_file="";
                     while((f_temp_file=meta_3_file.readLine())!=null){
                         f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                     }
                     meta_3_file.close();
                   if(f_file.exists()&(file3.getText().equals(f_file.getName()))){
                       index.setText(null);
                       index.setText(" 1  ");
                       codetarea.setText(f_temp_console_file);
                       file3.setText(f_file.getName());
                       for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                               index.append("\n "+f_con_file+" ");
                        }
                   }
                   if((!f_file.exists())||(!(file3.getText().equals(f_file.getName())))){
                     codetarea.setText(null);
                     index.setText(null);
                     codetarea.setText("//  Welcome To Orb");
                     index.setText(" 1  ");
                   }
                 }
                 catch(IOException exc){
       
               }
                 temp_new=temp_new-1;
                 file4.setText(file5.getText());
                 String file_path_before_4[]=new String[3];
                 String file_4_path="";
                 String file_path_after_4[]=new String[1];
                 try{
                     BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                     for(int i=0;i<3;i++){
                         file_path_before_4[i]=file_replace.readLine();
                     }
                     for(int i=3;i<4;i++){
                         file_4_path=file_replace.readLine();
                     }
                     for(int i=0;i<1;i++){
                         file_path_after_4[i]=file_replace.readLine();
                     }
                     file_replace.close();
                 }
                 catch(IOException exc){
                   
                 }
                 try{
                     BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                     file_replace.write(file_path_before_4[0]);
                     file_replace.newLine();
                     file_replace.write(file_path_before_4[1]);
                     file_replace.newLine();
                     file_replace.write(file_path_before_4[0]);
                     file_replace.newLine();
                     file_replace.write(file_path_after_4[0]);
                     file_replace.newLine();
                     file_replace.write(file_4_path);
                     file_replace.flush();
                     file_replace.close();
                 }
                 catch(IOException exc){
                   
                 }
                 if(file4.isVisible()){
                     file_4_count=1;
                 }
                 if(file5.isVisible()){
                     file_4_count=0;
                 }
                 switch(file_4_count){
                     case 0:
                     file5.setText("File.orb");
                     file5.setVisible(false);
                     break;
                     case 1:
                     file4.setText("File.orb");
                     file4.setVisible(false);
                     break;
                 }
                 file_4_count=file_4_count+1;
                 try{
                             BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                             int temp=Integer.parseInt(filebfrtempmeta.readLine());
                           filebfrtempmeta.close();
                           temp=temp-1;
                             String temp_s=Integer.toString(temp);
                             if(temp<=5){
                                 BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                  filefctemp.write(temp_s);
                                                  filefctemp.flush();
                                                  filefctemp.close();
                            }
                         }
                         catch(IOException exc){
                 
                       }
                 break;
                 case 5:
                 file1.setBorder(null);
                    file2.setBorder(null);
                    file3.setBorder(null);
                    file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                    file5.setBorder(null);
                    file1butt.setVisible(false);
                    file2butt.setVisible(false);
                    file3butt.setVisible(false);
                    file4butt.setVisible(true);
                    file5butt.setVisible(false);
                    fileselect=4;
                    try{
                        BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                        BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                        int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                        String s_fc_file[]=new String[s_fc_x_file];
                        for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                            s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                        }
                        meta_1_file.close();
                        meta_2_file.close();
                        File f_file=new File(s_fc_file[3]);
                        BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                        String f_temp_file,f_temp_console_file="";
                        while((f_temp_file=meta_3_file.readLine())!=null){
                            f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                        }
                        meta_3_file.close();
                      if(f_file.exists()&(file4.getText().equals(f_file.getName()))){
                          index.setText(null);
                          index.setText(" 1  ");
                          codetarea.setText(f_temp_console_file);
                          file4.setText(f_file.getName());
                          for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                  index.append("\n "+f_con_file+" ");
                           }
                      }
                      if((!f_file.exists())||(!(file4.getText().equals(f_file.getName())))){
                        codetarea.setText(null);
                        index.setText(null);
                        codetarea.setText("//  Welcome To Orb");
                        index.setText(" 1  ");
                      }
                    }
                    catch(IOException exc){
          
                  }
                  file5.setText("File.orb");
                  file5.setVisible(false);
                  temp_new=temp_new-1;
                  try{
                    BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                    int temp=Integer.parseInt(filebfrtempmeta.readLine());
                  filebfrtempmeta.close();
                  temp=temp-1;
                    String temp_s=Integer.toString(temp);
                    if(temp<=5){
                        BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                         filefctemp.write(temp_s);
                                         filefctemp.flush();
                                         filefctemp.close();
                   }
                }
                catch(IOException exc){
        
              }
                 break;
             }
           }
         });
         farrclose.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              switch(fileselect){
                  case 1:
                  file1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                  file2.setBorder(null);
                          file3.setBorder(null);
                          file4.setBorder(null);
                          file5.setBorder(null);
                          file1butt.setVisible(true);
                          file2butt.setVisible(false);
                          file3butt.setVisible(false);
                          file4butt.setVisible(false);
                          file5butt.setVisible(false);
                          fileselect=1;
                         if(file_1_count<4&((file2.isVisible())||(file3.isVisible())||(file4.isVisible())||(file5.isVisible()))){
                          try{
                              BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                              BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                              int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                              String s_fc_file[]=new String[s_fc_x_file];
                              for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                                  s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                              }
                              meta_1_file.close();
                              meta_2_file.close();
                              File f_file=new File(s_fc_file[1]);
                              BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                              String f_temp_file,f_temp_console_file="";
                              while((f_temp_file=meta_3_file.readLine())!=null){
                                  f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                              }
                              meta_3_file.close();
                            if(f_file.exists()&(file2.getText().equals(f_file.getName()))){
                                index.setText(null);
                                index.setText(" 1  ");
                                codetarea.setText(f_temp_console_file);
                                file2.setText(f_file.getName());
                                for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                        index.append("\n "+f_con_file+" ");
                                 }
                            }
                            if((!f_file.exists())||(!(file2.getText().equals(f_file.getName())))){
                              codetarea.setText(null);
                              index.setText(null);
                              codetarea.setText("//  Welcome To Orb");
                              index.setText(" 1  ");
                            }
                          }
                          catch(IOException exc){
                
                      }
                          temp_new=temp_new-1;
                          file1.setText(file2.getText());
                          file2.setText(file3.getText());
                          file3.setText(file4.getText());
                          file4.setText(file5.getText());
                          String file_1_path="";
                          String file_path_after[]=new String[4];
                          try{
                              BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                              for(int i=0;i<1;i++){
                                  file_1_path=file_replace.readLine();
                              }
                              for(int i=0;i<4;i++){
                                  file_path_after[i]=file_replace.readLine();
                              }
                              file_replace.close();
                          }
                          catch(IOException exc){
                            
                          }
                          try{
                              BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                              file_replace.write(file_path_after[0]);
                              file_replace.newLine();
                              file_replace.write(file_path_after[1]);
                              file_replace.newLine();
                              file_replace.write(file_path_after[2]);
                              file_replace.newLine();
                              file_replace.write(file_path_after[3]);
                              file_replace.newLine();
                              file_replace.write(file_1_path);
                              file_replace.flush();
                              file_replace.close();
                          }
                          catch(IOException exc){
                            
                          }
                          if(file2.isVisible()){
                              file_1_count=3;
                          }
                          if(file3.isVisible()){
                              file_1_count=2;
                          }
                          if(file4.isVisible()){
                              file_1_count=1;
                          }
                          if(file5.isVisible()){
                              file_1_count=0;
                          }
                          switch(file_1_count){
                              case 0:
                              file5.setText("File.orb");
                              file5.setVisible(false);
                              break;
                              case 1:
                              file4.setText("File.orb");
                              file4.setVisible(false);
                              break;
                              case 2:
                              file3.setText("File.orb");
                              file3.setVisible(false);
                              break;
                              case 3:
                              file2.setText("File.orb");
                              file2.setVisible(false);
                              break;
                          }
                          file_1_count=file_1_count+1;
                          try{
                                      BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                                      int temp=Integer.parseInt(filebfrtempmeta.readLine());
                                    filebfrtempmeta.close();
                                    temp=temp-1;
                                      String temp_s=Integer.toString(temp);
                                      if(temp<=5){
                                          BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                           filefctemp.write(temp_s);
                                                           filefctemp.flush();
                                                           filefctemp.close();
                                     }
                                  }
                                  catch(IOException exc){
                          
                                }
              }
                  break;
                  case 2:
                  file1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                  file2.setBorder(null);
                  file3.setBorder(null);
                  file4.setBorder(null);
                  file5.setBorder(null);
                  file1butt.setVisible(true);
                  file2butt.setVisible(false);
                  file3butt.setVisible(false);
                  file4butt.setVisible(false);
                  file5butt.setVisible(false);
                  fileselect=1;
                  try{
                                  BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                                  BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                                  int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                                  String s_fc_file[]=new String[s_fc_x_file];
                                  for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                                      s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                                  }
                                  meta_1_file.close();
                                  meta_2_file.close();
                                  File f_file=new File(s_fc_file[0]);
                                  BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                                  String f_temp_file,f_temp_console_file="";
                                  while((f_temp_file=meta_3_file.readLine())!=null){
                                      f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                                  }
                                  meta_3_file.close();
                                if(f_file.exists()&(file1.getText().equals(f_file.getName()))){
                                    index.setText(null);
                                    index.setText(" 1  ");
                                    codetarea.setText(f_temp_console_file);
                                    file1.setText(f_file.getName());
                                    for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                            index.append("\n "+f_con_file+" ");
                                     }
                                }
                                if((!f_file.exists())||(!(file1.getText().equals(f_file.getName())))){
                                  codetarea.setText(null);
                                  index.setText(null);
                                  codetarea.setText("//  Welcome To Orb");
                                  index.setText(" 1  ");
                                }
                              }
                              catch(IOException exc){
                    
                            }
                  temp_new=temp_new-1;
                  file2.setText(file3.getText());
                  file3.setText(file4.getText());
                  file4.setText(file5.getText());
                  String file_path_before[]=new String[1];
                  String file_2_path="";
                  String file_path_after[]=new String[3];
                  try{
                      BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                      for(int i=0;i<1;i++){
                          file_path_before[i]=file_replace.readLine();
                      }
                      for(int i=1;i<2;i++){
                          file_2_path=file_replace.readLine();
                      }
                      for(int i=0;i<3;i++){
                          file_path_after[i]=file_replace.readLine();
                      }
                      file_replace.close();
                  }
                  catch(IOException exc){
                    
                  }
                  try{
                      BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                      file_replace.write(file_path_before[0]);
                      file_replace.newLine();
                      file_replace.write(file_path_after[0]);
                      file_replace.newLine();
                      file_replace.write(file_path_after[1]);
                      file_replace.newLine();
                      file_replace.write(file_path_after[2]);
                      file_replace.newLine();
                      file_replace.write(file_2_path);
                      file_replace.flush();
                      file_replace.close();
                  }
                  catch(IOException exc){
                    
                  }
                  if(file2.isVisible()){
                      file_2_count=3;
                  }
                  if(file3.isVisible()){
                      file_2_count=2;
                  }
                  if(file4.isVisible()){
                      file_2_count=1;
                  }
                  if(file5.isVisible()){
                      file_2_count=0;
                  }
                  switch(file_2_count){
                      case 0:
                      file5.setText("File.orb");
                      file5.setVisible(false);
                      break;
                      case 1:
                      file4.setText("File.orb");
                      file4.setVisible(false);
                      break;
                      case 2:
                      file3.setText("File.orb");
                      file3.setVisible(false);
                      break;
                      case 3:
                      file2.setText("File.orb");
                      file2.setVisible(false);
                      break;
                  }
                  file_2_count=file_2_count+1;
                  try{
                              BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                              int temp=Integer.parseInt(filebfrtempmeta.readLine());
                            filebfrtempmeta.close();
                            temp=temp-1;
                              String temp_s=Integer.toString(temp);
                              if(temp<=5){
                                  BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                   filefctemp.write(temp_s);
                                                   filefctemp.flush();
                                                   filefctemp.close();
                             }
                          }
                          catch(IOException exc){
                  
                        }
                  break;
                  case 3:
                  file1.setBorder(null);
                  file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                  file3.setBorder(null);
                  file4.setBorder(null);
                  file5.setBorder(null);
                  file1butt.setVisible(false);
                  file2butt.setVisible(true);
                  file3butt.setVisible(false);
                  file4butt.setVisible(false);
                  file5butt.setVisible(false);
                  fileselect=2;
                  try{
                      BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                      BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                      int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                      String s_fc_file[]=new String[s_fc_x_file];
                      for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                          s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                      }
                      meta_1_file.close();
                      meta_2_file.close();
                      File f_file=new File(s_fc_file[1]);
                      BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                      String f_temp_file,f_temp_console_file="";
                      while((f_temp_file=meta_3_file.readLine())!=null){
                          f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                      }
                      meta_3_file.close();
                    if(f_file.exists()&(file2.getText().equals(f_file.getName()))){
                        index.setText(null);
                        index.setText(" 1  ");
                        codetarea.setText(f_temp_console_file);
                        for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                index.append("\n "+f_con_file+" ");
                         }
                    }
                    if((!f_file.exists())||(!(file2.getText().equals(f_file.getName())))){
                      codetarea.setText(null);
                      index.setText(null);
                      codetarea.setText("//  Welcome To Orb");
                      index.setText(" 1  ");
                    }
                  }
                  catch(IOException exc){
        
                }
                  temp_new=temp_new-1;
                  file3.setText(file4.getText());
                  file4.setText(file5.getText());
                  String file_path_before_3[]=new String[2];
                  String file_3_path="";
                  String file_path_after_3[]=new String[2];
                  try{
                      BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                      for(int i=0;i<2;i++){
                          file_path_before_3[i]=file_replace.readLine();
                      }
                      for(int i=2;i<3;i++){
                          file_3_path=file_replace.readLine();
                      }
                      for(int i=0;i<2;i++){
                          file_path_after_3[i]=file_replace.readLine();
                      }
                      file_replace.close();
                  }
                  catch(IOException exc){
                    
                  }
                  try{
                      BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                      file_replace.write(file_path_before_3[0]);
                      file_replace.newLine();
                      file_replace.write(file_path_before_3[1]);
                      file_replace.newLine();
                      file_replace.write(file_path_after_3[0]);
                      file_replace.newLine();
                      file_replace.write(file_path_after_3[1]);
                      file_replace.newLine();
                      file_replace.write(file_3_path);
                      file_replace.flush();
                      file_replace.close();
                  }
                  catch(IOException exc){
                    
                  }
                  if(file3.isVisible()){
                      file_3_count=2;
                  }
                  if(file4.isVisible()){
                      file_3_count=1;
                  }
                  if(file5.isVisible()){
                      file_3_count=0;
                  }
                  switch(file_3_count){
                      case 0:
                      file5.setText("File.orb");
                      file5.setVisible(false);
                      break;
                      case 1:
                      file4.setText("File.orb");
                      file4.setVisible(false);
                      break;
                      case 2:
                      file3.setText("File.orb");
                      file3.setVisible(false);
                      break;
                  }
                  file_3_count=file_3_count+1;
                  try{
                              BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                              int temp=Integer.parseInt(filebfrtempmeta.readLine());
                            filebfrtempmeta.close();
                            temp=temp-1;
                              String temp_s=Integer.toString(temp);
                              if(temp<=5){
                                  BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                   filefctemp.write(temp_s);
                                                   filefctemp.flush();
                                                   filefctemp.close();
                             }
                          }
                          catch(IOException exc){
                  
                        }
                  break;
                  case 4:
                  file1.setBorder(null);
                  file2.setBorder(null);
                  file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                  file4.setBorder(null);
                  file5.setBorder(null);
                  file1butt.setVisible(false);
                  file2butt.setVisible(false);
                  file3butt.setVisible(true);
                  file4butt.setVisible(false);
                  file5butt.setVisible(false);
                  fileselect=3;
                  try{
                      BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                      BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                      int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                      String s_fc_file[]=new String[s_fc_x_file];
                      for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                          s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                      }
                      meta_1_file.close();
                      meta_2_file.close();
                      File f_file=new File(s_fc_file[2]);
                      BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                      String f_temp_file,f_temp_console_file="";
                      while((f_temp_file=meta_3_file.readLine())!=null){
                          f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                      }
                      meta_3_file.close();
                    if(f_file.exists()&(file3.getText().equals(f_file.getName()))){
                        index.setText(null);
                        index.setText(" 1  ");
                        codetarea.setText(f_temp_console_file);
                        file3.setText(f_file.getName());
                        for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                index.append("\n "+f_con_file+" ");
                         }
                    }
                    if((!f_file.exists())||(!(file3.getText().equals(f_file.getName())))){
                      codetarea.setText(null);
                      index.setText(null);
                      codetarea.setText("//  Welcome To Orb");
                      index.setText(" 1  ");
                    }
                  }
                  catch(IOException exc){
        
                }
                  temp_new=temp_new-1;
                  file4.setText(file5.getText());
                  String file_path_before_4[]=new String[3];
                  String file_4_path="";
                  String file_path_after_4[]=new String[1];
                  try{
                      BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                      for(int i=0;i<3;i++){
                          file_path_before_4[i]=file_replace.readLine();
                      }
                      for(int i=3;i<4;i++){
                          file_4_path=file_replace.readLine();
                      }
                      for(int i=0;i<1;i++){
                          file_path_after_4[i]=file_replace.readLine();
                      }
                      file_replace.close();
                  }
                  catch(IOException exc){
                    
                  }
                  try{
                      BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                      file_replace.write(file_path_before_4[0]);
                      file_replace.newLine();
                      file_replace.write(file_path_before_4[1]);
                      file_replace.newLine();
                      file_replace.write(file_path_before_4[0]);
                      file_replace.newLine();
                      file_replace.write(file_path_after_4[0]);
                      file_replace.newLine();
                      file_replace.write(file_4_path);
                      file_replace.flush();
                      file_replace.close();
                  }
                  catch(IOException exc){
                    
                  }
                  if(file4.isVisible()){
                      file_4_count=1;
                  }
                  if(file5.isVisible()){
                      file_4_count=0;
                  }
                  switch(file_4_count){
                      case 0:
                      file5.setText("File.orb");
                      file5.setVisible(false);
                      break;
                      case 1:
                      file4.setText("File.orb");
                      file4.setVisible(false);
                      break;
                  }
                  file_4_count=file_4_count+1;
                  try{
                              BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                              int temp=Integer.parseInt(filebfrtempmeta.readLine());
                            filebfrtempmeta.close();
                            temp=temp-1;
                              String temp_s=Integer.toString(temp);
                              if(temp<=5){
                                  BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                   filefctemp.write(temp_s);
                                                   filefctemp.flush();
                                                   filefctemp.close();
                             }
                          }
                          catch(IOException exc){
                  
                        }
                  break;
                  case 5:
                  file1.setBorder(null);
                     file2.setBorder(null);
                     file3.setBorder(null);
                     file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                     file5.setBorder(null);
                     file1butt.setVisible(false);
                     file2butt.setVisible(false);
                     file3butt.setVisible(false);
                     file4butt.setVisible(true);
                     file5butt.setVisible(false);
                     fileselect=4;
                     try{
                         BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                         BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                         int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                         String s_fc_file[]=new String[s_fc_x_file];
                         for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                             s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                         }
                         meta_1_file.close();
                         meta_2_file.close();
                         File f_file=new File(s_fc_file[3]);
                         BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                         String f_temp_file,f_temp_console_file="";
                         while((f_temp_file=meta_3_file.readLine())!=null){
                             f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                         }
                         meta_3_file.close();
                       if(f_file.exists()&(file4.getText().equals(f_file.getName()))){
                           index.setText(null);
                           index.setText(" 1  ");
                           codetarea.setText(f_temp_console_file);
                           file4.setText(f_file.getName());
                           for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                   index.append("\n "+f_con_file+" ");
                            }
                       }
                       if((!f_file.exists())||(!(file4.getText().equals(f_file.getName())))){
                         codetarea.setText(null);
                         index.setText(null);
                         codetarea.setText("//  Welcome To Orb");
                         index.setText(" 1  ");
                       }
                     }
                     catch(IOException exc){
           
                   }
                   file5.setText("File.orb");
                   file5.setVisible(false);
                   temp_new=temp_new-1;
                   try{
                     BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                     int temp=Integer.parseInt(filebfrtempmeta.readLine());
                   filebfrtempmeta.close();
                   temp=temp-1;
                     String temp_s=Integer.toString(temp);
                     if(temp<=5){
                         BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                          filefctemp.write(temp_s);
                                          filefctemp.flush();
                                          filefctemp.close();
                    }
                 }
                 catch(IOException exc){
         
               }
                  break;
              }
            }
          });
          cut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                codetarea.cut();
                int prevind=index.getLineCount();
                int codelen=codetarea.getLineCount();
                if(prevind>codelen){
                    try{
                        int start=index.getLineStartOffset(codelen-1);//line codelen-2
                        int end=index.getLineEndOffset(prevind-1);
                        index.replaceRange("", start, end);
                        index.append(" "+index.getLineCount()+"   ");
                    }
                    catch(Exception exc){
                        System.out.println(exc.getMessage());
                    }
                }
            }
          });
          arrcut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                codetarea.cut();
                int prevind=index.getLineCount();
                int codelen=codetarea.getLineCount();
                if(prevind>codelen){
                    try{
                        int start=index.getLineStartOffset(codelen-1);//line codelen-2
                        int end=index.getLineEndOffset(prevind-1);
                        index.replaceRange("", start, end);
                        index.append(" "+index.getLineCount()+"   ");
                    }
                    catch(Exception exc){
                        System.out.println(exc.getMessage());
                    }
                }
            }
          });
          copy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              codetarea.copy();
            }
          });
          arrcopy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              codetarea.copy();
            }
          });
          paste.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                codetarea.paste();
                int prevind=index.getLineCount();
                int codelen=codetarea.getLineCount();
                if(prevind>codelen){
                    try{
                        int start=index.getLineStartOffset(codelen);//line codelen-1
                        int end=index.getLineEndOffset(prevind-1);
                        index.replaceRange("", start, end);
                    }
                    catch(Exception exc){
                        System.out.println(exc.getMessage());
                    }
                }
                if(prevind<=codelen){
                    while(prevind!=codelen){
                              index.append("\n "+(prevind+1)+"   ");
                        prevind++;
                    }
                }
            }
          });
          arrpaste.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                codetarea.paste();
                int prevind=index.getLineCount();
                int codelen=codetarea.getLineCount();
                if(prevind>codelen){
                    try{
                        int start=index.getLineStartOffset(codelen);//line codelen-1
                        int end=index.getLineEndOffset(prevind-1);
                        index.replaceRange("", start, end);
                    }
                    catch(Exception exc){
                        System.out.println(exc.getMessage());
                    }
                }
                if(prevind<=codelen){
                    while(prevind!=codelen){
                              index.append("\n "+(prevind+1)+"   ");
                        prevind++;
                    }
                }
            }
          });
          selectall.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                 codetarea.selectAll();
                 try{
                     int start=0;
                     int end=codetarea.getText().length();
                     Highlighter h=codetarea.getHighlighter();
        DefaultHighlighter.DefaultHighlightPainter 
        dhp=new DefaultHighlighter.DefaultHighlightPainter(Color.DARK_GRAY);
                  h.removeAllHighlights();
                  h.addHighlight(start,end,dhp);
                  }
                 catch(Exception exc){
                     exc.getMessage();
                 }
              }
          });
          arrselectall.addActionListener(new ActionListener(){
              public void actionPerformed(ActionEvent e){
                codetarea.selectAll();
                try{
                    int start=0;
                    int end=codetarea.getText().length();
                    Highlighter h=codetarea.getHighlighter();
       DefaultHighlighter.DefaultHighlightPainter 
       dhp=new DefaultHighlighter.DefaultHighlightPainter(Color.DARK_GRAY);
                 h.removeAllHighlights();
                 h.addHighlight(start,end,dhp);
                 }
                catch(Exception exc){
                    exc.getMessage();
                }
                }
            });
            edit.addMenuListener(new MenuListener(){
                public void menuSelected(MenuEvent e){
  
                }
                public void menuDeselected(MenuEvent e){
                  Highlighter h=codetarea.getHighlighter();
                            h.removeAllHighlights();
                    // System.out.println("hi");
              }
              public void menuCanceled(MenuEvent e){
                    
              }
            });
            JDialog logind=new JDialog(this);
            loginp.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent e){
                    Toolkit tfd=Toolkit.getDefaultToolkit();
                    Dimension sizefd=tfd.getScreenSize();
                    JPanel loginpanel=new JPanel();
                    JLabel usermain=new JLabel();
                    usermain.setLayout(new GridLayout(1,2,2,0));
                    JLabel userlabel=new JLabel("User Name : ");
                    userlabel.setFont(new Font("Serif",Font.BOLD,15));
                    userlabel.setForeground(Color.CYAN);
                    userlabel.setHorizontalTextPosition(JLabel.CENTER);
                    userlabel.setHorizontalAlignment(JLabel.CENTER);
                    JTextField username=new JTextField();
                    username.setFont(new Font("Serif",Font.BOLD,15));
                    username.setForeground(Color.CYAN);
                    username.setBackground(Color.BLACK);
                    username.setSelectedTextColor(new Color(3, 252, 7));
                    username.setSelectionColor(Color.DARK_GRAY);
                    username.setCaretColor(Color.CYAN);
                    username.setBorder(null);
                    usermain.add(userlabel);
                    usermain.add(username);
                    JLabel passmain=new JLabel();
                    passmain.setLayout(new GridLayout(1,2,2,0));
                    JLabel passlabel=new JLabel("Password : ");
                    passlabel.setFont(new Font("Serif",Font.BOLD,15));
                    passlabel.setForeground(Color.CYAN);
                    passlabel.setHorizontalTextPosition(JLabel.CENTER);
                    passlabel.setHorizontalAlignment(JLabel.CENTER);
                    JPasswordField passname=new JPasswordField();
                    passname.setFont(new Font("Serif",Font.BOLD,10));
                    passname.setForeground(Color.CYAN);
                    passname.setBackground(Color.BLACK);
                    passname.setSelectedTextColor(new Color(3, 252, 7));
                    passname.setSelectionColor(Color.DARK_GRAY);
                    passname.setCaretColor(Color.CYAN);
                    passname.setBorder(null);
                    passmain.add(passlabel);
                    passmain.add(passname);
                    JLabel loginbutt=new JLabel("Login");
                    loginbutt.setCursor(c);
                    loginbutt.setFont(new Font("Serif",Font.BOLD,15));
                    loginbutt.addMouseListener(new MouseAdapter(){
                        public void mouseEntered(MouseEvent e){
                        loginbutt.setForeground(new Color(3, 252, 7));
                        loginbutt.setFont(new Font("Serif",Font.BOLD,20));
                      }
                      public void mouseExited(MouseEvent e){
                        loginbutt.setForeground(Color.CYAN);
                        loginbutt.setFont(new Font("Serif",Font.BOLD,15));
                      }
                    });
                    loginbutt.setHorizontalTextPosition(JLabel.CENTER);
                    loginbutt.setHorizontalAlignment(JLabel.CENTER);
                    loginbutt.setForeground(Color.CYAN);
                    loginpanel.setLayout(new GridLayout(6,0,0,2));
                    loginpanel.setBackground(Color.BLACK);
                    JLabel usererr=new JLabel("this is a user error");
                    usererr.setFont(new Font("Serif",Font.BOLD,13));
                    usererr.setForeground(new Color(255, 133, 77));
                    usererr.setHorizontalTextPosition(JLabel.CENTER);
                    usererr.setHorizontalAlignment(JLabel.CENTER);
                    JLabel passerr=new JLabel("this is a password error");
                    passerr.setFont(new Font("Serif",Font.BOLD,13));
                    passerr.setForeground(new Color(255, 133, 77));
                    passerr.setHorizontalTextPosition(JLabel.CENTER);
                    passerr.setHorizontalAlignment(JLabel.CENTER);
                    JLabel loginerr=new JLabel("this is a login error");
                    loginerr.setFont(new Font("Serif",Font.BOLD,13));
                    loginerr.setForeground(new Color(255, 133, 77));
                    loginerr.setHorizontalTextPosition(JLabel.CENTER);
                    loginerr.setHorizontalAlignment(JLabel.CENTER);
                    usererr.setBackground(Color.BLACK);
                    passerr.setBackground(Color.BLACK);
                    loginerr.setBackground(Color.BLACK);
                    loginpanel.add(usermain);
                    loginpanel.add(usererr);
                    loginpanel.add(passmain);
                    loginpanel.add(passerr);
                    loginpanel.add(loginbutt);
                    loginpanel.add(loginerr);
                    ImageIcon logini = new ImageIcon("./image/login.png");
              Image loginio=logini.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
               ImageIcon loginion=new ImageIcon(loginio);
                    logind.add(loginpanel);
                    logind.setIconImage(loginion.getImage());
                    logind.setTitle("User_Login");
                    logind.setModal(true);
                    logind.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    logind.setSize((sizefd.width/2),(sizefd.height/2));
                    loginpanel.setSize((sizefd.width/2),(sizefd.height/2));
                    logind.setLocationRelativeTo(null);
                    logind.setVisible(true);
                   }
            });

          try{

            BufferedReader filesavertempmeta=new BufferedReader(new FileReader(filesavepathmeta));
            BufferedReader filepathrtempmeta=new BufferedReader(new FileReader(filepathmeta));
            //    file1save=Boolean.valueOf(filesavertempmeta.readLine());
            //    file2save=Boolean.valueOf(filesavertempmeta.readLine());
            //    file3save=Boolean.valueOf(filesavertempmeta.readLine());
            //    file4save=Boolean.valueOf(filesavertempmeta.readLine());
            //    file5save=Boolean.valueOf(filesavertempmeta.readLine());
            Boolean filesavearr[]=new Boolean[5];
            String  filepatharr[]=new String[5];
               for(int arr1=0;arr1<5;arr1++){
                   filesavearr[arr1]=Boolean.valueOf(filesavertempmeta.readLine());
                   filepatharr[arr1]=filepathrtempmeta.readLine();
                   File f_temp_file=new File(filepatharr[arr1]);
                   if(!f_temp_file.exists()){
                     filesavearr[arr1]=false;
                   }
               }
               filesavertempmeta.close();
               filepathrtempmeta.close();
            for(int g=1;g<5;g++){
                if(filesavearr[g]==false){
                    for(int b=g+1;b<5;b++){
                        if(filesavearr[b]==true){
                            String temppath=filepatharr[g];
                            filepatharr[g]=filepatharr[b];
                            filepatharr[b]=temppath;
                            filesavearr[b]=false;
                            filesavearr[g]=true;
                            break;
                        }
                    }
            }
            }
            BufferedWriter filesavemetarr=new BufferedWriter(new FileWriter(filesavepathmeta));
            filesavemetarr.write(String.valueOf(filesavearr[0]));
            filesavemetarr.newLine();
            filesavemetarr.write(String.valueOf(filesavearr[1]));
            filesavemetarr.newLine();
            filesavemetarr.write(String.valueOf(filesavearr[2]));
            filesavemetarr.newLine();
            filesavemetarr.write(String.valueOf(filesavearr[3]));
            filesavemetarr.newLine();
            filesavemetarr.write(String.valueOf(filesavearr[4]));
            filesavemetarr.flush();
            filesavemetarr.close();
            BufferedWriter filepathmetarr=new BufferedWriter(new FileWriter(filepathmeta));
            filepathmetarr.write(filepatharr[0]);
            filepathmetarr.newLine();
            filepathmetarr.write(filepatharr[1]);
            filepathmetarr.newLine();
            filepathmetarr.write(filepatharr[2]);
            filepathmetarr.newLine();
            filepathmetarr.write(filepatharr[3]);
            filepathmetarr.newLine();
            filepathmetarr.write(filepatharr[4]);
            filepathmetarr.flush();
            filepathmetarr.close();

              BufferedReader meta_1=new BufferedReader(new FileReader(filefcpathmeta));
              BufferedReader meta_2=new BufferedReader(new FileReader(filepathmeta));
              int s_fc_x=Integer.parseInt(meta_1.readLine());
              meta_1.close();
              String s_fc[]=new String[s_fc_x];
              for(int s_fc_i=0;s_fc_i<s_fc_x;s_fc_i++){
                  s_fc[s_fc_i]=meta_2.readLine();
              }
              meta_2.close();
              File f=new File(s_fc[0]);
              BufferedReader meta_3=new BufferedReader(new FileReader(f.getAbsolutePath()));
              String f_temp,f_temp_console="";
              while((f_temp=meta_3.readLine())!=null){
                  f_temp_console=f_temp_console+f_temp+"\n";
              }
              meta_3.close();
            if(f.exists()){
                String name_for_ext=f.getName();
                String ext="";
                int dot=name_for_ext.lastIndexOf(".");
                if(dot>0&dot<name_for_ext.length()-1){
                    ext=name_for_ext.substring(dot+1);
                }
                switch(ext){
                    case "orb":
                    fileteron_1=orb_exton;
                    fileion_1=orb_exton;
                     break;
                    case "java":
                    fileteron_1=icon_java_ext;
                    fileion_1=icon_java_ext;
                    break;
                  }
                codetarea.setText(f_temp_console);
                file1.setText(f.getName());
                for(int f_con=2;f_con<=codetarea.getLineCount();f_con++){
                        index.append("\n "+f_con+" ");
                 }
            }
            

            Boolean filesavebool[]=new Boolean[4];
            BufferedReader filesavermeta=new BufferedReader(new FileReader(filesavepathmeta));
            filesavermeta.readLine();
            for(int filesavei=0;filesavei<4;filesavei++){
               filesavebool[filesavei]=Boolean.valueOf(filesavermeta.readLine());
            }
            filesavermeta.close();
            switch(s_fc_x){
                case 2:
                File f2_ext=new File(s_fc[1]);
                    String name_for_ext_2=f2_ext.getName();
                    String ext_2="";
                    int dot_2=name_for_ext_2.lastIndexOf(".");
                    if(dot_2>0&dot_2<name_for_ext_2.length()-1){
                        ext_2=name_for_ext_2.substring(dot_2+1);
                    }
                    switch(ext_2){
                        case "orb":
                        fileteron_2=orb_exton;
                        fileion_2=orb_exton;
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
                        fileion_2=icon_java_ext;
                        break;
                      }
                if(filesavebool[0]){
                    File f1_2=new File(s_fc[1]);
                    if(f1_2.exists()){
                        file2.setVisible(true);
                        file2.setText(f1_2.getName());
                    }
                }
                break;
                case 3:
                File f2_ext_3=new File(s_fc[1]);
                    String name_for_ext_2_3=f2_ext_3.getName();
                    String ext_2_3="";
                    int dot_2_3=name_for_ext_2_3.lastIndexOf(".");
                    if(dot_2_3>0&dot_2_3<name_for_ext_2_3.length()-1){
                        ext_2_3=name_for_ext_2_3.substring(dot_2_3+1);
                    }
                    switch(ext_2_3){
                        case "orb":
                        fileteron_2=orb_exton;
                        fileion_2=orb_exton;
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
                        fileion_2=icon_java_ext;
                        break;
                      }
                File f3_ext=new File(s_fc[2]);
                String name_for_ext_3=f3_ext.getName();
                String ext_3="";
                int dot_3=name_for_ext_3.lastIndexOf(".");
                if(dot_3>0&dot_3<name_for_ext_3.length()-1){
                    ext_3=name_for_ext_3.substring(dot_3+1);
                }
                switch(ext_3){
                    case "orb":
                    fileteron_3=orb_exton;
                    fileion_3=orb_exton;
                     break;
                    case "java":
                    fileteron_3=icon_java_ext;
                    fileion_3=icon_java_ext;
                    break;
                  }
                if(filesavebool[0]){
                File f1_3=new File(s_fc[1]);
                if(f1_3.exists()){
                    file2.setVisible(true);
                    file2.setText(f1_3.getName());
                }
                }
                if(filesavebool[1]){
                File f2_3=new File(s_fc[2]);
                if(f2_3.exists()){
                    file3.setVisible(true);
                    file3.setText(f2_3.getName());
                }
                }
                break;
                case 4:
                File f2_ext_4=new File(s_fc[1]);
                    String name_for_ext_2_4=f2_ext_4.getName();
                    String ext_2_4="";
                    int dot_2_4=name_for_ext_2_4.lastIndexOf(".");
                    if(dot_2_4>0&dot_2_4<name_for_ext_2_4.length()-1){
                        ext_2_4=name_for_ext_2_4.substring(dot_2_4+1);
                    }
                    switch(ext_2_4){
                        case "orb":
                        fileteron_2=orb_exton;
                        fileion_2=orb_exton;
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
                        fileion_2=icon_java_ext;
                        break;
                      }
                      File f3_ext_4=new File(s_fc[2]);
                      String name_for_ext_3_4=f3_ext_4.getName();
                      String ext_3_4="";
                      int dot_3_4=name_for_ext_3_4.lastIndexOf(".");
                      if(dot_3_4>0&dot_3_4<name_for_ext_3_4.length()-1){
                          ext_3_4=name_for_ext_3_4.substring(dot_3_4+1);
                      }
                      switch(ext_3_4){
                          case "orb":
                          fileteron_3=orb_exton;
                          fileion_3=orb_exton;
                           break;
                          case "java":
                          fileteron_3=icon_java_ext;
                          fileion_3=icon_java_ext;
                          break;
                        }
                File f4_ext=new File(s_fc[3]);
                String name_for_ext_4=f4_ext.getName();
                String ext_4="";
                int dot_4=name_for_ext_4.lastIndexOf(".");
                if(dot_4>0&dot_4<name_for_ext_4.length()-1){
                    ext_4=name_for_ext_4.substring(dot_4+1);
                }
                switch(ext_4){
                    case "orb":
                    fileteron_4=orb_exton;
                    fileion_4=orb_exton;
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
                    fileion_4=icon_java_ext;
                    break;
                  }
                if(filesavebool[0]){
                File f1_4=new File(s_fc[1]);
                if(f1_4.exists()){
                    file2.setVisible(true);
                    file2.setText(f1_4.getName());
                }
                }
                if(filesavebool[1]){
                File f2_4=new File(s_fc[2]);
                if(f2_4.exists()){
                    file3.setVisible(true);
                    file3.setText(f2_4.getName());
                }
                }
                if(filesavebool[2]){
                File f3_4=new File(s_fc[3]);
                if(f3_4.exists()){
                    file4.setVisible(true);
                    file4.setText(f3_4.getName());
                }
                }
                break;
                case 5:
                File f2_ext_5=new File(s_fc[1]);
                    String name_for_ext_2_5=f2_ext_5.getName();
                    String ext_2_5="";
                    int dot_2_5=name_for_ext_2_5.lastIndexOf(".");
                    if(dot_2_5>0&dot_2_5<name_for_ext_2_5.length()-1){
                        ext_2_5=name_for_ext_2_5.substring(dot_2_5+1);
                    }
                    switch(ext_2_5){
                        case "orb":
                        fileteron_2=orb_exton;
                        fileion_2=orb_exton;
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
                        fileion_2=icon_java_ext;
                        break;
                      }
                      File f3_ext_5=new File(s_fc[2]);
                      String name_for_ext_3_5=f3_ext_5.getName();
                      String ext_3_5="";
                      int dot_3_5=name_for_ext_3_5.lastIndexOf(".");
                      if(dot_3_5>0&dot_3_5<name_for_ext_3_5.length()-1){
                          ext_3_5=name_for_ext_3_5.substring(dot_3_5+1);
                      }
                      switch(ext_3_5){
                          case "orb":
                          fileteron_3=orb_exton;
                          fileion_3=orb_exton;
                           break;
                          case "java":
                          fileteron_3=icon_java_ext;
                          fileion_3=icon_java_ext;
                          break;
                        }
                      File f4_ext_5=new File(s_fc[3]);
                      String name_for_ext_4_5=f4_ext_5.getName();
                      String ext_4_5="";
                      int dot_4_5=name_for_ext_4_5.lastIndexOf(".");
                      if(dot_4_5>0&dot_4_5<name_for_ext_4_5.length()-1){
                          ext_4_5=name_for_ext_4_5.substring(dot_4_5+1);
                      }
                      switch(ext_4_5){
                          case "orb":
                          fileteron_4=orb_exton;
                          fileion_4=orb_exton;
                           break;
                          case "java":
                          fileteron_4=icon_java_ext;
                          fileion_4=icon_java_ext;
                          break;
                        }
                File f5_ext=new File(s_fc[4]);
                    String name_for_ext_5=f5_ext.getName();
                    String ext_5="";
                    int dot_5=name_for_ext_5.lastIndexOf(".");
                    if(dot_5>0&dot_5<name_for_ext_5.length()-1){
                        ext_5=name_for_ext_5.substring(dot_5+1);
                    }
                    switch(ext_5){
                        case "orb":
                        fileteron_5=orb_exton;
                        fileion_5=orb_exton;
                         break;
                        case "java":
                        fileteron_5=icon_java_ext;
                        fileion_5=icon_java_ext;
                        break;
                      }
                if(filesavebool[0]){
                File f1_5=new File(s_fc[1]);
                if(f1_5.exists()){
                    file2.setVisible(true);
                    file2.setText(f1_5.getName());
                }
                }
                if(filesavebool[1]){
                File f2_5=new File(s_fc[2]);
                if(f2_5.exists()){
                    file3.setVisible(true);
                    file3.setText(f2_5.getName());
                }
                }
                if(filesavebool[2]){
                File f3_5=new File(s_fc[3]);
                if(f3_5.exists()){
                    file4.setVisible(true);
                    file4.setText(f3_5.getName());
                }
                }
                if(filesavebool[3]){
                File f4_5=new File(s_fc[4]);
                if(f4_5.exists()){
                    file5.setVisible(true);
                    file5.setText(f4_5.getName());
                }
                }
                break;
            }
            if(file1.isVisible()){
               temp_new++;
            }
            if(file2.isVisible()){
                temp_new++;
             }
             if(file3.isVisible()){
                temp_new++;
             }
             if(file4.isVisible()){
                temp_new++;
             }
             if(file5.isVisible()){
                temp_new++;
             }
            //  System.out.println(temp_new);
          }
          catch(IOException exc){

        }
        file1butt.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                file1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file2.setBorder(null);
                        file3.setBorder(null);
                        file4.setBorder(null);
                        file5.setBorder(null);
                        file1butt.setVisible(true);
                        file2butt.setVisible(false);
                        file3butt.setVisible(false);
                        file4butt.setVisible(false);
                        file5butt.setVisible(false);
                        fileselect=1;
                       if(file_1_count<4&((file2.isVisible())||(file3.isVisible())||(file4.isVisible())||(file5.isVisible()))){
                        try{
                            BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                            BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                            int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                            String s_fc_file[]=new String[s_fc_x_file];
                            for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                                s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                            }
                            meta_1_file.close();
                            meta_2_file.close();
                            File f_file=new File(s_fc_file[1]);
                            BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                            String f_temp_file,f_temp_console_file="";
                            while((f_temp_file=meta_3_file.readLine())!=null){
                                f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                            }
                            meta_3_file.close();
                          if(f_file.exists()&(file2.getText().equals(f_file.getName()))){
                              index.setText(null);
                              index.setText(" 1  ");
                              codetarea.setText(f_temp_console_file);
                              file2.setText(f_file.getName());
                              for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                      index.append("\n "+f_con_file+" ");
                               }
                          }
                          if((!f_file.exists())||(!(file2.getText().equals(f_file.getName())))){
                            codetarea.setText(null);
                            index.setText(null);
                            codetarea.setText("//  Welcome To Orb");
                            index.setText(" 1  ");
                          }
                        }
                        catch(IOException exc){
              
                    }
                        temp_new=temp_new-1;
                        file1.setText(file2.getText());
                        file2.setText(file3.getText());
                        file3.setText(file4.getText());
                        file4.setText(file5.getText());
                        // String file_path_before[]=new String[1];
                        String file_1_path="";
                        String file_path_after[]=new String[4];
                        try{
                            BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                            // for(int i=0;i<1;i++){
                            //     file_path_before[i]=file_replace.readLine();
                            // }
                            for(int i=0;i<1;i++){
                                file_1_path=file_replace.readLine();
                            }
                            for(int i=0;i<4;i++){
                                file_path_after[i]=file_replace.readLine();
                            }
                            file_replace.close();
                        }
                        catch(IOException exc){
                          
                        }
                        try{
                            BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                            // file_replace.write(file_path_before[0]);
                            // file_replace.newLine();
                            file_replace.write(file_path_after[0]);
                            file_replace.newLine();
                            file_replace.write(file_path_after[1]);
                            file_replace.newLine();
                            file_replace.write(file_path_after[2]);
                            file_replace.newLine();
                            file_replace.write(file_path_after[3]);
                            file_replace.newLine();
                            file_replace.write(file_1_path);
                            file_replace.flush();
                            file_replace.close();
                        }
                        catch(IOException exc){
                          
                        }
                        if(file2.isVisible()){
                            file_1_count=3;
                        }
                        if(file3.isVisible()){
                            file_1_count=2;
                        }
                        if(file4.isVisible()){
                            file_1_count=1;
                        }
                        if(file5.isVisible()){
                            file_1_count=0;
                        }
                        switch(file_1_count){
                            case 0:
                            file5.setText("File.orb");
                            file5.setVisible(false);
                            break;
                            case 1:
                            file4.setText("File.orb");
                            file4.setVisible(false);
                            break;
                            case 2:
                            file3.setText("File.orb");
                            file3.setVisible(false);
                            break;
                            case 3:
                            file2.setText("File.orb");
                            file2.setVisible(false);
                            break;
                            // case 4:
                            // file1.setText("File.orb");
                            // file1.setVisible(false);
                        }
                        file_1_count=file_1_count+1;
                        try{
                                    BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                                    int temp=Integer.parseInt(filebfrtempmeta.readLine());
                                  filebfrtempmeta.close();
                                  temp=temp-1;
                                    String temp_s=Integer.toString(temp);
                                    if(temp<=5){
                                        BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                         filefctemp.write(temp_s);
                                                         filefctemp.flush();
                                                         filefctemp.close();
                                   }
                                }
                                catch(IOException exc){
                        
                              }
            }
          }
        });
        file2butt.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                        file1.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                        file2.setBorder(null);
                        file3.setBorder(null);
                        file4.setBorder(null);
                        file5.setBorder(null);
                        file1butt.setVisible(true);
                        file2butt.setVisible(false);
                        file3butt.setVisible(false);
                        file4butt.setVisible(false);
                        file5butt.setVisible(false);
                        fileselect=1;
                        try{
                                        BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                                        BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                                        int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                                        String s_fc_file[]=new String[s_fc_x_file];
                                        for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                                            s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                                        }
                                        meta_1_file.close();
                                        meta_2_file.close();
                                        File f_file=new File(s_fc_file[0]);
                                        BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                                        String f_temp_file,f_temp_console_file="";
                                        while((f_temp_file=meta_3_file.readLine())!=null){
                                            f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                                        }
                                        meta_3_file.close();
                                      if(f_file.exists()&(file1.getText().equals(f_file.getName()))){
                                          index.setText(null);
                                          index.setText(" 1  ");
                                          codetarea.setText(f_temp_console_file);
                                          file1.setText(f_file.getName());
                                          for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                                  index.append("\n "+f_con_file+" ");
                                           }
                                      }
                                      if((!f_file.exists())||(!(file1.getText().equals(f_file.getName())))){
                                        codetarea.setText(null);
                                        index.setText(null);
                                        codetarea.setText("//  Welcome To Orb");
                                        index.setText(" 1  ");
                                      }
                                    }
                                    catch(IOException exc){
                          
                                  }
                        temp_new=temp_new-1;
                        file2.setText(file3.getText());
                        file3.setText(file4.getText());
                        file4.setText(file5.getText());
                        String file_path_before[]=new String[1];
                        String file_2_path="";
                        String file_path_after[]=new String[3];
                        try{
                            BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                            for(int i=0;i<1;i++){
                                file_path_before[i]=file_replace.readLine();
                            }
                            for(int i=1;i<2;i++){
                                file_2_path=file_replace.readLine();
                            }
                            for(int i=0;i<3;i++){
                                file_path_after[i]=file_replace.readLine();
                            }
                            file_replace.close();
                        }
                        catch(IOException exc){
                          
                        }
                        try{
                            BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                            file_replace.write(file_path_before[0]);
                            file_replace.newLine();
                            file_replace.write(file_path_after[0]);
                            file_replace.newLine();
                            file_replace.write(file_path_after[1]);
                            file_replace.newLine();
                            file_replace.write(file_path_after[2]);
                            file_replace.newLine();
                            file_replace.write(file_2_path);
                            file_replace.flush();
                            file_replace.close();
                        }
                        catch(IOException exc){
                          
                        }
                        if(file2.isVisible()){
                            file_2_count=3;
                        }
                        if(file3.isVisible()){
                            file_2_count=2;
                        }
                        if(file4.isVisible()){
                            file_2_count=1;
                        }
                        if(file5.isVisible()){
                            file_2_count=0;
                        }
                        switch(file_2_count){
                            case 0:
                            file5.setText("File.orb");
                            file5.setVisible(false);
                            break;
                            case 1:
                            file4.setText("File.orb");
                            file4.setVisible(false);
                            break;
                            case 2:
                            file3.setText("File.orb");
                            file3.setVisible(false);
                            break;
                            case 3:
                            file2.setText("File.orb");
                            file2.setVisible(false);
                            break;
                        }
                        file_2_count=file_2_count+1;
                        try{
                                    BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                                    int temp=Integer.parseInt(filebfrtempmeta.readLine());
                                  filebfrtempmeta.close();
                                  temp=temp-1;
                                    String temp_s=Integer.toString(temp);
                                    if(temp<=5){
                                        BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                         filefctemp.write(temp_s);
                                                         filefctemp.flush();
                                                         filefctemp.close();
                                   }
                                }
                                catch(IOException exc){
                        
                              }
            }
        });
        file3butt.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                        file1.setBorder(null);
                        file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                        file3.setBorder(null);
                        file4.setBorder(null);
                        file5.setBorder(null);
                        file1butt.setVisible(false);
                        file2butt.setVisible(true);
                        file3butt.setVisible(false);
                        file4butt.setVisible(false);
                        file5butt.setVisible(false);
                        fileselect=2;
                        try{
                            BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                            BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                            int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                            String s_fc_file[]=new String[s_fc_x_file];
                            for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                                s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                            }
                            meta_1_file.close();
                            meta_2_file.close();
                            File f_file=new File(s_fc_file[1]);
                            BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                            String f_temp_file,f_temp_console_file="";
                            while((f_temp_file=meta_3_file.readLine())!=null){
                                f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                            }
                            meta_3_file.close();
                          if(f_file.exists()&(file2.getText().equals(f_file.getName()))){
                              index.setText(null);
                              index.setText(" 1  ");
                              codetarea.setText(f_temp_console_file);
                              for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                      index.append("\n "+f_con_file+" ");
                               }
                          }
                          if((!f_file.exists())||(!(file2.getText().equals(f_file.getName())))){
                            codetarea.setText(null);
                            index.setText(null);
                            codetarea.setText("//  Welcome To Orb");
                            index.setText(" 1  ");
                          }
                        }
                        catch(IOException exc){
              
                      }
                        temp_new=temp_new-1;
                        file3.setText(file4.getText());
                        file4.setText(file5.getText());
                        String file_path_before[]=new String[2];
                        String file_3_path="";
                        String file_path_after[]=new String[2];
                        try{
                            BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                            for(int i=0;i<2;i++){
                                file_path_before[i]=file_replace.readLine();
                            }
                            for(int i=2;i<3;i++){
                                file_3_path=file_replace.readLine();
                            }
                            for(int i=0;i<2;i++){
                                file_path_after[i]=file_replace.readLine();
                            }
                            file_replace.close();
                        }
                        catch(IOException exc){
                          
                        }
                        try{
                            BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                            file_replace.write(file_path_before[0]);
                            file_replace.newLine();
                            file_replace.write(file_path_before[1]);
                            file_replace.newLine();
                            file_replace.write(file_path_after[0]);
                            file_replace.newLine();
                            file_replace.write(file_path_after[1]);
                            file_replace.newLine();
                            file_replace.write(file_3_path);
                            file_replace.flush();
                            file_replace.close();
                        }
                        catch(IOException exc){
                          
                        }
                        if(file3.isVisible()){
                            file_3_count=2;
                        }
                        if(file4.isVisible()){
                            file_3_count=1;
                        }
                        if(file5.isVisible()){
                            file_3_count=0;
                        }
                        switch(file_3_count){
                            case 0:
                            file5.setText("File.orb");
                            file5.setVisible(false);
                            break;
                            case 1:
                            file4.setText("File.orb");
                            file4.setVisible(false);
                            break;
                            case 2:
                            file3.setText("File.orb");
                            file3.setVisible(false);
                            break;
                        }
                        file_3_count=file_3_count+1;
                        try{
                                    BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                                    int temp=Integer.parseInt(filebfrtempmeta.readLine());
                                  filebfrtempmeta.close();
                                  temp=temp-1;
                                    String temp_s=Integer.toString(temp);
                                    if(temp<=5){
                                        BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                         filefctemp.write(temp_s);
                                                         filefctemp.flush();
                                                         filefctemp.close();
                                   }
                                }
                                catch(IOException exc){
                        
                              }
            }
        });
        file4butt.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                file1.setBorder(null);
                        file2.setBorder(null);
                        file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                        file4.setBorder(null);
                        file5.setBorder(null);
                        file1butt.setVisible(false);
                        file2butt.setVisible(false);
                        file3butt.setVisible(true);
                        file4butt.setVisible(false);
                        file5butt.setVisible(false);
                        fileselect=3;
                        try{
                            BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                            BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                            int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                            String s_fc_file[]=new String[s_fc_x_file];
                            for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                                s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                            }
                            meta_1_file.close();
                            meta_2_file.close();
                            File f_file=new File(s_fc_file[2]);
                            BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                            String f_temp_file,f_temp_console_file="";
                            while((f_temp_file=meta_3_file.readLine())!=null){
                                f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                            }
                            meta_3_file.close();
                          if(f_file.exists()&(file3.getText().equals(f_file.getName()))){
                              index.setText(null);
                              index.setText(" 1  ");
                              codetarea.setText(f_temp_console_file);
                              file3.setText(f_file.getName());
                              for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                      index.append("\n "+f_con_file+" ");
                               }
                          }
                          if((!f_file.exists())||(!(file3.getText().equals(f_file.getName())))){
                            codetarea.setText(null);
                            index.setText(null);
                            codetarea.setText("//  Welcome To Orb");
                            index.setText(" 1  ");
                          }
                        }
                        catch(IOException exc){
              
                      }
                        temp_new=temp_new-1;
                        file4.setText(file5.getText());
                        String file_path_before[]=new String[3];
                        String file_4_path="";
                        String file_path_after[]=new String[1];
                        try{
                            BufferedReader file_replace=new BufferedReader(new FileReader(filepathmeta));
                            for(int i=0;i<3;i++){
                                file_path_before[i]=file_replace.readLine();
                            }
                            for(int i=3;i<4;i++){
                                file_4_path=file_replace.readLine();
                            }
                            for(int i=0;i<1;i++){
                                file_path_after[i]=file_replace.readLine();
                            }
                            file_replace.close();
                        }
                        catch(IOException exc){
                          
                        }
                        try{
                            BufferedWriter file_replace=new BufferedWriter(new FileWriter(filepathmeta));
                            file_replace.write(file_path_before[0]);
                            file_replace.newLine();
                            file_replace.write(file_path_before[1]);
                            file_replace.newLine();
                            file_replace.write(file_path_before[0]);
                            file_replace.newLine();
                            file_replace.write(file_path_after[0]);
                            file_replace.newLine();
                            file_replace.write(file_4_path);
                            file_replace.flush();
                            file_replace.close();
                        }
                        catch(IOException exc){
                          
                        }
                        if(file4.isVisible()){
                            file_4_count=1;
                        }
                        if(file5.isVisible()){
                            file_4_count=0;
                        }
                        switch(file_4_count){
                            case 0:
                            file5.setText("File.orb");
                            file5.setVisible(false);
                            break;
                            case 1:
                            file4.setText("File.orb");
                            file4.setVisible(false);
                            break;
                        }
                        file_4_count=file_4_count+1;
                        try{
                                    BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                                    int temp=Integer.parseInt(filebfrtempmeta.readLine());
                                  filebfrtempmeta.close();
                                  temp=temp-1;
                                    String temp_s=Integer.toString(temp);
                                    if(temp<=5){
                                        BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                                         filefctemp.write(temp_s);
                                                         filefctemp.flush();
                                                         filefctemp.close();
                                   }
                                }
                                catch(IOException exc){
                        
                              }
            }
        });
        file5butt.addMouseListener(new MouseAdapter(){
           public void mouseClicked(MouseEvent e){
                    file1.setBorder(null);
                    file2.setBorder(null);
                    file3.setBorder(null);
                    file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                    file5.setBorder(null);
                    file1butt.setVisible(false);
                    file2butt.setVisible(false);
                    file3butt.setVisible(false);
                    file4butt.setVisible(true);
                    file5butt.setVisible(false);
                    fileselect=4;
                    try{
                        BufferedReader meta_1_file=new BufferedReader(new FileReader(filefcpathmeta));
                        BufferedReader meta_2_file=new BufferedReader(new FileReader(filepathmeta));
                        int s_fc_x_file=Integer.parseInt(meta_1_file.readLine());
                        String s_fc_file[]=new String[s_fc_x_file];
                        for(int s_fc_i_file=0;s_fc_i_file<s_fc_x_file;s_fc_i_file++){
                            s_fc_file[s_fc_i_file]=meta_2_file.readLine();
                        }
                        meta_1_file.close();
                        meta_2_file.close();
                        File f_file=new File(s_fc_file[3]);
                        BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                        String f_temp_file,f_temp_console_file="";
                        while((f_temp_file=meta_3_file.readLine())!=null){
                            f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                        }
                        meta_3_file.close();
                      if(f_file.exists()&(file4.getText().equals(f_file.getName()))){
                          index.setText(null);
                          index.setText(" 1  ");
                          codetarea.setText(f_temp_console_file);
                          file4.setText(f_file.getName());
                          for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                                  index.append("\n "+f_con_file+" ");
                           }
                      }
                      if((!f_file.exists())||(!(file4.getText().equals(f_file.getName())))){
                        codetarea.setText(null);
                        index.setText(null);
                        codetarea.setText("//  Welcome To Orb");
                        index.setText(" 1  ");
                      }
                    }
                    catch(IOException exc){
          
                  }
                  file5.setText("File.orb");
                  file5.setVisible(false);
                  temp_new=temp_new-1;
                  try{
                    BufferedReader filebfrtempmeta=new BufferedReader(new FileReader(filefcpathmeta));
                    int temp=Integer.parseInt(filebfrtempmeta.readLine());
                  filebfrtempmeta.close();
                  temp=temp-1;
                    String temp_s=Integer.toString(temp);
                    if(temp<=5){
                        BufferedWriter filefctemp=new BufferedWriter(new FileWriter(filefcpathmeta));
                                         filefctemp.write(temp_s);
                                         filefctemp.flush();
                                         filefctemp.close();
                   }
                }
                catch(IOException exc){
        
              }
           }
        });
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            
        }
        UIManager.put("OptionPane.background",Color.BLACK);
        UIManager.put("Panel.background",Color.BLACK);
        UIManager.put("ComboBox.background",Color.BLACK);
        this.add(display);
        this.addMouseListener(new Temp_1());
        Toolkit tkal=Toolkit.getDefaultToolkit();
        Dimension sizekal=tkal.getScreenSize();
        JDialog signup=new JDialog(this);
        // Toolkit tfdd=Toolkit.getDefaultToolkit();
        //             Dimension sizefdd=tfdd.getScreenSize();
                    JPanel loginpaneld=new JPanel();
                    JLabel usermaind=new JLabel();
                    usermaind.setLayout(new GridLayout(1,2,2,0));
                    JLabel userlabeld=new JLabel("User Name : ");
                    userlabeld.setFont(new Font("Serif",Font.BOLD,15));
                    userlabeld.setForeground(Color.CYAN);
                    userlabeld.setHorizontalTextPosition(JLabel.CENTER);
                    userlabeld.setHorizontalAlignment(JLabel.CENTER);
                    JTextField usernamed=new JTextField();
                    usernamed.setFont(new Font("Serif",Font.BOLD,15));
                    usernamed.setForeground(Color.CYAN);
                    usernamed.setBackground(Color.BLACK);
                    usernamed.setSelectedTextColor(new Color(3, 252, 7));
                    usernamed.setSelectionColor(Color.DARK_GRAY);
                    usernamed.setCaretColor(Color.CYAN);
                    usernamed.setBorder(null);
                    // usernamed.setFocusable(true);
                    usermaind.add(userlabeld);
                    usermaind.add(usernamed);
                    JLabel passmaind=new JLabel();
                    passmaind.setLayout(new GridLayout(1,2,2,0));
                    JLabel passlabeld=new JLabel("Password : ");
                    passlabeld.setFont(new Font("Serif",Font.BOLD,15));
                    passlabeld.setForeground(Color.CYAN);
                    passlabeld.setHorizontalTextPosition(JLabel.CENTER);
                    passlabeld.setHorizontalAlignment(JLabel.CENTER);
                    JPasswordField passnamed=new JPasswordField();
                    passnamed.setFont(new Font("Serif",Font.BOLD,10));
                    passnamed.setForeground(Color.CYAN);
                    passnamed.setBackground(Color.BLACK);
                    passnamed.setSelectedTextColor(new Color(3, 252, 7));
                    passnamed.setSelectionColor(Color.DARK_GRAY);
                    passnamed.setCaretColor(Color.CYAN);
                    passnamed.setBorder(null);
                    passmaind.add(passlabeld);
                    passmaind.add(passnamed);
                    JLabel emailmaind=new JLabel();
                    emailmaind.setLayout(new GridLayout(1,2,2,0));
                    JLabel emaillabeld=new JLabel("Email : ");
                    emaillabeld.setFont(new Font("Serif",Font.BOLD,15));
                    emaillabeld.setForeground(Color.CYAN);
                    emaillabeld.setHorizontalTextPosition(JLabel.CENTER);
                    emaillabeld.setHorizontalAlignment(JLabel.CENTER);
                    JTextField emailnamed=new JTextField();
                    emailnamed.setFont(new Font("Serif",Font.BOLD,15));
                    emailnamed.setForeground(Color.CYAN);
                    emailnamed.setBackground(Color.BLACK);
                    emailnamed.setSelectedTextColor(new Color(3, 252, 7));
                    emailnamed.setSelectionColor(Color.DARK_GRAY);
                    emailnamed.setCaretColor(Color.CYAN);
                    emailnamed.setBorder(null);
                    emailmaind.add(emaillabeld);
                    emailmaind.add(emailnamed);
                    JLabel agencymaind=new JLabel();
                    agencymaind.setLayout(new GridLayout(1,2,2,0));
                    JLabel agencylabeld=new JLabel("Organization : ");
                    agencylabeld.setFont(new Font("Serif",Font.BOLD,15));
                    agencylabeld.setForeground(Color.CYAN);
                    agencylabeld.setHorizontalTextPosition(JLabel.CENTER);
                    agencylabeld.setHorizontalAlignment(JLabel.CENTER);
                    JTextField agencynamed=new JTextField();
                    agencynamed.setFont(new Font("Serif",Font.BOLD,15));
                    agencynamed.setForeground(Color.CYAN);
                    agencynamed.setBackground(Color.BLACK);
                    agencynamed.setSelectedTextColor(new Color(3, 252, 7));
                    agencynamed.setSelectionColor(Color.DARK_GRAY);
                    agencynamed.setCaretColor(Color.CYAN);
                    agencynamed.setBorder(null);
                    agencymaind.add(agencylabeld);
                    agencymaind.add(agencynamed);
                    JLabel loginbuttd=new JLabel("Signup");
                    loginbuttd.setCursor(c);
                    loginbuttd.setFont(new Font("Serif",Font.BOLD,15));
                    loginbuttd.addMouseListener(new MouseAdapter(){
                        public void mouseEntered(MouseEvent e){
                        loginbuttd.setForeground(new Color(3, 252, 7));
                        loginbuttd.setFont(new Font("Serif",Font.BOLD,20));
                      }
                      public void mouseExited(MouseEvent e){
                        loginbuttd.setForeground(Color.CYAN);
                        loginbuttd.setFont(new Font("Serif",Font.BOLD,15));
                      }
                    });
                    loginbuttd.setHorizontalTextPosition(JLabel.CENTER);
                    loginbuttd.setHorizontalAlignment(JLabel.CENTER);
                    loginbuttd.setForeground(Color.CYAN);
                    loginpaneld.setLayout(new GridLayout(9,0,0,2));
                    loginpaneld.setBackground(Color.BLACK);
                    JLabel usererrd=new JLabel();
                    usererrd.setFont(new Font("Serif",Font.BOLD,13));
                    usererrd.setForeground(new Color(255, 133, 77));
                    usererrd.setHorizontalTextPosition(JLabel.CENTER);
                    usererrd.setHorizontalAlignment(JLabel.CENTER);
                    JLabel passerrd=new JLabel();
                    passerrd.setFont(new Font("Serif",Font.BOLD,13));
                    passerrd.setForeground(new Color(255, 133, 77));
                    passerrd.setHorizontalTextPosition(JLabel.CENTER);
                    passerrd.setHorizontalAlignment(JLabel.CENTER);
                    JLabel emailerrd=new JLabel();
                    emailerrd.setFont(new Font("Serif",Font.BOLD,13));
                    emailerrd.setForeground(new Color(255, 133, 77));
                    emailerrd.setHorizontalTextPosition(JLabel.CENTER);
                    emailerrd.setHorizontalAlignment(JLabel.CENTER);
                    JLabel loginerrd=new JLabel();
                    loginerrd.setFont(new Font("Serif",Font.BOLD,13));
                    loginerrd.setForeground(new Color(255, 133, 77));
                    loginerrd.setHorizontalTextPosition(JLabel.CENTER);
                    loginerrd.setHorizontalAlignment(JLabel.CENTER);
                    usererrd.setBackground(Color.BLACK);
                    passerrd.setBackground(Color.BLACK);
                    emailerrd.setBackground(Color.BLACK);
                    loginerrd.setBackground(Color.BLACK);
                    // usererrd.setText("this is a user error");
                    // passerrd.setText("this is a password error");
                    // loginerrd.setText("this is a login error");
                    // emailerrd.setText("this is an email error");
                    loginpaneld.add(usermaind);
                    loginpaneld.add(usererrd);
                    loginpaneld.add(passmaind);
                    loginpaneld.add(passerrd);
                    loginpaneld.add(emailmaind);
                    loginpaneld.add(emailerrd);
                    loginpaneld.add(agencymaind);
                    loginpaneld.add(loginbuttd);
                    loginpaneld.add(loginerrd);
                    usernamed.addKeyListener(new KeyAdapter(){
                        public void keyPressed(KeyEvent e){
                            int key=e.getKeyCode();
                            // System.out.println(key);
                            if(key==40){
                                passnamed.setFocusable(true);
                                 usernamed.setFocusable(false);
                            }
                        }
                    });
                    passnamed.addKeyListener(new KeyAdapter(){
                        public void keyPressed(KeyEvent e){
                            int key=e.getKeyCode();
                            if(key==38){
                                usernamed.setFocusable(true);
                                 passnamed.setFocusable(false);
                            }
                            if(key==40){
                                emailnamed.setFocusable(true);
                                 passnamed.setFocusable(false);
                            }
                        }
                    });
                    emailnamed.addKeyListener(new KeyAdapter(){
                        public void keyPressed(KeyEvent e){
                            int key=e.getKeyCode();
                            if(key==38){
                                passnamed.setFocusable(true);
                                 emailnamed.setFocusable(false);
                            }
                            if(key==40){
                                agencynamed.setFocusable(true);
                                 emailnamed.setFocusable(false);
                            }
                        }
                    });
                    agencynamed.addKeyListener(new KeyAdapter(){
                        public void keyPressed(KeyEvent e){
                            int key=e.getKeyCode();
                            if(key==38){
                                emailnamed.setFocusable(true);
                                 agencynamed.setFocusable(false);
                            }
                        }
                    });
                    ImageIcon logini = new ImageIcon("./image/login.png");
              Image loginio=logini.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
               ImageIcon loginion=new ImageIcon(loginio);
                    signup.add(loginpaneld);
                    signup.setIconImage(loginion.getImage());
                    signup.setTitle("User_Signup");
                    signup.setModal(true);
                    signup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    loginpaneld.setSize(sizekal.width/2,sizekal.height/2);
                    signup.setLocationRelativeTo(null);
        signup.setSize(sizekal.width/2,sizekal.height/2);
        signup.setModal(true);
        // signup.setFocusable(true);
        signup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        signup.setLocationRelativeTo(null);
        signup.setBackground(Color.BLACK);
        JDialog signin=new JDialog(this);
        Toolkit tfd=Toolkit.getDefaultToolkit();
                    Dimension sizefd=tfd.getScreenSize();
                    JPanel loginpanel=new JPanel();
                    JLabel usermain=new JLabel();
                    usermain.setLayout(new GridLayout(1,2,2,0));
                    JLabel userlabel=new JLabel("User Name : ");
                    userlabel.setFont(new Font("Serif",Font.BOLD,15));
                    userlabel.setForeground(Color.CYAN);
                    userlabel.setHorizontalTextPosition(JLabel.CENTER);
                    userlabel.setHorizontalAlignment(JLabel.CENTER);
                    JTextField username=new JTextField();
                    username.setFont(new Font("Serif",Font.BOLD,15));
                    username.setForeground(Color.CYAN);
                    username.setBackground(Color.BLACK);
                    username.setSelectedTextColor(new Color(3, 252, 7));
                    username.setSelectionColor(Color.DARK_GRAY);
                    username.setCaretColor(Color.CYAN);
                    username.setBorder(null);
                    usermain.add(userlabel);
                    usermain.add(username);
                    JLabel passmain=new JLabel();
                    passmain.setLayout(new GridLayout(1,2,2,0));
                    JLabel passlabel=new JLabel("Password : ");
                    passlabel.setFont(new Font("Serif",Font.BOLD,15));
                    passlabel.setForeground(Color.CYAN);
                    passlabel.setHorizontalTextPosition(JLabel.CENTER);
                    passlabel.setHorizontalAlignment(JLabel.CENTER);
                    JPasswordField passname=new JPasswordField();
                    passname.setFont(new Font("Serif",Font.BOLD,10));
                    passname.setForeground(Color.CYAN);
                    passname.setBackground(Color.BLACK);
                    passname.setSelectedTextColor(new Color(3, 252, 7));
                    passname.setSelectionColor(Color.DARK_GRAY);
                    passname.setCaretColor(Color.CYAN);
                    passname.setBorder(null);
                    passmain.add(passlabel);
                    passmain.add(passname);
                    loginpanel.setLayout(new GridLayout(6,0,0,2));
                    loginpanel.setBackground(Color.BLACK);
                    JLabel usererr=new JLabel();
                    usererr.setFont(new Font("Serif",Font.BOLD,13));
                    usererr.setForeground(new Color(255, 133, 77));
                    usererr.setHorizontalTextPosition(JLabel.CENTER);
                    usererr.setHorizontalAlignment(JLabel.CENTER);
                    JLabel passerr=new JLabel();
                    passerr.setFont(new Font("Serif",Font.BOLD,13));
                    passerr.setForeground(new Color(255, 133, 77));
                    passerr.setHorizontalTextPosition(JLabel.CENTER);
                    passerr.setHorizontalAlignment(JLabel.CENTER);
                    JLabel loginerr=new JLabel();
                    loginerr.setFont(new Font("Serif",Font.BOLD,13));
                    loginerr.setForeground(new Color(255, 133, 77));
                    loginerr.setHorizontalTextPosition(JLabel.CENTER);
                    loginerr.setHorizontalAlignment(JLabel.CENTER);
                    usererr.setBackground(Color.BLACK);
                    passerr.setBackground(Color.BLACK);
                    loginerr.setBackground(Color.BLACK);
                    // usererr.setText("This is a user error");
                    // passerr.setText("This is a password error");
                    // loginerr.setText("This is a login error");
                    JLabel logsignmain=new JLabel();
                    logsignmain.setLayout(new GridLayout(1,2,2,0));
                    logsignmain.setBackground(Color.BLACK);
                    JLabel loginbutton=new JLabel("Login");
                    JLabel signupbutton=new JLabel("Signup");
                    loginbutton.setCursor(c);
                    loginbutton.setFont(new Font("Serif",Font.BOLD,15));
                    loginbutton.addMouseListener(new MouseAdapter(){
                        public void mouseEntered(MouseEvent e){
                        loginbutton.setForeground(new Color(3, 252, 7));
                        loginbutton.setFont(new Font("Serif",Font.BOLD,17));
                      }
                      public void mouseExited(MouseEvent e){
                        loginbutton.setForeground(Color.CYAN);
                        loginbutton.setFont(new Font("Serif",Font.BOLD,15));
                      }
                    });
                    loginbutton.setHorizontalTextPosition(JLabel.CENTER);
                    loginbutton.setHorizontalAlignment(JLabel.CENTER);
                    loginbutton.setForeground(Color.CYAN);
                    loginbutton.setBackground(Color.BLACK);
                    signupbutton.setCursor(c);
                    signupbutton.setFont(new Font("Serif",Font.BOLD,15));
                    signupbutton.addMouseListener(new MouseAdapter(){
                        public void mouseEntered(MouseEvent e){
                        signupbutton.setForeground(new Color(3, 252, 7));
                        signupbutton.setFont(new Font("Serif",Font.BOLD,17));
                      }
                      public void mouseExited(MouseEvent e){
                        signupbutton.setForeground(Color.CYAN);
                        signupbutton.setFont(new Font("Serif",Font.BOLD,15));
                      }
                    });
                    signupbutton.setHorizontalTextPosition(JLabel.CENTER);
                    signupbutton.setHorizontalAlignment(JLabel.CENTER);
                    signupbutton.setForeground(Color.CYAN);
                    signupbutton.setBackground(Color.BLACK);
                    logsignmain.add(loginbutton);
                    logsignmain.add(signupbutton);
                    loginpanel.add(usermain);
                    loginpanel.add(usererr);
                    loginpanel.add(passmain);
                    loginpanel.add(passerr);
                    // loginpanel.add(loginbutt);
                    loginpanel.add(logsignmain);
                    loginpanel.add(loginerr);
            //         ImageIcon logini = new ImageIcon("./image/login.png");
            //   Image loginio=logini.getImage().getScaledInstance(24,24,Image.SCALE_SMOOTH);
            //    ImageIcon loginion=new ImageIcon(loginio);
                    signin.add(loginpanel);
                    username.addKeyListener(new KeyAdapter(){
                        public void keyPressed(KeyEvent e){
                            int key=e.getKeyCode();
                            // System.out.println(key);
                            if(key==40){
                                passname.setFocusable(true);
                                 username.setFocusable(false);
                            }
                        }
                    });
                    passname.addKeyListener(new KeyAdapter(){
                        public void keyPressed(KeyEvent e){
                            int key=e.getKeyCode();
                            if(key==38){
                                username.setFocusable(true);
                                 passname.setFocusable(false);
                            }
                        }
                    });
                    signupbutton.addMouseListener(new MouseAdapter(){
                         public void mouseClicked(MouseEvent e){
                             signup.setVisible(true);
                         }
                    });
                    loginbutton.addMouseListener(new MouseAdapter(){
                        public void mouseClicked(MouseEvent e){
                            // signin.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                            signin.setVisible(false);
                        }
                    });
                    signin.setIconImage(loginion.getImage());
                    signin.setTitle("User_Login");
                    signin.setModal(true);
                    signin.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
                    signin.setSize((sizefd.width/2),(sizefd.height/2));
                    loginpanel.setSize((sizefd.width/2),(sizefd.height/2));
                    signin.setLocationRelativeTo(null);
                    // signin.setVisible(true);
        this.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if(framefocus==0){
                    signin.setVisible(true);
                    framefocus++;
                }
            }
            public void focusLost(FocusEvent e){

            }
        });
         this.setVisible(true);
    }
    public void addNodes(DefaultMutableTreeNode parentNode, File parentFile) {
        File[] childFiles = parentFile.listFiles();
        for (File childFile : childFiles) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(childFile.getName());
            if (childFile.isDirectory()) {
                addNodes(childNode, childFile);
            }
            parentNode.add(childNode);
        }
    }
    public static Component maind;//static component it fills with null intialization
    //and then when we click on explorer then mouselistener will pass that source of event object into maind
    //component then we use it for expansion of explorer 
    public void keyPressed(KeyEvent e){
        int key2=e.getKeyCode();
        //  System.out.println(key2);
        if(key2==113){//F2 key rename operation 
            String filecurrpath="";
                Boolean x_rename=false;
                try{
                    BufferedReader filepathrmeta=new BufferedReader(new FileReader(filepathmeta));
                     filecurrpath=filepathrmeta.readLine();
                    for(int iorb=1;iorb<fileselect;iorb++){
                        filecurrpath=filepathrmeta.readLine();
                    }
                    filepathrmeta.close();
                }
                catch(IOException exc){
 
                }
                ImageIcon icon_rename_pop_1= new ImageIcon("./image/renamepop.png");
                Image i_rename_pop_1=icon_rename_pop_1.getImage();
                Image j_rename_pop_1=i_rename_pop_1.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                icon_rename_pop_1=new ImageIcon(j_rename_pop_1);
                Object rename=JOptionPane.showInputDialog(null,"Enter file name for rename operation"
                ,"Rename File",JOptionPane.INFORMATION_MESSAGE,icon_rename_pop_1,null,null);
                String filerename="";
                if(rename!=null){
                     filerename=rename.toString();
                }
                File tempfile_1=new File(filecurrpath);
                String filerenamepath=tempfile_1.getParent()+File.separator+filerename;
                File renamefile=new File(filerenamepath);
                   x_rename=tempfile_1.renameTo(renamefile);
                   File f_ext=renamefile;
                   String name_for_ext=f_ext.getName();
                   String ext="";
                   int dot=name_for_ext.lastIndexOf(".");
                   if(dot>0&dot<name_for_ext.length()-1){
                       ext=name_for_ext.substring(dot+1);
                   }
                if(x_rename){
                switch(fileselect){
                    case 1:
                    switch(ext){
                        case "orb":
                        fileteron_1=orb_exton;
                        fileion_1=orb_exton;
                         break;
                        case "java":
                        fileteron_1=icon_java_ext;
                        fileion_1=icon_java_ext;
                        break;
                      }
                    filetemp1=renamefile;
                    filenametemp1=filetemp1.getName();
                    filepathtemp1=filetemp1.getAbsolutePath();
                   String filecontenttemp1=codetarea.getText();
                   file1.setText(filenametemp1);
                   file1.setIcon(null);
                   file1.removeMouseListener(new Temp4());
                   file1.addMouseListener(new Temp5());
                  try{
                       String s[]=new String[5];
                       BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                       String x= filebfrtempmeta1.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta1.write(filepathtemp1);
                        filebftempmeta1.newLine();
                        filebftempmeta1.flush();
                        filebftempmeta1.close();
                       }
                       if(x!=null){
                        for(int i=1;i<5;i++){
                            s[i]=filebfrtempmeta1.readLine();
                        }
                        filebfrtempmeta1.close();
                        BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta1.write("");
                        filebftempmeta1.flush();
                        filebftempmeta1.close();
                        BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebfwtempmeta1.write(filepathtemp1);
                        filebfwtempmeta1.newLine();
                        if(s[1]!=null){
                            filebfwtempmeta1.write(s[1]);
                            filebfwtempmeta1.newLine();
                        }
                        if(s[2]!=null){
                            filebfwtempmeta1.write(s[2]);
                            filebfwtempmeta1.newLine();
                        }
                        if(s[3]!=null){
                            filebfwtempmeta1.write(s[3]);
                            filebfwtempmeta1.newLine();
                        }
                        if(s[4]!=null){
                            filebfwtempmeta1.write(s[4]);
                            filebfwtempmeta1.newLine();
                        }
                        filebfwtempmeta1.flush();
                        filebfwtempmeta1.close();
                    }
                }
                  catch(IOException exc){

                  }
                  break;
                    case 2:
                    switch(ext){
                        case "orb":
                        fileteron_2=orb_exton;
                        fileion_2=orb_exton;
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
                        fileion_2=icon_java_ext;
                        break;
                      }
                    filetemp2=renamefile;
                    filenametemp2=filetemp2.getName();
                    filepathtemp2=filetemp2.getAbsolutePath();
                   String filecontenttemp2=codetarea.getText();
                   file2.setText(filenametemp2);
                   file2.setIcon(null);
                   file2.removeMouseListener(new Temp4());
                   file2.addMouseListener(new Temp5());
                  try{
                       String s[]=new String[5];
                       BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<1;i++){
                           s[i]=filebfrtempmeta2.readLine();
                       }
                       String x= filebfrtempmeta2.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta2.write(filepathtemp2);
                        filebftempmeta2.newLine();
                        filebftempmeta2.flush();
                        filebftempmeta2.close();
                       }
                       if(x!=null){
                        for(int i=2;i<5;i++){
                            s[i]=filebfrtempmeta2.readLine();
                        }
                        filebfrtempmeta2.close();
                        BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta2.write("");
                        filebftempmeta2.flush();
                        filebftempmeta2.close();
                        BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta2.write(s[0]);
                            filebfwtempmeta2.newLine();
                        }
                        filebfwtempmeta2.write(filepathtemp2);
                        filebfwtempmeta2.newLine();
                        if(s[2]!=null){
                            filebfwtempmeta2.write(s[2]);
                            filebfwtempmeta2.newLine();
                        }
                        if(s[3]!=null){
                            filebfwtempmeta2.write(s[3]);
                            filebfwtempmeta2.newLine();
                        }
                        if(s[4]!=null){
                            filebfwtempmeta2.write(s[4]);
                            filebfwtempmeta2.newLine();
                        }
                        filebfwtempmeta2.flush();
                        filebfwtempmeta2.close();
                       }
                    }
                    catch(IOException exc){

                    }
                  break;
                    case 3:
                    switch(ext){
                        case "orb":
                        fileteron_3=orb_exton;
                        fileion_3=orb_exton;
                         break;
                        case "java":
                        fileteron_3=icon_java_ext;
                        fileion_3=icon_java_ext;
                        break;
                      }
                    filetemp3=renamefile;
                    filenametemp3=filetemp3.getName();
                    filepathtemp3=filetemp3.getAbsolutePath();
                   String filecontenttemp3=codetarea.getText();
                   file3.setText(filenametemp3);
                   file3.setIcon(null);
                   file3.removeMouseListener(new Temp4());
                   file3.addMouseListener(new Temp5());
                  try{
                    String s[]=new String[5];
                       BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<2;i++){
                           s[i]=filebfrtempmeta3.readLine();
                       }
                       String x= filebfrtempmeta3.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta3.write(filepathtemp3);
                        filebftempmeta3.newLine();
                        filebftempmeta3.flush();
                        filebftempmeta3.close();
                       }
                       if(x!=null){
                        for(int i=3;i<5;i++){
                            s[i]=filebfrtempmeta3.readLine();
                        }
                        filebfrtempmeta3.close();
                        BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta3.write("");
                        filebftempmeta3.flush();
                        filebftempmeta3.close();
                        BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta3.write(s[0]);
                            filebfwtempmeta3.newLine();
                        }
                        if(s[1]!=null){
                            filebfwtempmeta3.write(s[1]);
                            filebfwtempmeta3.newLine();
                        }
                        filebfwtempmeta3.write(filepathtemp3);
                        filebfwtempmeta3.newLine();
                        if(s[3]!=null){
                            filebfwtempmeta3.write(s[3]);
                            filebfwtempmeta3.newLine();
                        }
                        if(s[4]!=null){
                            filebfwtempmeta3.write(s[4]);
                            filebfwtempmeta3.newLine();
                        }
                        filebfwtempmeta3.flush();
                        filebfwtempmeta3.close();
                       }
                  }
                  catch(IOException exc){
                    
                  }
                  break;
                  case 4:
                  switch(ext){
                    case "orb":
                    fileteron_4=orb_exton;
                    fileion_4=orb_exton;
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
                    fileion_4=icon_java_ext;
                    break;
                  }
                  filetemp4=renamefile;
                  filenametemp4=filetemp4.getName();
                  filepathtemp4=filetemp4.getAbsolutePath();
                 String filecontenttemp4=codetarea.getText();
                 file4.setText(filenametemp4);
                 file4.setIcon(null);
                 file4.removeMouseListener(new Temp4());
                 file4.addMouseListener(new Temp5());
                try{
                     String s[]=new String[5];
                       BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<3;i++){
                           s[i]=filebfrtempmeta4.readLine();
                       }
                       String x= filebfrtempmeta4.readLine();
                       if(x==null){
                        BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta4.write(filepathtemp4);
                        filebftempmeta4.newLine();
                        filebftempmeta4.flush();
                        filebftempmeta4.close();
                       }
                       if(x!=null){
                        for(int i=4;i<5;i++){
                            s[i]=filebfrtempmeta4.readLine();
                        }
                        filebfrtempmeta4.close();
                        BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta4.write("");
                        filebftempmeta4.flush();
                        filebftempmeta4.close();
                        BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta4.write(s[0]);
                            filebfwtempmeta4.newLine();
                        }
                        if(s[1]!=null){
                            filebfwtempmeta4.write(s[1]);
                            filebfwtempmeta4.newLine();
                        }
                        if(s[2]!=null){
                            filebfwtempmeta4.write(s[2]);
                            filebfwtempmeta4.newLine();
                        }
                        filebfwtempmeta4.write(filepathtemp4);
                        filebfwtempmeta4.newLine();
                        if(s[4]!=null){
                            filebfwtempmeta4.write(s[4]);
                            filebfwtempmeta4.newLine();
                        }
                        filebfwtempmeta4.flush();
                        filebfwtempmeta4.close();
                    }
                }
                catch(IOException exc){

                }
                break;
                case 5:
                switch(ext){
                    case "orb":
                    fileteron_5=orb_exton;
                    fileion_5=orb_exton;
                     break;
                    case "java":
                    fileteron_5=icon_java_ext;
                    fileion_5=icon_java_ext;
                    break;
                  }
                filetemp5=renamefile;
                filenametemp5=filetemp5.getName();
                filepathtemp5=filetemp5.getAbsolutePath();
               String filecontenttemp5=codetarea.getText();
               file5.setText(filenametemp5);
               file5.setIcon(null);
               file5.removeMouseListener(new Temp4());
               file5.addMouseListener(new Temp5());
              try{
                   String s[]=new String[5];
                       BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                       for(int i=0;i<4;i++){
                           s[i]=filebfrtempmeta5.readLine();
                       }
                       String x= filebfrtempmeta5.readLine();
                       filebfrtempmeta5.close();
                       if(x==null){
                        BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                        filebftempmeta5.write(filepathtemp5);
                        filebftempmeta5.newLine();
                        filebftempmeta5.flush();
                        filebftempmeta5.close();
                       }
                       if(x!=null){
                        BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                        filebftempmeta5.write("");
                        filebftempmeta5.flush();
                        filebftempmeta5.close();
                        BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                        if(s[0]!=null){
                            filebfwtempmeta5.write(s[0]);
                            filebfwtempmeta5.newLine();
                        }
                        if(s[1]!=null){
                            filebfwtempmeta5.write(s[1]);
                            filebfwtempmeta5.newLine();
                        }
                        if(s[2]!=null){
                            filebfwtempmeta5.write(s[2]);
                            filebfwtempmeta5.newLine();
                        }
                        if(s[3]!=null){
                            filebfwtempmeta5.write(s[3]);
                            filebfwtempmeta5.newLine();
                        }
                        filebfwtempmeta5.write(filepathtemp5);
                        filebfwtempmeta5.newLine();
                        filebfwtempmeta5.flush();
                        filebfwtempmeta5.close();
                    }
                }
              catch(IOException exc){

              }
              break;
                }
              }
              if(!x_rename){
                ImageIcon icon_rename_pop = new ImageIcon("./image/warning.png");
                Image i_rename_pop=icon_rename_pop.getImage();
                Image j_rename_pop=i_rename_pop.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
               icon_rename_pop=new ImageIcon(j_rename_pop);
               JLabel cmbox_l=new JLabel("The rename operation has been denied because the given current folder contains a file with the same name.");
               Toolkit tdir=Toolkit.getDefaultToolkit();
               Dimension sizedir=tdir.getScreenSize();
               cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
               cmbox_l.setBackground(Color.BLACK);
               cmbox_l.setForeground(Color.CYAN);
               JOptionPane.showMessageDialog(null,cmbox_l,"Rename Error"
               ,JOptionPane.INFORMATION_MESSAGE,icon_rename_pop);
              }
        }
        if(key2==38){//upper arrow=38 for maximize window
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.getRootPane().setBorder(null);
            mb.getComponent(1).setVisible(false);
            tx.setColumns(13);
            tx.setText("                 Search");
            tx.addFocusListener(new FocusAdapter(){
                public void focusGained(FocusEvent e){
                    tx.setText(null);
                }
                public void focusLost(FocusEvent e){
                    tx.setText("                 Search");
                }
            });
            exp.setPreferredSize(new Dimension(150,50));
            terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
            explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
            sp.setPreferredSize(new Dimension(this.getWidth()/6-10,this.getHeight()/2+50));
            codesp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
            index.setPreferredSize(new Dimension((this.getWidth()-this.getWidth()/6)/15,((this.getHeight()-this.getHeight()/20))/2));
           codesp.getViewport().setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2)); 
           terminalsp.getViewport().setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
          terminalsp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
          terminaltarea.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
        }
        // int key3=e.getKeyCode();//down arrow=40 for restore window
        if(key2==40){
            Component temp=mb.getComponent(1);
            JMenu tempmenu=(JMenu)temp;
                Toolkit t=Toolkit.getDefaultToolkit();
                        Dimension size=t.getScreenSize();
                        mb.getComponent(1).setVisible(true);
                        this.setSize(size.width/2,size.height/2);
                        for(int i=6;i<9;i++){
                            tempmenu.getItem(i).setVisible(true);
                            }
            tx.setColumns(6);
            tx.setText("   Search");
            tx.addFocusListener(new FocusAdapter(){
                public void focusGained(FocusEvent e){
                    tx.setText(null);
                }
                public void focusLost(FocusEvent e){
                    tx.setText("   Search");
                }
            });
            exp.setPreferredSize(new Dimension(85,25));
            display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
         terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
         explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
         sp.setPreferredSize(new Dimension(this.getWidth()/6-10,this.getHeight()/2+50));
         codesp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
         index.setPreferredSize(new Dimension((this.getWidth()-this.getWidth()/6)/15,((this.getHeight()-this.getHeight()/20))/2));
        codesp.getViewport().setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
        terminalsp.getViewport().setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
 terminalsp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
 terminaltarea.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
                        this.setLocationRelativeTo(null);
                        this.setVisible(true);
               }
        // int key4=e.getKeyCode();//plus=61 for increase dimension of frame 
        Toolkit tdir=Toolkit.getDefaultToolkit();
        Dimension sizedir=tdir.getScreenSize();
        if(this.getWidth()<sizedir.width){
        if(key2==61){
            Component temp=mb.getComponent(1);
            JMenu tempmenu=(JMenu)temp;
            Toolkit t=Toolkit.getDefaultToolkit();
            Dimension size=t.getScreenSize();
            int width_temp=this.getWidth();
            int height_temp=this.getHeight();
            temp.setVisible(true);
            this.setSize(width_temp+170,height_temp+100);
            width_temp=this.getWidth();
            if(width_temp>=size.width/1.0){
                temp.setVisible(false);
                tx.setColumns(8);
            tx.setText("     Search");
            exp.setPreferredSize(new Dimension(150,50));
            }
            if(width_temp>=size.width/1.15){
                for(int i=0;i<9;i++){
                   tempmenu.getItem(i).setVisible(false);
                 }
                 tx.setColumns(8);
            tx.setText("     Search");
            exp.setPreferredSize(new Dimension(150,50));
           }
            if(width_temp>size.width/1.5&&width_temp<=size.width/1.15){
               for(int i=0;i<9;i++){
                tempmenu.getItem(i).setVisible(false);
                }
                tx.setColumns(8);
            tx.setText("     Search");
            exp.setPreferredSize(new Dimension(130,40));
           }
            if(width_temp>size.width/1.88&&width_temp<=size.width/1.5){
               for(int i=0;i<8;i++){
               tempmenu.getItem(i).setVisible(false);
               }
               tx.setColumns(8);
            tx.setText("     Search");
            exp.setPreferredSize(new Dimension(100,30));
           }
            if(width_temp>size.width/2.5&&width_temp<=size.width/1.88){
               for(int i=0;i<6;i++){
               tempmenu.getItem(i).setVisible(false);
            }
            tx.setColumns(8);
            tx.setText("     Search");
            exp.setPreferredSize(new Dimension(85,25));
           }
            if(width_temp>size.width/3.76&&width_temp<=size.width/2.5){
               for(int i=0;i<4;i++){
               tempmenu.getItem(i).setVisible(false);
               }
           }
            if(width_temp>size.width/7.52&&width_temp<=size.width/3.76){
               for(int i=0;i<2;i++){
               tempmenu.getItem(i).setVisible(false);
               }
           }
            if(width_temp>=0&&width_temp<=size.width/7.52){
               for(int i=0;i<9;i++){
               tempmenu.getItem(i).setVisible(true);
               }
           }
           tx.addFocusListener(new FocusAdapter(){
            public void focusGained(FocusEvent e){
                tx.setText(null);
            }
            public void focusLost(FocusEvent e){
                tx.setText("     Search");
            }
        });
            Toolkit tdir1=Toolkit.getDefaultToolkit();
            Dimension sizedir1=tdir1.getScreenSize();
            if(this.getWidth()>sizedir1.width){
             this.setExtendedState(JFrame.MAXIMIZED_BOTH);
             this.getRootPane().setBorder(null);
            }
            display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
     terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
     explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
     sp.setPreferredSize(new Dimension(this.getWidth()/6-10,this.getHeight()/2+50));
     codesp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
     index.setPreferredSize(new Dimension((this.getWidth()-this.getWidth()/6)/15,((this.getHeight()-this.getHeight()/20))/2));
 codesp.getViewport().setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
 terminalsp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
 terminaltarea.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
                this.setLocationRelativeTo(null);
                this.setVisible(true);
        }
    }
        // int key5=e.getKeyCode();//minus=45 for decrease dimension of frame
        if(key2==45){
                     Component temp=mb.getComponent(1);
                     JMenu tempmenu=(JMenu)temp;
                     Toolkit t=Toolkit.getDefaultToolkit();
                     Dimension size=t.getScreenSize();
                     int width_temp=this.getWidth();
                     int height_temp=this.getHeight();
                     temp.setVisible(true);
                     this.setSize(width_temp-170,height_temp-100);
                     width_temp=this.getWidth();
                     if(width_temp>=0&&width_temp<=size.width/6.4){
                        for(int i=0;i<9;i++){
                        tempmenu.getItem(i).setVisible(true);
                        }
                    }
                     if(width_temp>size.width/6.4&&width_temp<=size.width/3.2){
                        for(int i=2;i<9;i++){
                        tempmenu.getItem(i).setVisible(true);
                        }
                    }
                     if(width_temp>size.width/3.2&&width_temp<=size.width/2.28){
                        for(int i=4;i<9;i++){
                        tempmenu.getItem(i).setVisible(true);
                        }
                        tx.setColumns(8);
                        tx.setText("     Search");
                        exp.setPreferredSize(new Dimension(85,25));
                    }
                     if(width_temp>size.width/2.28&&width_temp<=size.width/1.6){
                        for(int i=6;i<9;i++){
                        tempmenu.getItem(i).setVisible(true);
                        }
                        tx.setColumns(8);
                        tx.setText("     Search");
                        exp.setPreferredSize(new Dimension(100,30));
                    }
                     if(width_temp>size.width/1.6&&width_temp<=size.width/1.5){
                        for(int i=0;i<9;i++){
                        tempmenu.getItem(i).setVisible(false);
                        }
                        tx.setColumns(8);
            tx.setText("     Search");
            exp.setPreferredSize(new Dimension(130,40));
                    }
                     if(width_temp>size.width/1.5&&width_temp<=size.width/1.15){
                        for(int i=0;i<9;i++){
                            tempmenu.getItem(i).setVisible(false);
                            }
                            tx.setColumns(8);
            tx.setText("     Search");
            exp.setPreferredSize(new Dimension(150,50));
                    }
                    
                     if(width_temp>=size.width/1.15){
                        temp.setVisible(false);
                        tx.setColumns(13);
            tx.setText("                 Search");
            exp.setPreferredSize(new Dimension(150,50));
                    }
                    tx.addFocusListener(new FocusAdapter(){
                        public void focusGained(FocusEvent e){
                            tx.setText(null);
                        }
                        public void focusLost(FocusEvent e){
                            tx.setText("     Search");
                        }
                    });
    display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
    terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
   explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
   sp.setPreferredSize(new Dimension(this.getWidth()/6-10,this.getHeight()/2+50));
   codesp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
   index.setPreferredSize(new Dimension((this.getWidth()-this.getWidth()/6)/15,((this.getHeight()-this.getHeight()/20))/2));
  codesp.getViewport().setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2)); 
  terminalsp.getViewport().setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
 terminalsp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
 terminaltarea.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
                        this.setLocationRelativeTo(null);
                        this.setVisible(true);
                }
                // int key6=e.getKeyCode();
                if(key2==39){
                    if(maind!=null){
                        JPanel maindp=(JPanel)maind;
                        int tempwy=maindp.getComponent(1).getWidth();
                        int temphy=maindp.getComponent(1).getHeight();
                        JScrollPane y=(JScrollPane)maindp.getComponent(1);
                        y.setSize(tempwy+10, temphy);
                        JViewport temp=(JViewport)y.getComponent(0);
                temp.getComponent(0).setSize(temp.getComponent(0).getWidth()+10,temp.getComponent(0).getHeight());
                            maind.setSize(maind.getWidth()+10, maind.getHeight());
                            }
                }
                // int key7=e.getKeyCode();
                if(key2==37){
                    if(maind!=null){
                        JPanel maindp=(JPanel)maind;
                        int tempwy=maindp.getComponent(1).getWidth();
                        int temphy=maindp.getComponent(1).getHeight();
                        JScrollPane y=(JScrollPane)maindp.getComponent(1);
                        y.setSize(tempwy-10, temphy);
                        JViewport temp=(JViewport)y.getComponent(0);
                temp.getComponent(0).setSize(temp.getComponent(0).getWidth()-10,temp.getComponent(0).getHeight());
                            maind.setSize(maind.getWidth()-10, maind.getHeight());
                            }
                }
        }
    public void keyReleased(KeyEvent e){
    }
      Boolean b1=false,b2=false,b3=false,b4=false;
    public void keyTyped(KeyEvent e){
       int key1=e.getKeyChar();
        //  System.out.println(key1);
         if(key1==15){//for ctrl+o open file
            file_1_count=file_1_count-1;
                file_2_count=file_2_count-1;
                file_3_count=file_3_count-1;
                file_4_count=file_4_count-1;
                 JFileChooser opendialog=new JFileChooser();
                    int tempopen=opendialog.showOpenDialog(null);
                   if(tempopen==JFileChooser.APPROVE_OPTION){
                    fileopen=opendialog.getSelectedFile();
                    fileopenpath=fileopen.getAbsolutePath();
                   fileopenname=fileopen.getName();
                   if(fc<=5){
                    fc++;
                }
                File f_ext=fileopen;
                String name_for_ext=f_ext.getName();
                String ext="";
                int dot=name_for_ext.lastIndexOf(".");
                if(dot>0&dot<name_for_ext.length()-1){
                    ext=name_for_ext.substring(dot+1);
                }
                if(temp_new<=5){
                    temp_new++;
                }
                if(temp_new>5){
                    ImageIcon openerr = new ImageIcon("./image/warning_1.png");
                    Image openerro=openerr.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
                    ImageIcon openerron=new ImageIcon(openerro);
                    JLabel cmbox_l=new JLabel("Sorry for your inconvenience, but the current version of Orb permits only five files to be displayed concurrently. Please remove one or more files before opening or creating a new file.");
                    Toolkit tdir=Toolkit.getDefaultToolkit();
                    Dimension sizedir=tdir.getScreenSize();
                    cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
                    cmbox_l.setBackground(Color.BLACK);
                    cmbox_l.setForeground(Color.CYAN);
                    JOptionPane.showMessageDialog(null,cmbox_l,"Open Error"
                    ,JOptionPane.INFORMATION_MESSAGE,openerron);
                }
             switch(temp_new){
                case 2:
                switch(ext){
                    case "orb":
                    fileteron_2=orb_exton;
                    fileion_2=orb_exton;
                     break;
                    case "java":
                    fileteron_2=icon_java_ext;
                    fileion_2=icon_java_ext;
                    break;
                  }
                file2.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(true);
                file3butt.setVisible(false);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file3.setBorder(null);
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=2;
                file2isnew=true;
                 break;
                case 3:
                switch(ext){
                    case "orb":
                    fileteron_3=orb_exton;
                    fileion_3=orb_exton;
                     break;
                    case "java":
                    fileteron_3=icon_java_ext;
                    fileion_3=icon_java_ext;
                    break;
                  }
                file3.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(true);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=3;
                 file3isnew=true;
                 break;
                case 4:
                switch(ext){
                    case "orb":
                    fileteron_4=orb_exton;
                    fileion_4=orb_exton;
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
                    fileion_4=icon_java_ext;
                    break;
                  }
                file4.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(false);
                file4butt.setVisible(true);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(null);
                file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file5.setBorder(null);
                fileselect=4;
                file4isnew=true;
                 break;
                case 5:
                switch(ext){
                    case "orb":
                    fileteron_5=orb_exton;
                    fileion_5=orb_exton;
                     break;
                    case "java":
                    fileteron_5=icon_java_ext;
                    fileion_5=icon_java_ext;
                    break;
                  }
                 file5.setVisible(true);
                 file1butt.setVisible(false);
                 file2butt.setVisible(false);
                 file3butt.setVisible(false);
                 file4butt.setVisible(false);
                 file5butt.setVisible(true);
                 file1.setBorder(null);
                 file2.setBorder(null);
                 file3.setBorder(null);
                 file4.setBorder(null);
                 file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 fileselect=5;
                 file5isnew=true;
                  break;
             }
             if(temp_new<=5){
            try{
                File f_file=fileopen;
                    BufferedReader meta_3_file=new BufferedReader(new FileReader(f_file.getAbsolutePath()));
                    String f_temp_file,f_temp_console_file="";
                    while((f_temp_file=meta_3_file.readLine())!=null){
                        f_temp_console_file=f_temp_console_file+f_temp_file+"\n";
                    }
                    meta_3_file.close();
                  if(f_file.exists()){
                      index.setText(null);
                      index.setText(" 1  ");
                      codetarea.setText(f_temp_console_file);
                      if(fileselect==1){
                          file1.setText(f_file.getName());
                      }
                      if(fileselect==2){
                        file2.setText(f_file.getName());
                    }
                    if(fileselect==3){
                        file3.setText(f_file.getName());
                    }
                    if(fileselect==4){
                        file4.setText(f_file.getName());
                    }
                    if(fileselect==5){
                        file5.setText(f_file.getName());
                    }
                      for(int f_con_file=2;f_con_file<=codetarea.getLineCount();f_con_file++){
                              index.append("\n "+f_con_file+" ");
                       }
                  }
            }
            catch(IOException exc){
  
            }
        }
          try{
              String fc_s=Integer.toString(temp_new);
              if(temp_new<=5){
                  BufferedWriter filefctemp1=new BufferedWriter(new FileWriter(filefcpathmeta));
                                   filefctemp1.write(fc_s);
                                   filefctemp1.flush();
                                   filefctemp1.close();
             }
          }
          catch(IOException exc){
  
          }
                   }
        }
       if(key1==14){//for ctrl+n new file
        file_1_count=file_1_count-1;
                file_2_count=file_2_count-1;
                file_3_count=file_3_count-1;
                file_4_count=file_4_count-1;
                if(fc<=5){
                    fc++;
                }
                if(temp_new<=5){
                    temp_new++;
                }
                if(temp_new>5){
                    ImageIcon fnewerr = new ImageIcon("./image/warning_1.png");
        Image fnewerro=fnewerr.getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
        ImageIcon fnewerron=new ImageIcon(fnewerro);
        JLabel cmbox_l=new JLabel("Sorry for your inconvenience, but the current version of Orb permits only five files to be displayed concurrently. Please remove one or more files before opening or creating a new file.");
        Toolkit tdir=Toolkit.getDefaultToolkit();
        Dimension sizedir=tdir.getScreenSize();
        cmbox_l.setFont(new Font(Font.SERIF,Font.BOLD,(int)sizedir.width/85));
        cmbox_l.setBackground(Color.BLACK);
        cmbox_l.setForeground(Color.CYAN);
        JOptionPane.showMessageDialog(null,cmbox_l,"Open Error"
        ,JOptionPane.INFORMATION_MESSAGE,fnewerron);
                }
             switch(temp_new){
                case 2:
                file2.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(true);
                file3butt.setVisible(false);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file3.setBorder(null);
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=2;
                file2isnew=true;
                fileteron_2=orb_exton;
                fileion_2=orb_exton;
                 break;
                case 3:
                file3.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(true);
                file4butt.setVisible(false);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file4.setBorder(null);
                file5.setBorder(null);
                fileselect=3;
                file3isnew=true;
                fileteron_3=orb_exton;
                fileion_3=orb_exton;
                 break;
                case 4:
                file4.setVisible(true);
                file1butt.setVisible(false);
                file2butt.setVisible(false);
                file3butt.setVisible(false);
                file4butt.setVisible(true);
                file5butt.setVisible(false);
                file1.setBorder(null);
                file2.setBorder(null);
                file3.setBorder(null);
                file4.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                file5.setBorder(null);
                fileselect=4;
                file4isnew=true;
                fileteron_4=orb_exton;
                fileion_4=orb_exton;
                 break;
                case 5:
                 file5.setVisible(true);
                 file1butt.setVisible(false);
                 file2butt.setVisible(false);
                 file3butt.setVisible(false);
                 file4butt.setVisible(false);
                 file5butt.setVisible(true);
                 file1.setBorder(null);
                 file2.setBorder(null);
                 file3.setBorder(null);
                 file4.setBorder(null);
                 file5.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.CYAN));
                 fileselect=5;
                 file5isnew=true;
                 fileteron_5=orb_exton;
                 fileion_5=orb_exton;
                  break;
             }
             if(temp_new<=5){
                 codetarea.setText(null);
                 index.setText(null);
                 codetarea.setText("//  Welcome To Orb");
                 index.setText(" 1  ");
             }
          try{
              String fc_s=Integer.toString(temp_new);
              if(temp_new<=5){
                  BufferedWriter filefctemp1=new BufferedWriter(new FileWriter(filefcpathmeta));
                                   filefctemp1.write(fc_s);
                                   filefctemp1.flush();
                                   filefctemp1.close();
             }
          }
          catch(IOException exc){
  
          }
       }
       if(key1==83){//for shift+S saveas file 
        try{
            BufferedReader filesavermeta=new BufferedReader(new FileReader(filesavepathmeta));
        file1save=Boolean.valueOf(filesavermeta.readLine());
        file2save=Boolean.valueOf(filesavermeta.readLine());
        file3save=Boolean.valueOf(filesavermeta.readLine());
        file4save=Boolean.valueOf(filesavermeta.readLine());
        file5save=Boolean.valueOf(filesavermeta.readLine());
        filesavermeta.close();
        }
        catch(IOException exc){

        }
        JFileChooser savedialog=new JFileChooser();
        int tempsaveas=savedialog.showSaveDialog(null);
        if(tempsaveas==JFileChooser.APPROVE_OPTION){
            switch(fileselect){
                case 1:
                filetemp1=savedialog.getSelectedFile();
                filenametemp1=filetemp1.getName();
                filepathtemp1=filetemp1.getAbsolutePath();
               String filecontenttemp1=codetarea.getText();
               file1.setText(filenametemp1);
               file1.setIcon(null);
               file1.removeMouseListener(new Temp4());
               file1.addMouseListener(new Temp5());
               File f1_ext=filetemp1;
               String name_for_ext_1=f1_ext.getName();
               String ext_1="";
               int dot_1=name_for_ext_1.lastIndexOf(".");
               if(dot_1>0&dot_1<name_for_ext_1.length()-1){
                   ext_1=name_for_ext_1.substring(dot_1+1);
               }
               switch(ext_1){
                   case "orb":
                   fileteron_1=orb_exton;
                   fileion_1=orb_exton;
                    break;
                   case "java":
                   fileteron_1=icon_java_ext;
                   fileion_1=icon_java_ext;
                   break;
                 }
              try{
                  if(!filetemp1.exists()){
                          filetemp1.createNewFile();
                  }
                    BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                   filebftemp1.write(filecontenttemp1);
                   filebftemp1.close();
                   String s[]=new String[5];
                   BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                   String x= filebfrtempmeta1.readLine();
                   if(x==null){
                    BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                    filebftempmeta1.write(filepathtemp1);
                    filebftempmeta1.newLine();
                    filebftempmeta1.flush();
                    filebftempmeta1.close();
                   }
                   if(x!=null){
                    for(int i=1;i<5;i++){
                        s[i]=filebfrtempmeta1.readLine();
                    }
                    filebfrtempmeta1.close();
                    BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                    filebftempmeta1.write("");
                    filebftempmeta1.flush();
                    filebftempmeta1.close();
                    BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                    filebfwtempmeta1.write(filepathtemp1);
                    filebfwtempmeta1.newLine();
                    if(s[1]!=null){
                        filebfwtempmeta1.write(s[1]);
                        filebfwtempmeta1.newLine();
                    }
                    if(s[2]!=null){
                        filebfwtempmeta1.write(s[2]);
                        filebfwtempmeta1.newLine();
                    }
                    if(s[3]!=null){
                        filebfwtempmeta1.write(s[3]);
                        filebfwtempmeta1.newLine();
                    }
                    if(s[4]!=null){
                        filebfwtempmeta1.write(s[4]);
                        filebfwtempmeta1.newLine();
                    }
                    filebfwtempmeta1.flush();
                    filebfwtempmeta1.close();
                }
            }
              catch(IOException exc){

              }
              file1save=true;
              break;
                case 2:
                filetemp2=savedialog.getSelectedFile();
                filenametemp2=filetemp2.getName();
                filepathtemp2=filetemp2.getAbsolutePath();
               String filecontenttemp2=codetarea.getText();
               file2.setText(filenametemp2);
               file2.setIcon(null);
               file2.removeMouseListener(new Temp4());
               file2.addMouseListener(new Temp5());
               File f2_ext=filetemp2;
               String name_for_ext_2=f2_ext.getName();
               String ext_2="";
               int dot_2=name_for_ext_2.lastIndexOf(".");
               if(dot_2>0&dot_2<name_for_ext_2.length()-1){
                   ext_2=name_for_ext_2.substring(dot_2+1);
               }
               switch(ext_2){
                   case "orb":
                   fileteron_2=orb_exton;
                   fileion_2=orb_exton;
                    break;
                   case "java":
                   fileteron_2=icon_java_ext;
                   fileion_2=icon_java_ext;
                   break;
                 }
              try{
                  if(!filetemp2.exists()){
                          filetemp2.createNewFile();
                  }
                    BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                   filebftemp2.write(filecontenttemp2);
                   filebftemp2.flush();
                   filebftemp2.close();
                   String s[]=new String[5];
                   BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                   for(int i=0;i<1;i++){
                       s[i]=filebfrtempmeta2.readLine();
                   }
                   String x= filebfrtempmeta2.readLine();
                   if(x==null){
                    BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                    filebftempmeta2.write(filepathtemp2);
                    filebftempmeta2.newLine();
                    filebftempmeta2.flush();
                    filebftempmeta2.close();
                   }
                   if(x!=null){
                    for(int i=2;i<5;i++){
                        s[i]=filebfrtempmeta2.readLine();
                    }
                    filebfrtempmeta2.close();
                    BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                    filebftempmeta2.write("");
                    filebftempmeta2.flush();
                    filebftempmeta2.close();
                    BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                    if(s[0]!=null){
                        filebfwtempmeta2.write(s[0]);
                        filebfwtempmeta2.newLine();
                    }
                    filebfwtempmeta2.write(filepathtemp2);
                    filebfwtempmeta2.newLine();
                    if(s[2]!=null){
                        filebfwtempmeta2.write(s[2]);
                        filebfwtempmeta2.newLine();
                    }
                    if(s[3]!=null){
                        filebfwtempmeta2.write(s[3]);
                        filebfwtempmeta2.newLine();
                    }
                    if(s[4]!=null){
                        filebfwtempmeta2.write(s[4]);
                        filebfwtempmeta2.newLine();
                    }
                    filebfwtempmeta2.flush();
                    filebfwtempmeta2.close();
                   }
                }
                catch(IOException exc){

                }
                file2save=true;
              break;
              case 3:
                filetemp3=savedialog.getSelectedFile();
                filenametemp3=filetemp3.getName();
                filepathtemp3=filetemp3.getAbsolutePath();
               String filecontenttemp3=codetarea.getText();
               file3.setText(filenametemp3);
               file3.setIcon(null);
               file3.removeMouseListener(new Temp4());
               file3.addMouseListener(new Temp5());
               File f3_ext=filetemp3;
               String name_for_ext_3=f3_ext.getName();
               String ext_3="";
               int dot_3=name_for_ext_3.lastIndexOf(".");
               if(dot_3>0&dot_3<name_for_ext_3.length()-1){
                   ext_3=name_for_ext_3.substring(dot_3+1);
               }
               switch(ext_3){
                   case "orb":
                   fileteron_3=orb_exton;
                   fileion_3=orb_exton;
                    break;
                   case "java":
                   fileteron_3=icon_java_ext;
                   fileion_3=icon_java_ext;
                   break;
                 }
              try{
                  if(!filetemp3.exists()){
                          filetemp3.createNewFile();
                  }
                    BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                   filebftemp3.write(filecontenttemp3);
                   filebftemp3.flush();
                   filebftemp3.close();
                String s[]=new String[5];
                   BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                   for(int i=0;i<2;i++){
                       s[i]=filebfrtempmeta3.readLine();
                   }
                   String x= filebfrtempmeta3.readLine();
                   if(x==null){
                    BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                    filebftempmeta3.write(filepathtemp3);
                    filebftempmeta3.newLine();
                    filebftempmeta3.flush();
                    filebftempmeta3.close();
                   }
                   if(x!=null){
                    for(int i=3;i<5;i++){
                        s[i]=filebfrtempmeta3.readLine();
                    }
                    filebfrtempmeta3.close();
                    BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                    filebftempmeta3.write("");
                    filebftempmeta3.flush();
                    filebftempmeta3.close();
                    BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                    if(s[0]!=null){
                        filebfwtempmeta3.write(s[0]);
                        filebfwtempmeta3.newLine();
                    }
                    if(s[1]!=null){
                        filebfwtempmeta3.write(s[1]);
                        filebfwtempmeta3.newLine();
                    }
                    filebfwtempmeta3.write(filepathtemp3);
                    filebfwtempmeta3.newLine();
                    if(s[3]!=null){
                        filebfwtempmeta3.write(s[3]);
                        filebfwtempmeta3.newLine();
                    }
                    if(s[4]!=null){
                        filebfwtempmeta3.write(s[4]);
                        filebfwtempmeta3.newLine();
                    }
                    filebfwtempmeta3.flush();
                    filebfwtempmeta3.close();
                   }
              }
              catch(IOException exc){

              }
              file3save=true;
              break;
              case 4:
              filetemp4=savedialog.getSelectedFile();
              filenametemp4=filetemp4.getName();
              filepathtemp4=filetemp4.getAbsolutePath();
             String filecontenttemp4=codetarea.getText();
             file4.setText(filenametemp4);
             file4.setIcon(null);
             file4.removeMouseListener(new Temp4());
             file4.addMouseListener(new Temp5());
             File f4_ext=filetemp4;
             String name_for_ext_4=f4_ext.getName();
             String ext_4="";
             int dot_4=name_for_ext_4.lastIndexOf(".");
             if(dot_4>0&dot_4<name_for_ext_4.length()-1){
                 ext_4=name_for_ext_4.substring(dot_4+1);
             }
             switch(ext_4){
                 case "orb":
                 fileteron_4=orb_exton;
                 fileion_4=orb_exton;
                  break;
                 case "java":
                 fileteron_4=icon_java_ext;
                 fileion_4=icon_java_ext;
                 break;
               }
            try{
                if(!filetemp4.exists()){
                        filetemp4.createNewFile();
                }
                  BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                 filebftemp4.write(filecontenttemp4);
                 filebftemp4.flush();
                 filebftemp4.close();
                 String s[]=new String[5];
                   BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                   for(int i=0;i<3;i++){
                       s[i]=filebfrtempmeta4.readLine();
                   }
                   String x= filebfrtempmeta4.readLine();
                   if(x==null){
                    BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                    filebftempmeta4.write(filepathtemp4);
                    filebftempmeta4.newLine();
                    filebftempmeta4.flush();
                    filebftempmeta4.close();
                   }
                   if(x!=null){
                    for(int i=4;i<5;i++){
                        s[i]=filebfrtempmeta4.readLine();
                    }
                    filebfrtempmeta4.close();
                    BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                    filebftempmeta4.write("");
                    filebftempmeta4.flush();
                    filebftempmeta4.close();
                    BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                    if(s[0]!=null){
                        filebfwtempmeta4.write(s[0]);
                        filebfwtempmeta4.newLine();
                    }
                    if(s[1]!=null){
                        filebfwtempmeta4.write(s[1]);
                        filebfwtempmeta4.newLine();
                    }
                    if(s[2]!=null){
                        filebfwtempmeta4.write(s[2]);
                        filebfwtempmeta4.newLine();
                    }
                    filebfwtempmeta4.write(filepathtemp4);
                    filebfwtempmeta4.newLine();
                    if(s[4]!=null){
                        filebfwtempmeta4.write(s[4]);
                        filebfwtempmeta4.newLine();
                    }
                    filebfwtempmeta4.flush();
                    filebfwtempmeta4.close();
                }
            }
            catch(IOException exc){

            }
            file4save=true;
            break;
            case 5:
            filetemp5=savedialog.getSelectedFile();
            filenametemp5=filetemp5.getName();
            filepathtemp5=filetemp5.getAbsolutePath();
           String filecontenttemp5=codetarea.getText();
           file5.setText(filenametemp5);
           file5.setIcon(null);
           file5.removeMouseListener(new Temp4());
           file5.addMouseListener(new Temp5());
           File f5_ext=filetemp5;
               String name_for_ext_5=f5_ext.getName();
               String ext_5="";
               int dot_5=name_for_ext_5.lastIndexOf(".");
               if(dot_5>0&dot_5<name_for_ext_5.length()-1){
                   ext_5=name_for_ext_5.substring(dot_5+1);
               }
               switch(ext_5){
                   case "orb":
                   fileteron_5=orb_exton;
                   fileion_5=orb_exton;
                    break;
                   case "java":
                   fileteron_5=icon_java_ext;
                   fileion_5=icon_java_ext;
                   break;
                 }
          try{
              if(!filetemp5.exists()){
                      filetemp5.createNewFile();
              }
                BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
               filebftemp5.write(filecontenttemp5);
               filebftemp5.flush();
               filebftemp5.close();
               String s[]=new String[5];
                   BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                   for(int i=0;i<4;i++){
                       s[i]=filebfrtempmeta5.readLine();
                   }
                   String x= filebfrtempmeta5.readLine();
                   filebfrtempmeta5.close();
                   if(x==null){
                    BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                    filebftempmeta5.write(filepathtemp5);
                    filebftempmeta5.newLine();
                    filebftempmeta5.flush();
                    filebftempmeta5.close();
                   }
                   if(x!=null){
                    BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                    filebftempmeta5.write("");
                    filebftempmeta5.flush();
                    filebftempmeta5.close();
                    BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                    if(s[0]!=null){
                        filebfwtempmeta5.write(s[0]);
                        filebfwtempmeta5.newLine();
                    }
                    if(s[1]!=null){
                        filebfwtempmeta5.write(s[1]);
                        filebfwtempmeta5.newLine();
                    }
                    if(s[2]!=null){
                        filebfwtempmeta5.write(s[2]);
                        filebfwtempmeta5.newLine();
                    }
                    if(s[3]!=null){
                        filebfwtempmeta5.write(s[3]);
                        filebfwtempmeta5.newLine();
                    }
                    filebfwtempmeta5.write(filepathtemp5);
                    filebfwtempmeta5.newLine();
                    filebfwtempmeta5.flush();
                    filebfwtempmeta5.close();
                }
            }
          catch(IOException exc){

          }
          file5save=true;
          break;
            }
            try{
                BufferedWriter filesavemeta=new BufferedWriter(new FileWriter(filesavepathmeta));
                        String filesavetemp1=String.valueOf(file1save);
                        String filesavetemp2=String.valueOf(file2save);
                        String filesavetemp3=String.valueOf(file3save);
                        String filesavetemp4=String.valueOf(file4save);
                        String filesavetemp5=String.valueOf(file5save);
                        filesavemeta.write(filesavetemp1);
                        filesavemeta.newLine();
                        filesavemeta.write(filesavetemp2);
                        filesavemeta.newLine();
                        filesavemeta.write(filesavetemp3);
                        filesavemeta.newLine();
                        filesavemeta.write(filesavetemp4);
                        filesavemeta.newLine();
                        filesavemeta.write(filesavetemp5);
                        filesavemeta.flush();
                        filesavemeta.close();
            }
            catch(IOException exc){

            }
        }
       }
       if(key1==19){//for ctrl+S save
        try{
            BufferedReader filesavermeta=new BufferedReader(new FileReader(filesavepathmeta));
        file1save=Boolean.valueOf(filesavermeta.readLine());
        file2save=Boolean.valueOf(filesavermeta.readLine());
        file3save=Boolean.valueOf(filesavermeta.readLine());
        file4save=Boolean.valueOf(filesavermeta.readLine());
        file5save=Boolean.valueOf(filesavermeta.readLine());
        filesavermeta.close();
        }
        catch(IOException exc){

        }
            String filecontenttemp=codetarea.getText();
            try{
               String s[]=new String[5];
            BufferedReader meta=new BufferedReader(new FileReader(filepathmeta));
            for(int i=0;i<5;i++){
                s[i]=meta.readLine();
            }
            meta.close();
            switch(fileselect){
                case 1:
                Boolean tempboolfile1=false;
                file1.removeMouseListener(new Temp4());
                file1.addMouseListener(new Temp5());
                fcheck=new File(s[0]);
                filetemp1=fcheck;
                filepathtemp1=filetemp1.getAbsolutePath();
               filenametemp1=filetemp1.getName();
                if(fcheck.exists()==false&tempboolfile1==false){
                   JFileChooser savedialog=new JFileChooser();
                   int tempsave=savedialog.showSaveDialog(null);
                  if(tempsave==JFileChooser.APPROVE_OPTION){
                     filetemp1=savedialog.getSelectedFile();
                      filepathtemp1=filetemp1.getAbsolutePath();
                     filenametemp1=filetemp1.getName();
                     file1.setText(filenametemp1);
                     file1.setIcon(null);
                     File f1_ext=filetemp1;
                     String name_for_ext_1=f1_ext.getName();
                     String ext_1="";
                     int dot_1=name_for_ext_1.lastIndexOf(".");
                     if(dot_1>0&dot_1<name_for_ext_1.length()-1){
                         ext_1=name_for_ext_1.substring(dot_1+1);
                     }
                     switch(ext_1){
                         case "orb":
                         fileteron_1=orb_exton;
                         fileion_1=orb_exton;
                          break;
                         case "java":
                         fileteron_1=icon_java_ext;
                         fileion_1=icon_java_ext;
                         break;
                       }
                     tempboolfile1=true;
                     BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                     filebftemp1.write(filecontenttemp);
                     filebftemp1.flush();
                     filebftemp1.close();
                }
            }
                if(fcheck.exists()==true&tempboolfile1==false&(fcheck.getName().equals(file1.getText()))){
                    tempboolfile1=true;
                    filetemp1=fcheck;
                    filepathtemp1=filetemp1.getAbsolutePath();
                   filenametemp1=filetemp1.getName();
                   String filecontenttemp1=codetarea.getText();
                   file1.setText(filenametemp1);
                   file1.setIcon(null);
                   file1.removeMouseListener(new Temp4());
                   file1.addMouseListener(new Temp5());
                  try{
                        BufferedWriter filebftemp1=new BufferedWriter(new FileWriter(filepathtemp1));
                       filebftemp1.write(filecontenttemp1);
                       filebftemp1.flush();
                       filebftemp1.close();
                }
                  catch(IOException exc){

                  }
                }
                try{
                    String s_1[]=new String[5];
                    BufferedReader filebfrtempmeta1=new BufferedReader(new FileReader(filepathmeta));
                    String x= filebfrtempmeta1.readLine();
                    if(x==null){
                     BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                     filebftempmeta1.write(filepathtemp1);
                     filebftempmeta1.newLine();
                     filebftempmeta1.flush();
                     filebftempmeta1.close();
                    }
                    if(x!=null){
                     for(int i=1;i<5;i++){
                         s_1[i]=filebfrtempmeta1.readLine();
                     }
                     filebfrtempmeta1.close();
                     BufferedWriter filebftempmeta1=new BufferedWriter(new FileWriter(filepathmeta));
                     filebftempmeta1.write("");
                     filebftempmeta1.flush();
                     filebftempmeta1.close();
                     BufferedWriter filebfwtempmeta1=new BufferedWriter(new FileWriter(filepathmeta,true));
                     filebfwtempmeta1.write(filepathtemp1);
                     filebfwtempmeta1.newLine();
                     if(s_1[1]!=null){
                         filebfwtempmeta1.write(s_1[1]);
                         filebfwtempmeta1.newLine();
                     }
                     if(s_1[2]!=null){
                         filebfwtempmeta1.write(s_1[2]);
                         filebfwtempmeta1.newLine();
                     }
                     if(s_1[3]!=null){
                         filebfwtempmeta1.write(s_1[3]);
                         filebfwtempmeta1.newLine();
                     }
                     if(s_1[4]!=null){
                         filebfwtempmeta1.write(s_1[4]);
                         filebfwtempmeta1.newLine();
                     }
                     filebfwtempmeta1.flush();
                     filebfwtempmeta1.close();
                 }
                }
                catch(IOException exc){

                }
                file1save=true;
                break;
             case 2:
             Boolean tempboolfile2=false;
             file2.removeMouseListener(new Temp4());
              file2.addMouseListener(new Temp5());
             fcheck=new File(s[1]);
             filetemp2=fcheck;
                filepathtemp2=filetemp2.getAbsolutePath();
               filenametemp2=filetemp2.getName();
             if((fcheck.exists()==false||file2isnew==true)&tempboolfile2==false){
                JFileChooser savedialog=new JFileChooser();
                int tempsave=savedialog.showSaveDialog(null);
               if(tempsave==JFileChooser.APPROVE_OPTION){
                  filetemp2=savedialog.getSelectedFile();
                   filepathtemp2=filetemp2.getAbsolutePath();
                  filenametemp2=filetemp2.getName();
                  file2.setText(filenametemp2);
                  file2.setIcon(null);
                  File f2_ext=filetemp2;
                  String name_for_ext_2=f2_ext.getName();
                  String ext_2="";
                  int dot_2=name_for_ext_2.lastIndexOf(".");
                  if(dot_2>0&dot_2<name_for_ext_2.length()-1){
                      ext_2=name_for_ext_2.substring(dot_2+1);
                  }
                  switch(ext_2){
                      case "orb":
                      fileteron_2=orb_exton;
                      fileion_2=orb_exton;
                       break;
                      case "java":
                      fileteron_2=icon_java_ext;
                      fileion_2=icon_java_ext;
                      break;
                    }
                  tempboolfile2=true;
                  BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                  filebftemp2.write(filecontenttemp);
                  filebftemp2.flush();
                  filebftemp2.close();
                  file2isnew=false;
             }
         }
             if(fcheck.exists()==true&tempboolfile2==false&(fcheck.getName().equals(file2.getText()))){
                tempboolfile2=true;
                filetemp2=fcheck;
                filepathtemp2=filetemp2.getAbsolutePath();
               filenametemp2=filetemp2.getName();
                String filecontenttemp2=codetarea.getText();
                file2.setText(filenametemp2);
                file2.setIcon(null);
                file2.removeMouseListener(new Temp4());
                 file2.addMouseListener(new Temp5());
               try{
                     BufferedWriter filebftemp2=new BufferedWriter(new FileWriter(filepathtemp2));
                    filebftemp2.write(filecontenttemp2);
                    filebftemp2.flush();
                    filebftemp2.close();
                 }
                 catch(IOException exc){

                 }
             }
             try{
                String s_2[]=new String[5];
                BufferedReader filebfrtempmeta2=new BufferedReader(new FileReader(filepathmeta));
                for(int i=0;i<1;i++){
                    s_2[i]=filebfrtempmeta2.readLine();
                }
                String x= filebfrtempmeta2.readLine();
                if(x==null){
                 BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                 filebftempmeta2.write(filepathtemp2);
                 filebftempmeta2.newLine();
                 filebftempmeta2.flush();
                 filebftempmeta2.close();
                }
                if(x!=null){
                 for(int i=2;i<5;i++){
                     s_2[i]=filebfrtempmeta2.readLine();
                 } 
                  filebfrtempmeta2.close();
                 BufferedWriter filebftempmeta2=new BufferedWriter(new FileWriter(filepathmeta));
                 filebftempmeta2.write("");
                 filebftempmeta2.flush();
                 filebftempmeta2.close();
                 BufferedWriter filebfwtempmeta2=new BufferedWriter(new FileWriter(filepathmeta,true));
                 if(s_2[0]!=null){
                     filebfwtempmeta2.write(s_2[0]);
                     filebfwtempmeta2.newLine();
                 }
                 filebfwtempmeta2.write(filepathtemp2);
                 filebfwtempmeta2.newLine();
                 if(s_2[2]!=null){
                     filebfwtempmeta2.write(s_2[2]);
                     filebfwtempmeta2.newLine();
                 }
                 if(s_2[3]!=null){
                     filebfwtempmeta2.write(s_2[3]);
                     filebfwtempmeta2.newLine();
                 }
                 if(s_2[4]!=null){
                     filebfwtempmeta2.write(s_2[4]);
                     filebfwtempmeta2.newLine();
                 }
                 filebfwtempmeta2.flush();
                 filebfwtempmeta2.close();
                }
             }
             catch(IOException exc){

            }
            file2save=true;
             break;
             case 3:
              Boolean tempboolfile3=false;
              file3.removeMouseListener(new Temp4());
            file3.addMouseListener(new Temp5());
             fcheck=new File(s[2]);
             filetemp3=fcheck;
             filenametemp3=filetemp3.getName();
             filepathtemp3=filetemp3.getAbsolutePath();
                if((fcheck.exists()==false||file3isnew==true)&tempboolfile3==false){
                   JFileChooser savedialog=new JFileChooser();
                   int tempsave=savedialog.showSaveDialog(null);
                  if(tempsave==JFileChooser.APPROVE_OPTION){
                     filetemp3=savedialog.getSelectedFile();
                      filepathtemp3=filetemp3.getAbsolutePath();
                     filenametemp3=filetemp3.getName();
                     file3.setText(filenametemp3);
                     file3.setIcon(null);
                     File f3_ext=filetemp3;
                     String name_for_ext_3=f3_ext.getName();
                     String ext_3="";
                     int dot_3=name_for_ext_3.lastIndexOf(".");
                     if(dot_3>0&dot_3<name_for_ext_3.length()-1){
                         ext_3=name_for_ext_3.substring(dot_3+1);
                     }
                     switch(ext_3){
                         case "orb":
                         fileteron_3=orb_exton;
                         fileion_3=orb_exton;
                          break;
                         case "java":
                         fileteron_3=icon_java_ext;
                         fileion_3=icon_java_ext;
                         break;
                       }
                     tempboolfile3=true;
                     BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                     filebftemp3.write(filecontenttemp);
                     filebftemp3.flush();
                     filebftemp3.close();
                     file3isnew=false;
                }
            }
                if(fcheck.exists()==true&tempboolfile3==false&(fcheck.getName().equals(file3.getText()))){
                    tempboolfile3=true;
                    filetemp3=fcheck;
                filenametemp3=filetemp3.getName();
                filepathtemp3=filetemp3.getAbsolutePath();
               String filecontenttemp3=codetarea.getText();
               file3.setText(filenametemp3);
               file3.setIcon(null);
               file3.removeMouseListener(new Temp4());
               file3.addMouseListener(new Temp5());
              try{
                    BufferedWriter filebftemp3=new BufferedWriter(new FileWriter(filepathtemp3));
                   filebftemp3.write(filecontenttemp3);
                   filebftemp3.flush();
                   filebftemp3.close();
              }
              catch(IOException exc){

              }
                }
                try{
                    String s_3[]=new String[5];
                   BufferedReader filebfrtempmeta3=new BufferedReader(new FileReader(filepathmeta));
                   for(int i=0;i<2;i++){
                       s_3[i]=filebfrtempmeta3.readLine();
                   }
                   String x= filebfrtempmeta3.readLine();
                   if(x==null){
                    BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                    filebftempmeta3.write(filepathtemp3);
                    filebftempmeta3.newLine();
                    filebftempmeta3.flush();
                    filebftempmeta3.close();
                   }
                   if(x!=null){
                    for(int i=3;i<5;i++){
                        s_3[i]=filebfrtempmeta3.readLine();
                    }
                    filebfrtempmeta3.close();
                    BufferedWriter filebftempmeta3=new BufferedWriter(new FileWriter(filepathmeta));
                    filebftempmeta3.write("");
                    filebftempmeta3.flush();
                    filebftempmeta3.close();
                    BufferedWriter filebfwtempmeta3=new BufferedWriter(new FileWriter(filepathmeta,true));
                    if(s_3[0]!=null){
                        filebfwtempmeta3.write(s_3[0]);
                        filebfwtempmeta3.newLine();
                    }
                    if(s_3[1]!=null){
                        filebfwtempmeta3.write(s_3[1]);
                        filebfwtempmeta3.newLine();
                    }
                    filebfwtempmeta3.write(filepathtemp3);
                    filebfwtempmeta3.newLine();
                    if(s_3[3]!=null){
                        filebfwtempmeta3.write(s_3[3]);
                        filebfwtempmeta3.newLine();
                    }
                    if(s_3[4]!=null){
                        filebfwtempmeta3.write(s_3[4]);
                        filebfwtempmeta3.newLine();
                    }
                    filebfwtempmeta3.flush();
                    filebfwtempmeta3.close();
                   }
                }
                catch(IOException exc){

                }
                file3save=true;
                break;
                case 4:
                Boolean tempboolfile4=false;
                file4.removeMouseListener(new Temp4());
                file4.addMouseListener(new Temp5());
                fcheck=new File(s[3]);
                filetemp4=fcheck;
                    filepathtemp4=filetemp4.getAbsolutePath();
                   filenametemp4=filetemp4.getName();
                if((fcheck.exists()==false||file4isnew==true)&tempboolfile4==false){
                   JFileChooser savedialog=new JFileChooser();
                   int tempsave=savedialog.showSaveDialog(null);
                  if(tempsave==JFileChooser.APPROVE_OPTION){
                     filetemp4=savedialog.getSelectedFile();
                      filepathtemp4=filetemp4.getAbsolutePath();
                     filenametemp4=filetemp4.getName();
                     file4.setText(filenametemp4);
                     file4.setIcon(null);
                     File f4_ext=filetemp4;
                     String name_for_ext_4=f4_ext.getName();
                     String ext_4="";
                     int dot_4=name_for_ext_4.lastIndexOf(".");
                     if(dot_4>0&dot_4<name_for_ext_4.length()-1){
                         ext_4=name_for_ext_4.substring(dot_4+1);
                     }
                     switch(ext_4){
                         case "orb":
                         fileteron_4=orb_exton;
                         fileion_4=orb_exton;
                          break;
                         case "java":
                         fileteron_4=icon_java_ext;
                         fileion_4=icon_java_ext;
                         break;
                       }
                     tempboolfile4=true;
                     BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                     filebftemp4.write(filecontenttemp);
                     filebftemp4.flush();
                     filebftemp4.close();
                     file4isnew=false;
                }
            }
                if(fcheck.exists()==true&tempboolfile4==false&(fcheck.getName().equals(file4.getText()))){
                    tempboolfile4=true;
                    filetemp4=fcheck;
                    filepathtemp4=filetemp4.getAbsolutePath();
                   filenametemp4=filetemp4.getName();
             String filecontenttemp4=codetarea.getText();
             file4.setText(filenametemp4);
             file4.setIcon(null);
             file4.removeMouseListener(new Temp4());
             file4.addMouseListener(new Temp5());
            try{
                  BufferedWriter filebftemp4=new BufferedWriter(new FileWriter(filepathtemp4));
                 filebftemp4.write(filecontenttemp4);
                 filebftemp4.flush();
                 filebftemp4.close();
            }
            catch(IOException exc){

            }
                }
                try{
                    String s_4[]=new String[5];
                    BufferedReader filebfrtempmeta4=new BufferedReader(new FileReader(filepathmeta));
                    for(int i=0;i<3;i++){
                        s_4[i]=filebfrtempmeta4.readLine();
                    }
                    String x= filebfrtempmeta4.readLine();
                    if(x==null){
                     BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                     filebftempmeta4.write(filepathtemp4);
                     filebftempmeta4.newLine();
                     filebftempmeta4.flush();
                     filebftempmeta4.close();
                    }
                    if(x!=null){
                     for(int i=4;i<5;i++){
                         s_4[i]=filebfrtempmeta4.readLine();
                     }
                     filebfrtempmeta4.close();
                     BufferedWriter filebftempmeta4=new BufferedWriter(new FileWriter(filepathmeta));
                     filebftempmeta4.write("");
                     filebftempmeta4.flush();
                     filebftempmeta4.close();
                     BufferedWriter filebfwtempmeta4=new BufferedWriter(new FileWriter(filepathmeta,true));
                     if(s_4[0]!=null){
                         filebfwtempmeta4.write(s_4[0]);
                         filebfwtempmeta4.newLine();
                     }
                     if(s_4[1]!=null){
                         filebfwtempmeta4.write(s_4[1]);
                         filebfwtempmeta4.newLine();
                     }
                     if(s_4[2]!=null){
                         filebfwtempmeta4.write(s_4[2]);
                         filebfwtempmeta4.newLine();
                     }
                     filebfwtempmeta4.write(filepathtemp4);
                     filebfwtempmeta4.newLine();
                     if(s_4[4]!=null){
                         filebfwtempmeta4.write(s_4[4]);
                         filebfwtempmeta4.newLine();
                     }
                     filebfwtempmeta4.flush();
                     filebfwtempmeta4.close();
                 }
                }
                catch(IOException exc){

                }
                file4save=true;
                break;
                case 5:
                Boolean tempboolfile5=false;
                file5.removeMouseListener(new Temp4());
                file5.addMouseListener(new Temp5());
                fcheck=new File(s[4]);
                filetemp5=fcheck;
                filepathtemp5=filetemp5.getAbsolutePath();
               filenametemp5=filetemp5.getName();
                if((fcheck.exists()==false||file5isnew==true)&tempboolfile5==false){
                   JFileChooser savedialog=new JFileChooser();
                   int tempsave=savedialog.showSaveDialog(null);
                  if(tempsave==JFileChooser.APPROVE_OPTION){
                     filetemp5=savedialog.getSelectedFile();
                      filepathtemp5=filetemp5.getAbsolutePath();
                     filenametemp5=filetemp5.getName();
                     file5.setText(filenametemp5);
                     file5.setIcon(null);
                     File f5_ext=filetemp5;
                     String name_for_ext_5=f5_ext.getName();
                     String ext_5="";
                     int dot_5=name_for_ext_5.lastIndexOf(".");
                     if(dot_5>0&dot_5<name_for_ext_5.length()-1){
                         ext_5=name_for_ext_5.substring(dot_5+1);
                     }
                     switch(ext_5){
                         case "orb":
                         fileteron_5=orb_exton;
                         fileion_5=orb_exton;
                          break;
                         case "java":
                         fileteron_5=icon_java_ext;
                         fileion_5=icon_java_ext;
                         break;
                       }
                     tempboolfile5=true;
                     BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                     filebftemp5.write(filecontenttemp);
                     filebftemp5.flush();
                     filebftemp5.close();
                     file5isnew=false;
                }
            }
                if(fcheck.exists()==true&tempboolfile5==false&(fcheck.getName().equals(file5.getText()))){
                    tempboolfile5=true;
                    filetemp5=fcheck;
                    filepathtemp5=filetemp5.getAbsolutePath();
                   filenametemp5=filetemp5.getName();
                    String filecontenttemp5=codetarea.getText();
                    file5.setText(filenametemp5);
                    file5.setIcon(null);
                    file5.removeMouseListener(new Temp4());
                    file5.addMouseListener(new Temp5());
                   try{
                         BufferedWriter filebftemp5=new BufferedWriter(new FileWriter(filepathtemp5));
                        filebftemp5.write(filecontenttemp5);
                        filebftemp5.flush();
                        filebftemp5.close();
                     }
                   catch(IOException exc){
 
                   }
                }
                try{
                    String s_5[]=new String[5];
                            BufferedReader filebfrtempmeta5=new BufferedReader(new FileReader(filepathmeta));
                            for(int i=0;i<4;i++){
                                s_5[i]=filebfrtempmeta5.readLine();
                            }
                            String x= filebfrtempmeta5.readLine();
                            filebfrtempmeta5.close();
                            if(x==null){
                             BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                             filebftempmeta5.write(filepathtemp5);
                             filebftempmeta5.newLine();
                             filebftempmeta5.flush();
                             filebftempmeta5.close();
                            }
                            if(x!=null){
                             BufferedWriter filebftempmeta5=new BufferedWriter(new FileWriter(filepathmeta));
                             filebftempmeta5.write("");
                             filebftempmeta5.flush();
                             filebftempmeta5.close();
                             BufferedWriter filebfwtempmeta5=new BufferedWriter(new FileWriter(filepathmeta,true));
                             if(s_5[0]!=null){
                                 filebfwtempmeta5.write(s_5[0]);
                                 filebfwtempmeta5.newLine();
                             }
                             if(s_5[1]!=null){
                                 filebfwtempmeta5.write(s_5[1]);
                                 filebfwtempmeta5.newLine();
                             }
                             if(s_5[2]!=null){
                                 filebfwtempmeta5.write(s_5[2]);
                                 filebfwtempmeta5.newLine();
                             }
                             if(s_5[3]!=null){
                                 filebfwtempmeta5.write(s_5[3]);
                                 filebfwtempmeta5.newLine();
                             }
                             filebfwtempmeta5.write(filepathtemp5);
                             filebfwtempmeta5.newLine();
                             filebfwtempmeta5.flush();
                             filebfwtempmeta5.close();
                         }
                }
                catch(IOException exc){

                }
                file5save=true;
                break;
                }
             }
           catch(IOException exc){

           }
           try{
            BufferedWriter filesavemeta=new BufferedWriter(new FileWriter(filesavepathmeta));
                    String filesavetemp1=String.valueOf(file1save);
                    String filesavetemp2=String.valueOf(file2save);
                    String filesavetemp3=String.valueOf(file3save);
                    String filesavetemp4=String.valueOf(file4save);
                    String filesavetemp5=String.valueOf(file5save);
                    filesavemeta.write(filesavetemp1);
                    filesavemeta.newLine();
                    filesavemeta.write(filesavetemp2);
                    filesavemeta.newLine();
                    filesavemeta.write(filesavetemp3);
                    filesavemeta.newLine();
                    filesavemeta.write(filesavetemp4);
                    filesavemeta.newLine();
                    filesavemeta.write(filesavetemp5);
                    filesavemeta.flush();
                    filesavemeta.close();
        }
        catch(IOException exc){

        }
       }
       if(key1==17){//for ctrl+Q quit
        System.exit(0);
       }
       if(key1==18){//ctrl+r for resize frame
        Toolkit ttemp=Toolkit.getDefaultToolkit();
        Dimension sizetemp=ttemp.getScreenSize();
        int currentwtemp=this.getWidth();
        int currenthtemp=this.getHeight();
        if(currentwtemp==sizetemp.width||currenthtemp==sizetemp.height||count%2!=0){
            this.getRootPane().setBorder(null);
        }
        else{
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15,Color.GRAY));
        }
        if(count%2==0){
        me=true;//mutual exclusion 
        }
        else{
         me=false;
        }
        count++;
       }
      if(key1==114){// r key for select right edge fo frame for resize 
        b3=true;
        b1=false;
        b2=false;
        b4=false;
      }
      if(key1==108){ // l key for select left edge fo frame for resize
        b3=false;
        b1=true;
        b2=false;
        b4=false;
      }
      if(key1==117){ // u key for select upper edge fo frame for resize
        b3=false;
        b1=false;
        b2=true;
        b4=false;
      }
      if(key1==100){ // d key for select bottom edge fo frame for resize
        b3=false;
        b1=false;
        b2=false;
        b4=true;
      }
    }
    public void mouseClicked(MouseEvent e){
        Component c=e.getComponent();
        if(c.getName()=="CLOSE"){
            System.exit(0);
        }
        if(c.getName()=="ARRCLOSE"){
            System.exit(0);
        }
        if(c.getName()=="MINIMIZE"){
            setState(JFrame.ICONIFIED);
        }
        if(c.getName()=="ARRMINIMIZE"){
            setState(JFrame.ICONIFIED);
        }
        if(c.getName()=="RESTORE"){
            Component temp=mb.getComponent(1);
            mb.getComponent(1).setVisible(true);
            JMenu tempmenu=(JMenu)temp;
                        for(int i=6;i<9;i++){
                            tempmenu.getItem(i).setVisible(true);
                            }
            Toolkit t=Toolkit.getDefaultToolkit();
            Dimension size=t.getScreenSize();
            this.setSize(size.width/2,size.height/2);
            tx.setColumns(6);
            tx.setText("   Search");
            tx.addFocusListener(new FocusAdapter(){
                public void focusGained(FocusEvent e){
                    tx.setText(null);
                }
                public void focusLost(FocusEvent e){
                    tx.setText("   Search");
                }
            });
            exp.setPreferredSize(new Dimension(85,25));
            display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
            terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
            explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
            sp.setPreferredSize(new Dimension(this.getWidth()/6-10,this.getHeight()/2+50));
            codesp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
            index.setPreferredSize(new Dimension((this.getWidth()-this.getWidth()/6)/15,((this.getHeight()-this.getHeight()/20))/2));
        codesp.getViewport().setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
        terminalsp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
        terminaltarea.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
        if(c.getName()=="ARRRESTORE"){
            Component temp=mb.getComponent(1);
            mb.getComponent(1).setVisible(true);
            JMenu tempmenu=(JMenu)temp;
                        for(int i=6;i<9;i++){
                            tempmenu.getItem(i).setVisible(true);
                            }
            Toolkit t=Toolkit.getDefaultToolkit();
            Dimension size=t.getScreenSize();
            this.setSize(size.width/2,size.height/2);
            exp.setPreferredSize(new Dimension(85,25));
            display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
            terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
            explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
            sp.setPreferredSize(new Dimension(this.getWidth()/6-10,this.getHeight()/2+50));
            codesp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
            index.setPreferredSize(new Dimension((this.getWidth()-this.getWidth()/6)/15,((this.getHeight()-this.getHeight()/20))/2));
        codesp.getViewport().setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
        terminalsp.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
        terminaltarea.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,((this.getHeight()-this.getHeight()/20))/2));
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
    }
    public void mouseEntered(MouseEvent e){
        Component c=e.getComponent();
        if(c.getName()!="ARRCLOSE"&c.getName()!="ARRRESTORE"&c.getName()!="ARRMINIMIZE"){
        c.setSize(25, 25);
        }
    }
    public void mouseExited(MouseEvent e){
        Component c=e.getComponent();
        if(c.getName()!="ARRCLOSE"&c.getName()!="ARRRESTORE"&c.getName()!="ARRMINIMIZE"){
        c.setSize(22, 22);
        }
    }
    int posx,posy;
    public void mousePressed(MouseEvent e){
       posx=e.getX();
       posy=e.getY();

    }
    public void mouseReleased(MouseEvent e){
    
    }
    public void mouseDragged(MouseEvent e){
        if(me==true){
        int currentx=e.getX();
        int currenty=e.getY();
        int tempframex=this.getX();
        int tempframey=this.getY();
        JFrame f=(JFrame)e.getComponent();
        int currentw=f.getWidth();
        int currenth=f.getHeight();
        int windowx=e.getXOnScreen();
            int windowy=e.getYOnScreen();
        if(b3){
            int temp=windowx-(tempframex+currentw);
            this.setSize((currentw+temp), currenth);
            display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
            terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
            explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
        }
        if(b1){
            int temp=windowx-(tempframex);
            this.setSize((currentw-temp), currenth);
            this.setLocation(tempframex+temp, tempframey);
            display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
            terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
            explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
            // System.out.println(currentw);
        }
        if(b4){
            int temp=windowy-(tempframey+currenth);
            this.setSize(currentw,(currenth+temp));
            display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
            terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
            explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
        }
        if(b2){
            int temp=windowy-(tempframey);
            this.setSize(currentw,(currenth-temp));
            this.setLocation(tempframex, tempframey+temp);
            display.setPreferredSize(new Dimension(this.getWidth(),this.getHeight()));
            terminal.setPreferredSize(new Dimension(this.getWidth()-this.getWidth()/6,this.getHeight()));
            explorer.setPreferredSize(new Dimension(this.getWidth()/6,this.getHeight()));
            // System.out.println(currentw);
        }
      }
      if(me==false){
      Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
      int tempposx,tempposy;
      int tempdragx,tempdragy;
      tempdragx=e.getX();
      tempdragy=e.getY();
      tempposx=this.getX()+(tempdragx-posx);
      tempposy=this.getY()+(tempdragy-posy);
      this.setLocation(tempposx, tempposy);
      mb.setCursor(c1);
      }
    }
    public void mouseMoved(MouseEvent e){
        int currentx=e.getX();
        int currenty=e.getY();
        JFrame f=(JFrame)e.getComponent();
        int currentw=f.getWidth();
        int currenth=f.getHeight();
        Cursor c=new Cursor(Cursor.E_RESIZE_CURSOR);
        Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
        Cursor c2=new Cursor(Cursor.S_RESIZE_CURSOR);
        Boolean b,b1;
        b=(currentx>=0&currentx<15)||(currentx>currentw-15&currentx<=currentw);
        b1=(currenty>=0&currenty<15)||(currenty>currenth-15&currenty<=currenth);
        if(b){
            this.setCursor(c);
        }
        else if(b1){
                this.setCursor(c2);  
            }
        else{
            this.setCursor(c1);
        }
    }
    public void menuSelected(MenuEvent e){

        JMenu c=(JMenu)e.getSource();
        int x=c.getBorder().getBorderInsets(c).right;
        c.setBorder(BorderFactory.createMatteBorder(x, x, x, x,Color.BLACK));
    }
    public void menuDeselected(MenuEvent e){
        JMenu c=(JMenu)e.getSource();
        c.setBorder(c.getBorder());
    }
    public void menuCanceled(MenuEvent e){

    }
}
class Temp_1 implements MouseMotionListener,MouseListener{
    public void mouseClicked(MouseEvent e){
    }
    int currentx,currenty,framex,framey,currentw,currenth,framex_d,framey_d;
    public void mouseEntered(MouseEvent e){
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension size=t.getScreenSize();
        currentx=e.getX();
        currenty=e.getY();//current points
        JFrame f=(JFrame)e.getComponent();
        framex=f.getX();
        framey=f.getY();
        currentw=f.getWidth();
        currenth=f.getHeight();
        framex_d=framex+currenth;
        framey_d=framey+currentw;//x_dash,y_dash
        if(currentw==size.width||currenth==size.height){
            f.getRootPane().setBorder(null);
        }
        else if(currentw>currenth){
        if(currentx>=0||currentx<=currentw||currenty>=0||currenty<=currentw){
         f.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.CYAN ));
        }
       }
      else{
        if(currentx>=0||currentx<=currenth||currenty>=0||currenty<=currenth){
            f.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.CYAN ));
           }
       }
    }
    public void mouseExited(MouseEvent e){
        Toolkit t=Toolkit.getDefaultToolkit();
        Dimension size=t.getScreenSize();
        currentx=e.getX();
        currenty=e.getY();//current points
        JFrame f=(JFrame)e.getComponent();
        framex=f.getX();
        framey=f.getY();
        currentw=f.getWidth();
        currenth=f.getHeight();
        framex_d=framex+currenth;
        framey_d=framey+currentw;//x_dash,y_dash
        if(currentw==size.width||currenth==size.height){
            f.getRootPane().setBorder(null);
        }
       if(currentw>currenth){
        if(currentx>=0||currentx<=currentw||currenty>=0||currenty<=currentw){
        f.getRootPane().setBorder(null);
        }
       }
      else{
        if(currentx>=0||currentx<=currenth||currenty>=0||currenty<=currenth){
            f.getRootPane().setBorder(null);
           }
       }
    }
    public void mousePressed(MouseEvent e){
    
    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){
        
    }
    public void mouseMoved(MouseEvent e){

    }
}
class Temp implements MouseMotionListener,MouseListener,KeyListener{
    Boolean click=false,exit=false;
    public void mouseClicked(MouseEvent e){
        Component c=e.getComponent();
        if(c.getName()=="expdir"){//if we click on explorer then it will check name and then it will pass 
            //source of event objcet to "maind" static component
            Frame.maind=c;
        }
    }
    public void mouseEntered(MouseEvent e){
        Component c=e.getComponent();
        JPanel p=(JPanel)c;
          p.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,new Color(3, 252, 7)));
          Cursor c1=new Cursor(Cursor.DEFAULT_CURSOR);
          p.setCursor(c1);
    }
    public void mouseExited(MouseEvent e){
        Component c=e.getComponent();
        JPanel p=(JPanel)c;
        if(c.getName()=="expdir"){
            p.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.BLACK));
                Frame.maind=null;//whenever mouse exited form explorer then we pass null to "maind"
                }
    }
    public void mousePressed(MouseEvent e){
    
    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){
     
    }
    public void mouseMoved(MouseEvent e){
        
    }
    public void keyPressed(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
    }
    public void keyTyped(KeyEvent e){
    }
}
class Temp3 implements MouseMotionListener,MouseListener{
    public void mouseClicked(MouseEvent e){
        Component c=e.getComponent();
        c.setFocusable(true);
    }
    public void mouseEntered(MouseEvent e){
        Component c=e.getComponent();
        if(c.getName()=="codedir"||c.getName()=="terminaldir"){
             c.setFocusable(true);
        }
    }
    public void mouseExited(MouseEvent e){
        Component c=e.getComponent();
        c.setFocusable(false);
    }
    public void mousePressed(MouseEvent e){
    
    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){
     
    }
    public void mouseMoved(MouseEvent e){
        
    }
}
class Temp4 implements MouseMotionListener,MouseListener{
    public void mouseClicked(MouseEvent e){
       
    }
    public void mouseEntered(MouseEvent e){
        // ImageIcon orb_ext = new ImageIcon("./image/orb_extension.png");
        // Image orb_exto=orb_ext.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH);
        // ImageIcon orb_exton=new ImageIcon(orb_exto);
        // JLabel c=(JLabel)e.getComponent();
        //     c.setIcon(orb_exton);
        //     c.setForeground(new Color(3, 252, 7));
        //     c.setHorizontalTextPosition(SwingConstants.LEFT);
        //    c.setIconTextGap(10);
    }
    public void mouseExited(MouseEvent e){
        ImageIcon fileter = new ImageIcon("./image/fileter.png");
        Image filetero=fileter.getImage().getScaledInstance(12,12,Image.SCALE_SMOOTH);
        ImageIcon fileteron=new ImageIcon(filetero);
        JLabel c=(JLabel)e.getComponent();
        c.setForeground(Color.MAGENTA);
            c.setIcon(fileteron);
            c.setHorizontalTextPosition(SwingConstants.RIGHT);
            c.setIconTextGap(10);
    }
    public void mousePressed(MouseEvent e){
    
    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){
     
    }
    public void mouseMoved(MouseEvent e){
        
    }
}
class Temp5 implements MouseMotionListener,MouseListener{
    public void mouseClicked(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        JLabel c=(JLabel)e.getComponent();
        c.setIcon(null);
        c.setForeground(Color.MAGENTA);
    }
    public void mousePressed(MouseEvent e){
    
    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){
     
    }
    public void mouseMoved(MouseEvent e){
        
    }
}
public class UI_Project{
    public static void main(String args[]){
        Frame mainframe=new Frame("Orb");
    }
}