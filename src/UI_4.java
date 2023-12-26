import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.MenuItemUI;
import javax.swing.plaf.OptionPaneUI;
import javax.swing.plaf.basic.BasicMenuItemUI;
import javax.swing.plaf.basic.BasicMenuUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.w3c.dom.css.RGBColor;
import java.awt.event.*;
import java.text.SimpleDateFormat;  
import java.util.Date;  
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
    JMenuBar mb;
    JMenu arrow;
    JLabel file1,file2,file3,file4,file5;
    JLabel file1butt,file2butt,file3butt,file4butt,file5butt;
    JPanel terminal,explorer,display,exp,codepanel,codepanel_child;
    JTextArea codetarea,terminaltarea,tx,index;
    JScrollPane codesp,terminalsp,sp;
    int caretpos,prevcaretpos,count=0;
    int dirgh_enter,dirgh_enter_1=0;
    int fileselect=1,fc=1;
    int temp_new=0;
    String filenametemp1,filepathtemp1,filenametemp2,filepathtemp2,filenametemp3,filepathtemp3;
    String filenametemp4,filepathtemp4,filenametemp5,filepathtemp5;
    String fileopenpath,fileopenname;
    String filepathmeta="D:\\Project\\File_Meta.txt";
    String filefcpathmeta="D:\\Project\\File_Meta_1.txt";
    String filesavepathmeta="D:\\Project\\File_Meta_2.txt";
    File filetemp1,filetemp2,filetemp3,filetemp4,filetemp5,fcheck,fileopen;
    Boolean me=false,file1save,file2save,file3save,file4save,file5save;
    Boolean dirgh_bool=false,dirgh_bool_1=false,dirgh_bool_2=false,dirgh_bool_3=false,dirgh_bool_4=false;
    Boolean dirgh_bool_5=false,dirgh_bool_6=false;
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
        JMenu customize=new JMenu("Customize ");
        JMenuItem path=new JMenuItem("Path");
        JMenuItem project=new JMenuItem("Project");
        JMenuItem run=new JMenuItem("Run");
        JMenuItem debug=new JMenuItem("Debug");
        JMenu tools=new JMenu("Tools ");
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
        JMenu arrerrdet=new JMenu("Erorr_Detection");
        JMenu arrerrcor=new JMenu("Erorr_Correction");
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
  dtcr.setLeafIcon(tnodeon);
  dtcr.setClosedIcon(tnode2on);
  dtcr.setOpenIcon(tnode3on);
} 
        fileTree.setBackground(new Color(54, 53, 53));
        fileTree.setForeground(Color.CYAN);
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
        tertoolp.setLayout(new GridLayout(1,5,7,0));
        tertoolp.setPreferredSize(new Dimension((this.getWidth()-this.getWidth()/6)/5,this.getHeight()/20));
        tertoolp.setBackground(new Color(35, 36, 35));
        filetermenu.setCursor(c);
        settingp.setCursor(c);
        runp.setCursor(c);
        splitp.setCursor(c);
        morep.setCursor(c);
        JMenuItem file1i= new JMenuItem("File_1.Orb");
        JMenuItem file2i= new JMenuItem("File_2.Orb");
        JMenuItem file3i= new JMenuItem("File_3.Orb");
        JMenuItem file4i= new JMenuItem("File_4.Orb");
        JMenuItem file5i= new JMenuItem("File_5.Orb");
        filetermenu.add(file1i);
        filetermenu.add(file2i);
        filetermenu.add(file3i);
        filetermenu.add(file4i);
        filetermenu.add(file5i);
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
            filetermenu.getItem(m).setIcon(closeteron);
            filetermenu.getItem(m).setHorizontalTextPosition(SwingConstants.LEFT);
            filetermenu.getItem(m).setIconTextGap(5);
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
        tertoolp.add(filetermenubar);
        tertool.add(tertoolp,BorderLayout.EAST);
        JPanel terfile=new JPanel();
        terfile.setBackground(new Color(35, 36, 35));
        int widthtf=(this.getWidth()-this.getWidth()/6)
        -(this.getWidth()-this.getWidth()/6)/5;
        terfile.setPreferredSize(new Dimension(widthtf,this.getHeight()/20));
        file1=new JLabel("File_1.Orb");
        file2=new JLabel("File_2.Orb");
        file3=new JLabel("File_3.Orb");
        file4=new JLabel("File_4.Orb");
        file5=new JLabel("File_5.Orb");
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
                if(key1==10){//enter key
                    dirgh_enter=codetarea.getLineCount();
                    dirgh_bool_3=true;
                    if(dirgh_bool==false){
                        if(dirgh_bool_4!=true){
                            index.append("\n "+codetarea.getLineCount()+"   ");
                        }
                        if(dirgh_bool_4==true){
                            index.append("\n "+(codetarea.getLineCount()+1)+"   ");
                        }
                        dirgh_enter_1=dirgh_enter;
                    }
                    if(dirgh_bool==true){
                        if(dirgh_enter==dirgh_enter_1){
                            dirgh_bool=false;
                        }
                        if(dirgh_enter==2&dirgh_bool_1){
                            index.append("\n "+codetarea.getLineCount()+"   ");
                            dirgh_bool=false;
                        }
                        if(dirgh_bool_2==true){
                            // System.out.println("bool-2");
                            index.append("\n "+codetarea.getLineCount()+"   ");
                            dirgh_bool=false;
                            dirgh_bool_2=false;
                            if(dirgh_bool_6==false){
                                dirgh_bool_4=true;
                            }
                            if(dirgh_bool_6==true){
                                dirgh_bool_4=false;
                            }
                        }
                    }
                }
                if(key1==8){//backspace key
                // System.out.println(codetarea.getLineCount());
                if(dirgh_bool_3==false){
                  dirgh_enter_1=1;
                   dirgh_bool_3=true;
                }
                dirgh_bool=true;
                if(dirgh_enter_1==1&codetarea.getText().trim().isEmpty()&dirgh_bool_3==false){
                  dirgh_bool_1=true;
                  dirgh_bool=false;
                  dirgh_bool_5=true;
                  }
                  if(codetarea.getLineCount()==dirgh_enter_1&dirgh_bool_5==false){
                    dirgh_bool_2=true;
                }
                }
                if(key1==24){//ctrl+x
                    dirgh_bool=true;
                    if(dirgh_bool_3==false){
                        dirgh_enter_1=1;
                        dirgh_bool_3=true;
                      }
                        if(dirgh_enter_1==1&codetarea.getText().trim().isEmpty()&dirgh_bool_3==false){
                            dirgh_bool_1=true;
                            dirgh_bool_5=true;
                            }
                        if(codetarea.getLineCount()==dirgh_enter_1&dirgh_bool_5==false){
                            dirgh_bool_2=true;
                            dirgh_bool_6=true;
                        }
                }
                if(key1==22){//ctrl+v
                    int x;
                    if((prevcaretpos+1)!=caretpos){
                    try{
                        x=codetarea.getLineOfOffset(prevcaretpos);
                        for(int i=x+1;i<codetarea.getLineCount();i++){
                            if((i+1)>dirgh_enter_1){
                                index.append("\n "+(i+1)+"   ");
                            }
                         }
                    }
                    catch(BadLocationException j){

                    }
                }
                dirgh_enter_1=codetarea.getLineCount();
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

            }
            public void focusLost(FocusEvent e){
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
                            break;
                           case "java":
                           fileteron_1=icon_java_ext;
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
                            break;
                           case "java":
                           fileteron_2=icon_java_ext;
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
                            break;
                           case "java":
                           fileteron_3=icon_java_ext;
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
                          break;
                         case "java":
                         fileteron_4=icon_java_ext;
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
                            break;
                           case "java":
                           fileteron_5=icon_java_ext;
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
                            break;
                           case "java":
                           fileteron_1=icon_java_ext;
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
                            break;
                           case "java":
                           fileteron_2=icon_java_ext;
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
                            break;
                           case "java":
                           fileteron_3=icon_java_ext;
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
                          break;
                         case "java":
                         fileteron_4=icon_java_ext;
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
                            break;
                           case "java":
                           fileteron_5=icon_java_ext;
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
                //     JFileChooser savedialog=new JFileChooser();
                //     int tempsave=savedialog.showSaveDialog(null);
                //    if(tempsave==JFileChooser.APPROVE_OPTION){
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
                                  break;
                                 case "java":
                                 fileteron_1=icon_java_ext;
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
                               break;
                              case "java":
                              fileteron_2=icon_java_ext;
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
                                  break;
                                 case "java":
                                 fileteron_3=icon_java_ext;
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
                                  break;
                                 case "java":
                                 fileteron_4=icon_java_ext;
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
                                  break;
                                 case "java":
                                 fileteron_5=icon_java_ext;
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
                //     JFileChooser savedialog=new JFileChooser();
                //     int tempsave=savedialog.showSaveDialog(null);
                //    if(tempsave==JFileChooser.APPROVE_OPTION){
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
                                  break;
                                 case "java":
                                 fileteron_1=icon_java_ext;
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
                               break;
                              case "java":
                              fileteron_2=icon_java_ext;
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
                                  break;
                                 case "java":
                                 fileteron_3=icon_java_ext;
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
                                  break;
                                 case "java":
                                 fileteron_4=icon_java_ext;
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
                                  break;
                                 case "java":
                                 fileteron_5=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_2=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_3=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_5=icon_java_ext;
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
                 break;
                case "java":
                fileteron_2=icon_java_ext;
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
                 break;
                case "java":
                fileteron_3=icon_java_ext;
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
                 break;
                case "java":
                fileteron_4=icon_java_ext;
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
                 break;
                case "java":
                fileteron_5=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_1=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_3=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_5=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_1=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_3=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_5=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_1=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_3=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
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
                           break;
                          case "java":
                          fileteron_3=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_4=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_2=icon_java_ext;
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
                           break;
                          case "java":
                          fileteron_3=icon_java_ext;
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
                           break;
                          case "java":
                          fileteron_4=icon_java_ext;
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
                         break;
                        case "java":
                        fileteron_5=icon_java_ext;
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
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            
        }
        UIManager.put("OptionPane.background",Color.BLACK);
        UIManager.put("Panel.background",Color.BLACK);
        this.add(display);
        this.addMouseListener(new Temp_1());
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
                     break;
                    case "java":
                    fileteron_1=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_2=icon_java_ext;
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
                     break;
                    case "java":
                    fileteron_3=icon_java_ext;
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
                 break;
                case "java":
                fileteron_4=icon_java_ext;
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
                 break;
                case "java":
                fileteron_5=icon_java_ext;
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
             break;
            case "java":
            fileteron_2=icon_java_ext;
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
             break;
            case "java":
            fileteron_3=icon_java_ext;
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
             break;
            case "java":
            fileteron_4=icon_java_ext;
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
             break;
            case "java":
            fileteron_5=icon_java_ext;
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
                    break;
                   case "java":
                   fileteron_1=icon_java_ext;
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
                    break;
                   case "java":
                   fileteron_2=icon_java_ext;
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
                    break;
                   case "java":
                   fileteron_3=icon_java_ext;
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
                  break;
                 case "java":
                 fileteron_4=icon_java_ext;
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
                    break;
                   case "java":
                   fileteron_5=icon_java_ext;
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
        //     JFileChooser savedialog=new JFileChooser();
        //     int tempsave=savedialog.showSaveDialog(null);
        //    if(tempsave==JFileChooser.APPROVE_OPTION){
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
                          break;
                         case "java":
                         fileteron_1=icon_java_ext;
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
                       break;
                      case "java":
                      fileteron_2=icon_java_ext;
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
                          break;
                         case "java":
                         fileteron_3=icon_java_ext;
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
                          break;
                         case "java":
                         fileteron_4=icon_java_ext;
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
                          break;
                         case "java":
                         fileteron_5=icon_java_ext;
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
      if(key1==114){// r key for select left edge fo frame for resize 
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
      if(key1==117){ // u key for select left edge fo frame for resize
        b3=false;
        b1=false;
        b2=true;
        b4=false;
      }
      if(key1==100){ // d key for select left edge fo frame for resize
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
        // ImageIcon closeter = new ImageIcon("./image/closeter_1.png");
        // Image closetero=closeter.getImage().getScaledInstance(10,9,Image.SCALE_SMOOTH);
        // ImageIcon closeteron=new ImageIcon(closetero);
        // JLabel c=(JLabel)e.getComponent();
        //     c.setIcon(closeteron);
        //     c.setForeground(new Color(3, 252, 7));
        //     c.setHorizontalTextPosition(SwingConstants.LEFT);
        //    c.setIconTextGap(10);
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
public class UI_4{
    public static void main(String args[]){
        Frame mainframe=new Frame("Orb");
    }
}